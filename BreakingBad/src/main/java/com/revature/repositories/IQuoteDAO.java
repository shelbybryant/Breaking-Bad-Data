package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Quote;

public interface IQuoteDAO extends JpaRepository<Quote, Integer> {

	Quote findByUser (int userId);
	
}
