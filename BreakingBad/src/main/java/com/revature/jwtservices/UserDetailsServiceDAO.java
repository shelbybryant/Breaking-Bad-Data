/*
 * This class implements IUserDetailsServoce and overrides its method
 * Gets full custom User object using UserRepository, 
 * then it builds a UserDetailsDAO object using static build() method.
 */

package com.revature.jwtservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.jwtrepositories.UserRepository;
import com.revature.models.User;

@Service
public class UserDetailsServiceDAO implements IUserDetailsService {
	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional
	public UserDetailsDAO loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with email: " + email));

		return UserDetailsDAO.build(user);
	}

}