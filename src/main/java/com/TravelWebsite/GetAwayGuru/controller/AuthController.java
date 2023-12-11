package com.TravelWebsite.GetAwayGuru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TravelWebsite.GetAwayGuru.model.User;
import com.TravelWebsite.GetAwayGuru.service.AdminService;
import com.TravelWebsite.GetAwayGuru.service.UserService;

@RestController
@RequestMapping("/GetAwayGuru")
@CrossOrigin("*")
public class AuthController {
	@Autowired
	private UserService userService;
	@Autowired
	private AdminService adminService;

	@PostMapping("/login")
	public String login(@RequestBody User user) {
		
		String username = user.getUsername();
		String password = user.getPassword();
		
		if(username.equals("admin")) {
			return adminService.AdminLogin(username, password);
		}else {
			return userService.loginUser(username, password);
		}
		
	}
}
