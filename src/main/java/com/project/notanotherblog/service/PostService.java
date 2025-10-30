package com.project.notanotherblog.service;

import java.util.List;

import com.project.notanotherblog.entity.Post;

public interface PostService {
	Post createPost(Post post);
	List<Post> getAllPosts();
	Post getPostById(Long id);
	Post updatePostById(Long id, Post post);
	void deletePost(Long id);
	
}
