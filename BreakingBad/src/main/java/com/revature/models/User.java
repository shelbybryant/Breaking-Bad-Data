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
	public int userId;
	@Column(name="screen_name", unique=true)
	public String screenName;
	@Column(name="email")
	public String email;
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


	public User(String screenName, String email, String password, int runningTotal, int gamesTotal) {
		super();
		this.screenName = screenName;
		this.email = email;
		this.password = password;
		this.runningTotal = runningTotal;
		this.gamesTotal = gamesTotal;
	}


	public User(int userId, String screenName, String email, String password, int runningTotal, int gamesTotal) {
		super();
		this.userId = userId;
		this.screenName = screenName;
		this.email = email;
		this.password = password;
		this.runningTotal = runningTotal;
		this.gamesTotal = gamesTotal;
	}
	
	public User(int user_id) {
		super();
		this.userId = user_id;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getScreenName() {
		return screenName;
	}


	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
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
		return "User [userId=" + userId + ", screenName=" + screenName + ", email=" + email + ", password=" + password
				+ ", runningTotal=" + runningTotal + ", gamesTotal=" + gamesTotal + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + gamesTotal;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + runningTotal;
		result = prime * result + ((screenName == null) ? 0 : screenName.hashCode());
		result = prime * result + userId;
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
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (gamesTotal != other.gamesTotal)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (runningTotal != other.runningTotal)
			return false;
		if (screenName == null) {
			if (other.screenName != null)
				return false;
		} else if (!screenName.equals(other.screenName))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}


	
	
}
