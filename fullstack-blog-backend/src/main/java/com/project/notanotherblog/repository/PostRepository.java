package com.project.notanotherblog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.notanotherblog.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
	List<Post> findByCategory(String category);  //Add Pagination
	List<Post> findByTitle(String title);
}
