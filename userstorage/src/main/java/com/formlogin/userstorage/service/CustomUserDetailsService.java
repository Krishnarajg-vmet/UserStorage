package com.formlogin.userstorage.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.formlogin.userstorage.entity.AppUser;
import com.formlogin.userstorage.repositories.AppUserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private AppUserRepository userRepo;
	
	public CustomUserDetailsService(AppUserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		AppUser users = userRepo.findByUsername(username)
				.orElseThrow(()->new UsernameNotFoundException("Username not found"));
		
		return User.withUsername(users.getUsername())
				.password(users.getPassword())
				.authorities(users.getRoles().toArray(new String[0]))
				.build();
	}

}
