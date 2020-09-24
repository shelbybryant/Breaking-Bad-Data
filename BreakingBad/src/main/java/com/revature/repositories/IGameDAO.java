package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Game;
import com.revature.models.User;

@Repository
public interface IGameDAO extends JpaRepository<Game, Integer> {

	List<Game> findByUser (User userId);
	Game findById (int id);
}
