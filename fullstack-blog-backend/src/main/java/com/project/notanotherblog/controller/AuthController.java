package com.project.notanotherblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.notanotherblog.dto.LoginDto;
import com.project.notanotherblog.dto.RegisterDto;
import com.project.notanotherblog.entity.User;
import com.project.notanotherblog.service.UserService;

@RestController	
@RequestMapping("api/auth")
public class AuthController {
	@Autowired
	private UserService userService;
	
	
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody RegisterDto registerDto){
		User user = userService.registerUser(registerDto);
		
		return ResponseEntity.ok("User Reistered Successfully: " + user.getEmail());
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestBody LoginDto loginDto){
		String token = userService.login(loginDto);
		return ResponseEntity.ok("Bearer " + token);
	}
}
