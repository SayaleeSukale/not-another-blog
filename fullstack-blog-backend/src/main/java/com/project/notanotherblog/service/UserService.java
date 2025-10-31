package com.project.notanotherblog.service;

import com.project.notanotherblog.dto.LoginDto;
import com.project.notanotherblog.dto.RegisterDto;
import com.project.notanotherblog.entity.User;

public interface UserService {
	User saveUser(User user);

	User registerUser(RegisterDto registerDto);
	
	String login(LoginDto loginDto);
}
