package com.formlogin.userstorage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.formlogin.userstorage.entity.AppUser;
import com.formlogin.userstorage.repositories.AppUserRepository;

@Service
public class UserService {
	
	private final AppUserRepository userRepo;
	private final PasswordEncoder passEncoder;
	
	@Autowired
	public UserService(AppUserRepository userRepo, PasswordEncoder passEncoder) {
		this.userRepo = userRepo;
		this.passEncoder = passEncoder;
		
	}
	
	public AppUser createUser(AppUser user) {
		user.setPassword(passEncoder.encode(user.getPassword()));
		return userRepo.save(user);	
	}

}
