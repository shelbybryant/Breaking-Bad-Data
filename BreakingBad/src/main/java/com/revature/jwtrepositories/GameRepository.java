package com.revature.jwtrepositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Game;
import com.revature.models.User;

public interface GameRepository extends JpaRepository<Game, Integer> {

	List<Game> findByUser (User userId);
	Game findById (int id);
}
