package com.springBoot.blogApplication.springbootBlogApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBoot.blogApplication.springbootBlogApplication.Entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
