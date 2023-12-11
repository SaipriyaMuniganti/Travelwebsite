package com.TravelWebsite.GetAwayGuru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TravelWebsite.GetAwayGuru.model.User;
import com.TravelWebsite.GetAwayGuru.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private EmailSenderService emailSenderService;
	
	public String createNewuser(User user) {
		
		if(userRepo.existsByUsername(user.getUsername())) {
			return "Username already taken";
		}else {
		userRepo.save(user);
		sendWelcomeEmail(user.getEmail(),user.getUsername());
		return "User signup successfully";
		}
		
	}
	
	
	
	public String loginUser(String username, String password) {
		
		User user = userRepo.findByUsername(username);
		if(user != null && user.getPassword().equals(password)) {
			return "Welcome "+username;
		}else {
			return "Invalid username or password";
		}	
		
	}
	
	private void sendWelcomeEmail(String userEmail,String username) {
        String subject = "Welcome to GetAwayGuru- Your Passport to Unforgettable Adventures!";
        
        String body = "Dear "+username+","+"\n"+"\nWe are thrilled to welcome you to GetAwayGuru! Your account has been successfully created, and you are now part of our growing community."
        		+ "\n"+"\nHere are the details of your account:"+"\n"+"\n*Username : "+username+"\n*Email : "+userEmail+"\n"+"\nThank you for choosing GetAwayGuru. We look forward to providing you with an exceptional experience!"
        		+"\n"+"\nBest regards,"+"\n"+"\nThe GetAwayGuru Team";
        emailSenderService.sendEmail("getawaygurua@gmail.com", userEmail, subject, body);
    }
	
	
	
}
