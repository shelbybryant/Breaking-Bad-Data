package com.revature.jwtservices;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.revature.models.User;
import com.revature.repositories.IUserDAO;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDetailsDAO implements IUserDetailsDAO {

	private int id;

	private String screenName;

	private String email;

	@JsonIgnore
	private String password;

	public UserDetailsDAO(int id, String screenName, String email, String password) {
		this.id = id;
		this.screenName = screenName;
		this.email = email;
		this.password = password;
	}

	public static UserDetailsDAO build(User user) {
		return new UserDetailsDAO(
				user.getUserId(), 
				user.getScreenName(), 
				user.getEmail(),
				user.getPassword()
		);
	}

	public int getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getScreenName() {
		return screenName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsDAO user = (UserDetailsDAO) o;
		return Objects.equals(id, user.id);
	}

}