package com.springBoot.blogApplication.springbootBlogApplication.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.blogApplication.springbootBlogApplication.Payload.UserDTO;
import com.springBoot.blogApplication.springbootBlogApplication.Service.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/user")
class UserController {
private UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @PostMapping("/Registration")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDto){
        return new ResponseEntity<>(userService.createUser(userDto),HttpStatus.CREATED);
    }

    @GetMapping("/Login/{username}/{password}")
    public String login(@PathVariable String username,@PathVariable String password){
        return userService.login(username,password);
    }
    
    @GetMapping("/Login/{username}/{password}/profile")
    public String viewProfile(@PathVariable String username,@PathVariable String password){
        UserDTO u = userService.viewProfile(username,password);
    	return "Name : "+u.getName()+"\nAge : "+u.getAge()+"\nGender : "+u.getGender()+"\nDescription : "+u.getDescription();
    }
    
    @DeleteMapping("/Login/{username}/{password}/delete/account")
	public String deleteAccount(@PathVariable String username) {
		return userService.Delete(username);
	}
    
    @PutMapping("/Login/{username}/{pword}/updatepassword/{password}")
	public String updatePassword(@PathVariable String username,@PathVariable String password) {
		return userService.UpdatePassword(username, password);
	}
}