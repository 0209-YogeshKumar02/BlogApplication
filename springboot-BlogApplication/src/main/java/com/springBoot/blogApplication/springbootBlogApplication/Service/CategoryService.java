package com.springBoot.blogApplication.springbootBlogApplication.Service;

import java.util.List;

import com.springBoot.blogApplication.springbootBlogApplication.Payload.CategoryDTO;


public interface CategoryService {
	CategoryDTO createCategory(CategoryDTO categoryDTO);
	CategoryDTO viewCategory(Long id);
	List<CategoryDTO> getAllCategories();
	String Delete(Long id);
	String UpdateName(Long id, String name);
}
