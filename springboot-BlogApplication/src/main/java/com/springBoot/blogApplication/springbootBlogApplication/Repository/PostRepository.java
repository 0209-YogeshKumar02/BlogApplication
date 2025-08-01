package com.springBoot.blogApplication.springbootBlogApplication.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBoot.blogApplication.springbootBlogApplication.Entity.Posts;

public interface PostRepository extends JpaRepository<Posts, Long> {
	Posts findByCatidAndId(Long catid, Long id);
	
	List<Posts> findByCatidAndType(Long catid, String type);

	List<Posts> findAllByCatid(Long catid);
	
	List<Posts> findAllByUsername(String username);
}
