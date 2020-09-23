package com.revature.jwtrepositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findById(long uId);
	Optional<User> findByUsername(String username);
}
