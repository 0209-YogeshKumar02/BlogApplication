package com.springBoot.blogApplication.springbootBlogApplication.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBoot.blogApplication.springbootBlogApplication.Entity.Comments;

public interface CommentRepository extends JpaRepository<Comments, Long>{
	Comments findByPostidAndId(Long postid, Long id);
	List<Comments> findAllByPostid(Long postid);
}
