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

import com.revature.models.Game;
import com.revature.models.Quote;
import com.revature.models.User;
import com.revature.repositories.IGameDAO;
import com.revature.repositories.IUserDAO;

@RestController
@RequestMapping(value="/game")
@CrossOrigin
public class GameController {

	private IUserDAO uDao;
	private IGameDAO gDao;
	
	@Autowired
	public GameController(IUserDAO uDao, IGameDAO gDao) {
		super();
		this.uDao = uDao;
		this.gDao = gDao;
	}
	
	@GetMapping
	public ResponseEntity<List<Game>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(gDao.findAll());
	}
	
	@GetMapping(value="/{userId}")
	public ResponseEntity<List<Game>> findByUser(@PathVariable("userId") User userId) {
		Optional<List<Game>> g = Optional.of(gDao.findByUser(userId));
		if(g.isPresent()) {
			List<Game> games = (List<Game>) g.get();
			return new ResponseEntity<List<Game>>(games, HttpStatus.OK);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	
	@PostMapping
	public ResponseEntity<List<Game>> newGame(@RequestBody Game game) {
		System.out.println("GAME " + game);
		gDao.save(game);
		return ResponseEntity.status(HttpStatus.CREATED).build(); //do not need to show all games
	}
	
	
	
	
	
	
}
