/*
 * The following sites were used to develop the Spring Security portions of this code:
 * https://dzone.com/articles/spring-boot-security-json-web-tokenjwt-hello-world
 *https://www.baeldung.com/spring-security-authentication-with-a-database
 * https://bezkoder.com/spring-boot-jwt-authentication/
 */

package com.revature.jwtcontrollers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.revature.models.User;
import com.revature.payloadjwtreq.LoginRequest;
import com.revature.payloadjwtreq.RegisterRequest;
import com.revature.payloadjwtres.JwtResponse;
import com.revature.payloadjwtres.MsgResponse;
import com.revature.repositories.UserRepository;
import com.revature.securityjwt.JwtUtils;
import com.revature.servicesjwt.ImpsUDetails;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/bb/auth")
public class AuthController {
	LoginRequest loginRequest;
	RegisterRequest registerRequest;
	
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;
	
	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@Value @RequestBody loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		ImpsUDetails uDetails = (ImpsUDetails) authentication.getPrincipal();		

		return ResponseEntity.ok(new JwtResponse(jwt, 
												 uDetails.getId(), 
												 uDetails.getUsername()
												 ));
	}

	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@Value @RequestBody registerRequest) {
		if (userRepository.existsByUsername(registerRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MsgResponse("Error: Username is taken"));
		}

		if (userRepository.existsByUsername(registerRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MsgResponse("Error: Oops. SOmething went wrong."));
		}

		// Create new user's account
		User user = new User(registerRequest.getUsername(), 
							 encoder.encode(registerRequest.getPassword()),
							 0,0);
	}
}


