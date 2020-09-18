package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Game;

public interface IGameDAO extends JpaRepository<Game, Integer> {

	Game findByUser (int userId);
	Game findById (int id);
}
