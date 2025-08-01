package com.springBoot.blogApplication.springbootBlogApplication.Service;

import java.util.List;

import com.springBoot.blogApplication.springbootBlogApplication.Payload.PostDTO;

public interface PostService {
	PostDTO createPost(PostDTO postDTO, String username, Long catid);

	PostDTO viewPost(Long id, Long catid);
	
	List<PostDTO> viewPosttype(String type, Long catid);

	List<PostDTO> getAllPosts(Long catid);

	String Delete(Long id);

	String UpdateTitle(Long id, String title);
	
	String UpdateLikes(Long id);
	
	List<PostDTO> getAllPostsByUsername(String username);
}
