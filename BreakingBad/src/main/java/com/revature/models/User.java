package com.revature.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
@Entity
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Table(name="users")
public class User implements Serializable{

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id", nullable=false)
	public long userId;
	@Column(name="username", unique=true)
	public String username;
	@Column(name="user_password")
	public String password;
	//this is to help keep track of how many points a user has accumulated over games
	//also for displaying top leader in leader board
	@Column(name="running_total")
	public int runningTotal;
	@Column(name="games_total")
	public int gamesTotal;
	
	
	public User() {
		super();
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}



	public User(String username, String password, int runningTotal, int gamesTotal) {
		super();
		this.username = username;
		this.password = password;
		this.runningTotal = runningTotal;
		this.gamesTotal = gamesTotal;
	}


	public User(long userId, String username, String password, int runningTotal, int gamesTotal) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.runningTotal = runningTotal;
		this.gamesTotal = gamesTotal;
	}
	
	public User(long user_id) {
		super();
		this.userId = user_id;
	}


	public long getUserId() {
		return userId;
	}


	public void setUserId(long userId) {
		this.userId = userId;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getRunningTotal() {
		return runningTotal;
	}


	public void setRunningTotal(int runningTotal) {
		this.runningTotal = runningTotal;
	}


	public int getGamesTotal() {
		return gamesTotal;
	}


	public void setGamesTotal(int gamesTotal) {
		this.gamesTotal = gamesTotal;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password
				+ ", runningTotal=" + runningTotal + ", gamesTotal=" + gamesTotal + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + gamesTotal;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + runningTotal;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + (int) (userId ^ (userId >>> 32));
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (gamesTotal != other.gamesTotal)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (runningTotal != other.runningTotal)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}


	


	
	
}
