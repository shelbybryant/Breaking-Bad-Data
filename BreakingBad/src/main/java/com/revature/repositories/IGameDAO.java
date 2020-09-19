package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Game;
import com.revature.models.User;

public interface IGameDAO extends JpaRepository<Game, Integer> {

	Game findByUser (User userId);
	Game findById (int id);
}
