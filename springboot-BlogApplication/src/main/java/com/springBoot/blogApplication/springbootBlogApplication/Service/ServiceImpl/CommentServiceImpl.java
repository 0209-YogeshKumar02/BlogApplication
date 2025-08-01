package com.springBoot.blogApplication.springbootBlogApplication.Service.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springBoot.blogApplication.springbootBlogApplication.Entity.Comments;
import com.springBoot.blogApplication.springbootBlogApplication.Exceptions.ResourceNotFoundException;
import com.springBoot.blogApplication.springbootBlogApplication.Payload.CommentDTO;
import com.springBoot.blogApplication.springbootBlogApplication.Repository.CommentRepository;
import com.springBoot.blogApplication.springbootBlogApplication.Service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	private CommentRepository CommentRepository;
	
	public CommentServiceImpl(CommentRepository commentRepository) {
		this.CommentRepository = commentRepository;
	}

	public Comments mapFromDTO(CommentDTO commentDTO) {
		Comments c = new Comments();
		c.setContent(commentDTO.getContent());
		c.setPostid(commentDTO.getPostid());
		return c;
	}
	
	public CommentDTO mapFromEntity(Comments comment) {
		CommentDTO postResponse = new CommentDTO();
		postResponse.setId(comment.getId());
		postResponse.setContent(comment.getContent());
		postResponse.setPostid(comment.getPostid());
		return postResponse;
	}
	
	@Override
	public CommentDTO createComment(CommentDTO commentDTO, long postid) {
		// TODO Auto-generated method stub
        Comments c = mapFromDTO(commentDTO);
        c.setPostid(postid);
		
		Comments cdto = CommentRepository.save(c);
		
		
		CommentDTO commentResponse = mapFromEntity(cdto);
		
		return commentResponse;
	}

	@Override
	public CommentDTO viewComment(long id, long postid){
		// TODO Auto-generated method stub
        Comments comment = CommentRepository.findByPostidAndId(postid, id);
        
        CommentDTO commentResponse = mapFromEntity(comment);
		
		return commentResponse;
	}

	@Override
	public List<CommentDTO> getAllComments(long pid){
		// TODO Auto-generated method stub
		List<Comments> c = CommentRepository.findAllByPostid(pid);
		
		List<CommentDTO> response = new ArrayList<CommentDTO>();
		
		for(Comments comment : c) {
			CommentDTO responseDTO = mapFromEntity(comment);
			
			response.add(responseDTO);
		}
		return response;
	}

	@Override
	public String Delete(long id) {
		// TODO Auto-generated method stub
		CommentRepository.deleteById(id);
		return "Comment with id : "+id+" is deleted";
	}

	@Override
	public String UpdateContent(long id, String content) {
		// TODO Auto-generated method stub
		Comments comment = CommentRepository.getReferenceById(id);
		comment.setContent(content);
		
		CommentRepository.save(comment);
		
		return "Comment updated successfully";
	}

}
