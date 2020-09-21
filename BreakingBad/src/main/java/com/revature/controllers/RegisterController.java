package com.revature.controllers;

import java.util.List;

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
@RequestMapping(value="/register")
@CrossOrigin
public class RegisterController {

	private IUserDAO uDao;

	@Autowired
	public RegisterController(IUserDAO uDao) {
		super();
		this.uDao = uDao;
	}
	
	@PostMapping
	public ResponseEntity<List<User>> newUser(@RequestBody User user) {
		uDao.save(user);
		System.out.println("User was added!");
		return ResponseEntity.status(HttpStatus.CREATED).build(); 
	}
	
	
}
