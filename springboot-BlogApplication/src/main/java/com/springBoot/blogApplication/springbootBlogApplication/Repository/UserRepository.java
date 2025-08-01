package com.springBoot.blogApplication.springbootBlogApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBoot.blogApplication.springbootBlogApplication.Entity.User;

public interface UserRepository extends JpaRepository<User, String>{

	User getByUsernameAndPassword(String username, String password);
	
}
