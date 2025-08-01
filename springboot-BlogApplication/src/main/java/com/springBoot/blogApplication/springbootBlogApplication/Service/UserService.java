package com.springBoot.blogApplication.springbootBlogApplication.Service;

import com.springBoot.blogApplication.springbootBlogApplication.Payload.UserDTO;

public interface UserService {
	UserDTO createUser(UserDTO userDTO);
	String login(String username, String password);
	UserDTO viewProfile(String username, String password);
	String Delete(String username);
	String UpdatePassword(String username, String password);
}
