package com.revature.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Quote;
import com.revature.models.User;
import com.revature.repositories.IGameDAO;
import com.revature.repositories.IQuoteDAO;
import com.revature.repositories.IUserDAO;

@RestController
@RequestMapping(value="/quote")
@CrossOrigin
public class QuoteController {

	IUserDAO uDao;
	IQuoteDAO qDao;
	IGameDAO gDao;
	
	@Autowired
	public QuoteController(IUserDAO uDao, IQuoteDAO qDao, IGameDAO gDao) {
		super();
		this.uDao = uDao;
		this.qDao = qDao;
		this.gDao = gDao;
	}
	
	
	@GetMapping(value="/{userId}")
	public ResponseEntity<List<Quote>> findByUser(@PathVariable("userId") User userId) {
		Optional<List<Quote>> q = Optional.of(qDao.findByUser(userId));
		if(q.isPresent()) {
			List<Quote> quotes = (List<Quote>) q.get();
			return new ResponseEntity<List<Quote>>(quotes, HttpStatus.OK);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PostMapping
	public ResponseEntity<List<Quote>> newQuote(@RequestBody Quote quote) {
		
		System.out.println("QUOTE: " + quote);
		qDao.save(quote);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
}
