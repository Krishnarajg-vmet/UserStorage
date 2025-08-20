package com.formlogin.userstorage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.formlogin.userstorage.entity.AppUser;
import com.formlogin.userstorage.service.UserService;

@Controller
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
		
	@GetMapping("/public/users")
	public String userPage() {
		return "users";
	}
	
	@PostMapping("/public/users")
	public String createUser(@ModelAttribute AppUser user) {
	    // Spring will bind fields based on name matching
	    userService.createUser(user);
	    System.out.println(user.getUsername() + " " + user.getPassword() + " " + user.getRoles());
	    return "redirect:/public/users";
	}


}
