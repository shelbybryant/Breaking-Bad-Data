package com.revature.jwtservices;

public interface IUserDetailsDAO {
	
	
	int getId();
	String getEmail();
	String getScreenName();
	String getPassword();
	boolean isAccountNonExpired();
	boolean isCredentialsNonExpired();
	boolean isEnabled();	

}
