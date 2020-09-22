package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Quote;
import com.revature.models.User;

public interface IQuoteDAO extends JpaRepository<Quote, Integer> {

	List<Quote> findByUser (User userId);
	
}
