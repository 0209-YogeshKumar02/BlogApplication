package com.springBoot.blogApplication.springbootBlogApplication.Service.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springBoot.blogApplication.springbootBlogApplication.Entity.Comments;
import com.springBoot.blogApplication.springbootBlogApplication.Entity.Posts;
import com.springBoot.blogApplication.springbootBlogApplication.Payload.CommentDTO;
import com.springBoot.blogApplication.springbootBlogApplication.Payload.PostDTO;
import com.springBoot.blogApplication.springbootBlogApplication.Repository.CommentRepository;
import com.springBoot.blogApplication.springbootBlogApplication.Repository.PostRepository;
import com.springBoot.blogApplication.springbootBlogApplication.Service.CommentService;
import com.springBoot.blogApplication.springbootBlogApplication.Service.PostService;

@Service
public class PostServiceImpl implements PostService {
	private PostRepository PostRepository;
	private CommentService CommentService;
	private CommentRepository CommentRepository;

	public PostServiceImpl(PostRepository postRepository, CommentService CommentService,
			CommentRepository CommentRepository) {
		this.PostRepository = postRepository;
		this.CommentService = CommentService;
		this.CommentRepository = CommentRepository;
	}

	private Posts mapFromDTO(PostDTO postDTO) {
		Posts post = new Posts();
		post.setTitle(postDTO.getTitle());
		post.setDescription(postDTO.getDescription());
		post.setContent(postDTO.getContent());
		post.setCatid(postDTO.getCatid());
		post.setLikes(postDTO.getLikes());
		post.setType(postDTO.getType());
		post.setUsername(postDTO.getUsername());
		return post;
	}

	private PostDTO mapFromEntity(Posts post) {
		PostDTO postResponse = new PostDTO();
		postResponse.setId(post.getId());
		postResponse.setTitle(post.getTitle());
		postResponse.setDescription(post.getDescription());
		postResponse.setContent(post.getContent());
		postResponse.setCatid(post.getCatid());
		postResponse.setLikes(post.getLikes());
		postResponse.setType(post.getType());
		postResponse.setUsername(post.getUsername());
		return postResponse;
	}

	@Override
	public PostDTO createPost(PostDTO postDTO, String username, Long catid) {
		// DTO converted into entity
		Posts post = mapFromDTO(postDTO);
		post.setCatid(catid);
		post.setLikes(0);
		post.setUsername(username);

		Posts postdto1 = PostRepository.save(post);

		// convert entity into DTO
		PostDTO postResponse = mapFromEntity(postdto1);

//		return postResponse;
		return postResponse;
	}

	@Override
	public PostDTO viewPost(Long id, Long catid) {
		// TODO Auto-generated method stub
		Posts post = PostRepository.findByCatidAndId(catid, id);

		PostDTO postResponse = mapFromEntity(post);

		return postResponse;
	}

	@Override
	public List<PostDTO> getAllPosts(Long catid) {
		// TODO Auto-generated method stub
		List<Posts> post = PostRepository.findAllByCatid(catid);
		
		List<PostDTO> response = new ArrayList<PostDTO>();
		
		for(Posts p : post) {
			PostDTO responseDTO = mapFromEntity(p);
			
			response.add(responseDTO);
		}
		return response;
	}

	@Override
	public String Delete(Long id) {
		// TODO Auto-generated method stub
		Posts post = PostRepository.getReferenceById(id);
		PostRepository.delete(post);

		List<Comments> c = CommentRepository.findAllByPostid(id);
		List<CommentDTO> response = new ArrayList<CommentDTO>();
		for (Comments comment : c) {
			CommentService.Delete(comment.getId());
		}

		return "Post with id : " + id + " is deleted";
	}

	@Override
	public String UpdateTitle(Long id, String title) {
		// TODO Auto-generated method stub
		Posts post = PostRepository.getReferenceById(id);
		post.setTitle(title);

		PostRepository.save(post);

		return "Title updated successfully";
	}

	@Override
	public String UpdateLikes(Long id) {
		// TODO Auto-generated method stub
		Posts post = PostRepository.getReferenceById(id);
		post.setLikes(post.getLikes()+1);

		PostRepository.save(post);

		return "Likes updated successfully";
	}

	@Override
	public List<PostDTO> viewPosttype(String type, Long catid) {
		// TODO Auto-generated method stub
		List<Posts> post = PostRepository.findByCatidAndType(catid, type);
		
		List<PostDTO> response = new ArrayList<PostDTO>();
		
		for(Posts p : post) {
			PostDTO responseDTO = mapFromEntity(p);
			
			response.add(responseDTO);
		}
		return response;
	}

	@Override
	public List<PostDTO> getAllPostsByUsername(String username) {
		// TODO Auto-generated method stub
		List<Posts> post = PostRepository.findAllByUsername(username);
		
		List<PostDTO> response = new ArrayList<PostDTO>();
		
		for(Posts p : post) {
			PostDTO responseDTO = mapFromEntity(p);
			
			response.add(responseDTO);
		}
		return response;
	}

}
