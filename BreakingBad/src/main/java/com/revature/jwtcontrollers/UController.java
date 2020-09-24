package com.revature.jwtcontrollers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/bb/users")
public class UController {
	
	@GetMapping("/user")
	public String userAccess() {
		return "User Content.";
	}

}
