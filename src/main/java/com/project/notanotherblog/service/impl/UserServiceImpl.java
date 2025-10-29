package com.project.notanotherblog.service.impl;

import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.notanotherblog.dto.RegisterDto;
import com.project.notanotherblog.entity.Role;
import com.project.notanotherblog.entity.User;
import com.project.notanotherblog.repository.RoleRepository;
import com.project.notanotherblog.repository.UserRepository;
import com.project.notanotherblog.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public User saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		Role role = roleRepository.findByName("ROLE_USER")
				.orElse(new Role(null, "Role_User"));
		
		user.setRolesOfUser(Collections.singleton(role));
		
		return userRepository.save(user);
	}

	@Override
	public User registerUser(RegisterDto registerDto) {
		 User user = new User();
	        user.setName(registerDto.getName());
	        user.setEmail(registerDto.getEmail());
	        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

	        Optional<Role> optionalRole = roleRepository.findByName("ROLE_USER");
	        Role role;

	        if (optionalRole.isPresent()) {
	            role = optionalRole.get();
	        } else {
	            role = new Role();
	            role.setName("ROLE_USER");
	            role = roleRepository.save(role);
	        }

	        user.getRolesOfUser().add(role);

	        return userRepository.save(user);
	}
	
	
	

}
