package com.springBoot.blogApplication.springbootBlogApplication.Service.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springBoot.blogApplication.springbootBlogApplication.Entity.Category;
import com.springBoot.blogApplication.springbootBlogApplication.Entity.Comments;
import com.springBoot.blogApplication.springbootBlogApplication.Entity.Posts;
import com.springBoot.blogApplication.springbootBlogApplication.Payload.CategoryDTO;
import com.springBoot.blogApplication.springbootBlogApplication.Payload.CommentDTO;
import com.springBoot.blogApplication.springbootBlogApplication.Payload.PostDTO;
import com.springBoot.blogApplication.springbootBlogApplication.Repository.CategoryRepository;
import com.springBoot.blogApplication.springbootBlogApplication.Repository.PostRepository;
import com.springBoot.blogApplication.springbootBlogApplication.Service.CategoryService;
import com.springBoot.blogApplication.springbootBlogApplication.Service.PostService;

@Service
public class CategoryServiceImpl implements CategoryService {
	private CategoryRepository CategoryRepository;
	private PostService PostService;
	private PostRepository PostRepository;
	
	public CategoryServiceImpl(CategoryRepository categoryRepository, PostService postService, PostRepository postRepository) {
		this.CategoryRepository = categoryRepository;
		this.PostService = postService;
		this.PostRepository = postRepository;
	}
	
	private Category mapFromDTO(CategoryDTO categoryDTO) {
		Category cat = new Category();
		cat.setName(categoryDTO.getName());
		return cat;
	}
	
	private CategoryDTO mapFromEntity(Category cat) {
		CategoryDTO catDto = new CategoryDTO();
		catDto.setId(cat.getId());
		catDto.setName(cat.getName());
		return catDto;
	}
	
	@Override
	public CategoryDTO createCategory(CategoryDTO categoryDTO) {
		// TODO Auto-generated method stub
        Category cat = mapFromDTO(categoryDTO);
		
		Category catDto = CategoryRepository.save(cat);
		
		CategoryDTO response = mapFromEntity(catDto);
		
		return response;
	}

	@Override
	public CategoryDTO viewCategory(Long id) {
		// TODO Auto-generated method stub
		Category cat = CategoryRepository.getReferenceById(id);
		
		CategoryDTO response = mapFromEntity(cat);
		
		return response;
	}

	@Override
	public List<CategoryDTO> getAllCategories() {
		// TODO Auto-generated method stub
		List<Category> c = CategoryRepository.findAll();
		
		List<CategoryDTO> response = new ArrayList<CategoryDTO>();
		
		for(Category cat : c) {
			CategoryDTO responseDTO = mapFromEntity(cat);
			
			response.add(responseDTO);
		}
		return response;
	}

	@Override
	public String Delete(Long id) {
		// TODO Auto-generated method stub
		CategoryRepository.deleteById(id);
		
		List<Posts> p = PostRepository.findAllByCatid(id);		
		List<PostDTO> response = new ArrayList<PostDTO>();
		for(Posts post : p) {
			PostService.Delete(post.getId());
		}
		
		return "Category with id : "+id+" is deleted";
	}

	@Override
	public String UpdateName(Long id, String name) {
		// TODO Auto-generated method stub
		Category cat = CategoryRepository.getReferenceById(id);
		cat.setName(name);
		
		CategoryRepository.save(cat);
		
		return "Category updated successfully";
	}

}
