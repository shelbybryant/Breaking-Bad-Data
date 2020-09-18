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
	
	@GetMapping(value="/game/{userId}")
	public ResponseEntity<Game> getGameByUser(@PathVariable("userId") int userId) {
		Optional<Game> g = Optional.of(gDao.findByUser(userId));
		
		if(g.isPresent()) {
			Game game = g.get();
			return ResponseEntity.status(HttpStatus.FOUND).body(game);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Game> findById(@PathVariable("id") int id) {
		Optional<Game> g = Optional.of(gDao.findById(id));
		
		if(g.isPresent()) {
			Game game = g.get();
			return ResponseEntity.status(HttpStatus.OK).body(game);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PostMapping
	public ResponseEntity<List<Game>> newGame(@RequestBody Game game) {
		gDao.save(game);
		return ResponseEntity.status(HttpStatus.CREATED).build(); //do not need to show all games
	}
	
	
	
	
	
	
}
