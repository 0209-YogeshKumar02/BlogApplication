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

import com.springBoot.blogApplication.springbootBlogApplication.Exceptions.ResourceNotFoundException;
import com.springBoot.blogApplication.springbootBlogApplication.Payload.CommentDTO;
import com.springBoot.blogApplication.springbootBlogApplication.Payload.PostDTO;
import com.springBoot.blogApplication.springbootBlogApplication.Service.CommentService;
import com.springBoot.blogApplication.springbootBlogApplication.Service.PostService;
import com.springBoot.blogApplication.springbootBlogApplication.Service.ServiceImpl.CommentServiceImpl;

@RestController
@RequestMapping("api/post/{postid}/comment")
public class CommentController {
private CommentService commentService;
	
	public CommentController(CommentService commentService) {
		this.commentService = commentService;
	}
	
	@PostMapping
	public ResponseEntity<CommentDTO> createComment(@RequestBody CommentDTO commentDto, @PathVariable long postid){
		return new ResponseEntity<>(commentService.createComment(commentDto,postid),HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public CommentDTO viewComment(@PathVariable Long id, @PathVariable long postid){
		if(commentService.viewComment(id, postid)==null) {
			
		}
		return commentService.viewComment(id, postid);
	}
	
	@GetMapping
	public List<CommentDTO> getAllComments(@PathVariable long postid){
		return commentService.getAllComments(postid);
	}
	
	@DeleteMapping("{id}")
	public String deleteComment(@PathVariable Long id) {
		return commentService.Delete(id);
	}
	
	@PutMapping("{id}/{content}")
	public String updatePost(@PathVariable Long id,@PathVariable String content) {
		return commentService.UpdateContent(id, content);
	}
}
