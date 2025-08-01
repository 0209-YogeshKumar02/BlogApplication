package com.springBoot.blogApplication.springbootBlogApplication.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="comments")
public class Comments {
	@Id
	@GeneratedValue(
		strategy = GenerationType.IDENTITY
	)
	Long id;
	
	@Column(name="content",nullable=false)
	String content;
	
	@Column(name="postid",nullable=false)
	Long postid;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getPostid() {
		return postid;
	}

	public void setPostid(Long postid) {
		this.postid = postid;
	}
	
	
}
