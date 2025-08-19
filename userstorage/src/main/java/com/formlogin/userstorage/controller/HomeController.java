package com.formlogin.userstorage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/dashboard")
	public String homePage() {
		return "home";
	}

}
