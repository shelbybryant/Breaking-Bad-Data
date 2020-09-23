package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.User;

public interface IUserDAO extends JpaRepository<User, Integer> {

	User findById (int userId);
	User findByEmail (String email);
	User findByScreenName(String name);
}
