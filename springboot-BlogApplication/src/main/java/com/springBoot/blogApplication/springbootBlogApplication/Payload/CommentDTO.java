package com.springBoot.blogApplication.springbootBlogApplication.Payload;

public class CommentDTO {
	Long id;
	String content;
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
