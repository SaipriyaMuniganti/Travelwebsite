package com.TravelWebsite.GetAwayGuru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.TravelWebsite.GetAwayGuru.model.User;
import com.TravelWebsite.GetAwayGuru.service.UserService;

@RestController
@RequestMapping("/GetAwayGuru")
@CrossOrigin("*")
public class UserController {
    @Autowired
	private UserService userService;
    
	@PostMapping("/signup")
	public String signup(@RequestBody User user) {
		
		return userService.createNewuser(user);
		
	}
	
	
	
	
}
