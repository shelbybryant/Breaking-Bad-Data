package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	
	
}
