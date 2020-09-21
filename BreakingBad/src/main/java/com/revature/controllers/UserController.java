package com.revature.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.revature.models.User;
import com.revature.repositories.IUserDAO;

@RestController
@RequestMapping(value="/user")
@CrossOrigin
public class UserController {

	private IUserDAO uDao;

	@Autowired
	public UserController(IUserDAO uDao) {
		super();
		this.uDao = uDao;
	}
	
	@GetMapping(value="/{userId}")
	public ResponseEntity<User> findById(@PathVariable("userId") int userId) {
		Optional<User> u = Optional.of(uDao.findById(userId));
		
		if(u.isPresent()) {
			User user = u.get();
			return ResponseEntity.status(HttpStatus.OK).body(user);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	
}
