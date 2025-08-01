package com.springBoot.blogApplication.springbootBlogApplication.Service.ServiceImpl;

import java.util.ArrayList;

import java.util.List;

 

import org.springframework.stereotype.Service;

 

import com.springBoot.blogApplication.springbootBlogApplication.Entity.Category;

import com.springBoot.blogApplication.springbootBlogApplication.Entity.Comments;

import com.springBoot.blogApplication.springbootBlogApplication.Entity.Posts;

import com.springBoot.blogApplication.springbootBlogApplication.Entity.User;

import com.springBoot.blogApplication.springbootBlogApplication.Payload.CategoryDTO;

import com.springBoot.blogApplication.springbootBlogApplication.Payload.CommentDTO;

import com.springBoot.blogApplication.springbootBlogApplication.Payload.UserDTO;

import com.springBoot.blogApplication.springbootBlogApplication.Repository.CategoryRepository;

import com.springBoot.blogApplication.springbootBlogApplication.Repository.CommentRepository;

import com.springBoot.blogApplication.springbootBlogApplication.Repository.UserRepository;

import com.springBoot.blogApplication.springbootBlogApplication.Service.PostService;

import com.springBoot.blogApplication.springbootBlogApplication.Service.UserService;

 

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private User mapFromDTO(UserDTO userDTO) {
        User u= new User();
        u.setName(userDTO.getName());
        u.setUsername(userDTO.getUsername());
        u.setPassword(userDTO.getPassword());
        u.setAge(userDTO.getAge());
        u.setGender(userDTO.getGender());
        u.setDescription(userDTO.getDescription());
        return u;

    }
    
    private UserDTO mapFromEntity(User u) {
        UserDTO userDto = new UserDTO();
        userDto.setName(u.getName());
        userDto.setUsername(u.getUsername());
        userDto.setPassword(u.getPassword());
        userDto.setAge(u.getAge());
        userDto.setGender(u.getGender());
        userDto.setDescription(u.getDescription());
        return userDto;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        // TODO Auto-generated method stub
        User u = mapFromDTO(userDTO);
        User cdto = userRepository.save(u);
        UserDTO userResponse = mapFromEntity(cdto);
        return userResponse;
    }

    @Override
    public String login(String username, String password) {
    	
        User user = userRepository.getByUsernameAndPassword(username,password);
        if(user!=null){
            return "Login Sucessful";
        }
        else {
        	return "Login Failed";
        }
    }

	@Override
	public UserDTO viewProfile(String username, String password) {
		// TODO Auto-generated method stub
		User user = userRepository.getByUsernameAndPassword(username,password);
		
		UserDTO response = mapFromEntity(user);
		
		return response;
	}

	@Override
	public String Delete(String username) {
		// TODO Auto-generated method stub
		userRepository.deleteById(username);
		return "Account with id : "+username+" is deleted";
	}

	@Override
	public String UpdatePassword(String username, String password) {
		// TODO Auto-generated method stub
		User u = userRepository.getReferenceById(username);
		u.setPassword(password);
		
		userRepository.save(u);
		
		return "Password updated successfully";
	}


}
