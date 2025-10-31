package com.project.notanotherblog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.notanotherblog.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmail(String email);
}
