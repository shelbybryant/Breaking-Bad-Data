package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.User;

@Repository
public interface IUserDAO extends JpaRepository<User, Integer> {

	User findById (int userId);
	User findByEmail (String email);
	User findByScreenName(String name);
	User findByPassword(String password);
	
//	User login(String email, String password);
	
	
}
