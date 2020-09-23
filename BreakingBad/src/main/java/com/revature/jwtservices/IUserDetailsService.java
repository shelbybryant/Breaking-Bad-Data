//This is part of Security: gets UserDetailsDAO object
package com.revature.jwtservices;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface IUserDetailsService {
	UserDetailsDAO loadUserByUsername(String email) throws UsernameNotFoundException;

}
