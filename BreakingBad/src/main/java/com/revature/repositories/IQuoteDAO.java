package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Quote;
import com.revature.models.User;

@Repository
public interface IQuoteDAO extends JpaRepository<Quote, Integer> {

	List<Quote> findByUser (User user);

	

	
	
}
