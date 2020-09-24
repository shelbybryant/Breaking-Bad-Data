package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
import com.revature.repositories.IUserDAO;

@RestController
@RequestMapping(value="/login")
@CrossOrigin
public class LoginController {

	private IUserDAO uDao;
//	private LoginDTO ld;

	@Autowired
	public LoginController(IUserDAO uDao) {
		super();
		this.uDao = uDao;
	}
	
	
	//this will check for specific email for the user, couldn't figure out how to check password as well
	
//	@GetMapping(value="/{email}")
//		public ResponseEntity<User> getUserByEmail(@PathVariable("email") String email) {
//			User user = uDao.findByEmail(email);
//			if(user == null) {
//				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//			} else {
//				System.out.println("You have logged in with the email: " + email);
//				return ResponseEntity.status(HttpStatus.OK).body(user);
//				
//			}
//		}
	
	@PostMapping
	public ResponseEntity<User> login(@RequestBody User user) {
		
		System.out.println("ENDPOINT REACHED");
		System.out.println("USER: " + user);
		
		if(user == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		
		 System.out.println("User:" + user);
		 
		 User databaseUser = uDao.findByEmail(user.getEmail());
		 System.out.println("database user:" + databaseUser);
		 
		 
		
		if (databaseUser.getPassword().equals(user.getPassword())) {
			System.out.println("PASSWORD IS CORRECTTTTT");
			System.out.println("YOU HAVE LOGGED IN WITH EMAIL OF " + user.getEmail() + " AND PASSWORD OF " + user.getPassword());
			return ResponseEntity.status(HttpStatus.OK).body(databaseUser);
		
		} else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
		
	}
	
}
