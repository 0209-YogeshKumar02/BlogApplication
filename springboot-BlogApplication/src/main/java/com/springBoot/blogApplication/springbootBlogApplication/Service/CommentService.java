package com.springBoot.blogApplication.springbootBlogApplication.Service;

import java.util.List;

import com.springBoot.blogApplication.springbootBlogApplication.Payload.CommentDTO;
import com.springBoot.blogApplication.springbootBlogApplication.Payload.PostDTO;

public interface CommentService {
	CommentDTO createComment(CommentDTO commentDTO, long postid);
	CommentDTO viewComment(long id, long postid);
	List<CommentDTO> getAllComments(long postid);
	String Delete(long id);
	String UpdateContent(long id, String content);
}
