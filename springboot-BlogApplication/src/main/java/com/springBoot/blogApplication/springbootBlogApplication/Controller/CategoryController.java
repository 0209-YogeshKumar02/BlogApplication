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
import com.springBoot.blogApplication.springbootBlogApplication.Payload.CategoryDTO;
import com.springBoot.blogApplication.springbootBlogApplication.Service.CategoryService;
import com.springBoot.blogApplication.springbootBlogApplication.Service.UserService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

	private CategoryService CategoryService;

	public CategoryController(CategoryService catService) {
		this.CategoryService = catService;
	}

	@PostMapping
	public ResponseEntity<CategoryDTO> createcategory(@RequestBody CategoryDTO catDto){
		return new ResponseEntity<>(CategoryService.createCategory(catDto),HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public CategoryDTO viewCategory(@PathVariable Long id){
		return CategoryService.viewCategory(id);
	}
	
	@GetMapping
	public List<CategoryDTO> getAllCategories(){
		return CategoryService.getAllCategories();
	}
	
	@DeleteMapping("{id}")
	public String deleteCategory(@PathVariable Long id) {
		return CategoryService.Delete(id);
	}
	
	@PutMapping("{id}/{name}")
	public String updatePost(@PathVariable Long id,@PathVariable String name) {
		return CategoryService.UpdateName(id, name);
	}
}
