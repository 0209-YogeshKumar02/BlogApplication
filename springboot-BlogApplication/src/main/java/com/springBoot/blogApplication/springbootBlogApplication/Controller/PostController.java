package com.springBoot.blogApplication.springbootBlogApplication.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.blogApplication.springbootBlogApplication.Payload.PostDTO;
import com.springBoot.blogApplication.springbootBlogApplication.Service.PostService;

@RestController
@RequestMapping("/api/user/{username}/category/{catid}/post")
public class PostController {
	private PostService postService;
	
	public PostController(PostService postService) {
		this.postService = postService;
	}
	
	@PostMapping
	public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDto, @PathVariable String username, @PathVariable long catid){
		return new ResponseEntity<>(postService.createPost(postDto, username, catid),HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public PostDTO viewPost(@PathVariable Long id, @PathVariable Long catid){
		return postService.viewPost(id, catid);
	}
	
	@GetMapping("type/{type}")
	public List<PostDTO> viewPost(@PathVariable String type, @PathVariable Long catid){
		return postService.viewPosttype(type, catid);
	}
	
	@GetMapping
	public List<PostDTO> getAllPosts(@PathVariable Long catid){
		return postService.getAllPosts(catid);
	}
	
	@GetMapping("/userpost")
	public List<PostDTO> getAllPostsByUsername(@PathVariable String username){
		return postService.getAllPostsByUsername(username);
	}
	
	@DeleteMapping("{id}")
	public String deletePost(@PathVariable Long id) {
		return postService.Delete(id);
	}
	
	@PutMapping("{id}/{title}")
	public String updatePost(@PathVariable Long id,@PathVariable String title) {
		return postService.UpdateTitle(id, title);
	}
	
	@PutMapping("{id}/like")
	public String updateLikes(@PathVariable Long id) {
		return postService.UpdateLikes(id);
	}
}
