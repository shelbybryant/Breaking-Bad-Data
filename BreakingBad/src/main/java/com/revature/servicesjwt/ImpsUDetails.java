package com.revature.servicesjwt;

import java.util.Collection;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.revature.models.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class ImpsUDetails implements UserDetails {

	private static final long serialVersionUID = 1L;

	private long id;
	
	private String username;

	@JsonIgnore
	private String password;

	public ImpsUDetails(long id, String username, String password) {
		this.id = id;
		this.setUsername(username);
		this.password = password;
	}

	public static ImpsUDetails build(User user) {
		return new ImpsUDetails(
				user.getUserId(),
				user.getUsername(),
				user.getPassword()
		);
	}

	public long getId() {
		return id;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String getPassword() {
		return password;
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
		ImpsUDetails user = (ImpsUDetails) o;
		return Objects.equals(id, user.id);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}


}