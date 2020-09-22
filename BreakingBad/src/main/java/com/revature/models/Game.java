package com.revature.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Entity
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Table(name="games")
public class Game implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="game_id", nullable = false)
	private int gameId;//game id
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="user_id_fk")
	private User user;
	@Column(name="score")
	private int score;
	@Column(name="game_submitted")
	private Date gameSubmitted;
	
	
	public Game() {
		super();
	}



	@Autowired
	public Game(User user, int score) {
		super();
		this.user = user;
		this.score = score;
	}


	public Game(int score, Date gameSubmitted) {
		super();
		this.score = score;
		this.gameSubmitted = gameSubmitted;
	}


	public Game(User user, int score, Date gameSubmitted) {
		super();
		this.user = user;
		this.score = score;
		this.gameSubmitted = gameSubmitted;
	}


	public Game(int gameId, User user, int score, Date gameSubmitted) {
		super();
		this.gameId = gameId;
		this.user = user;
		this.score = score;
		this.gameSubmitted = gameSubmitted;
	}


	public int getGameId() {
		return gameId;
	}


	public void setGameId(int gameId) {
		this.gameId = gameId;
	}


	public User getuser() {
		return user;
	}


	public void setuser(User user) {
		this.user = user;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public Date getGameSubmitted() {
		return gameSubmitted;
	}


	public void setGameSubmitted(Date gameSubmitted) {
		this.gameSubmitted = gameSubmitted;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	//added user.getId() so that spring knows I want this tied to a specific user id

	@Override
	public String toString() {
		return "Game [gameId=" + gameId + ", user=" + user.getUserId() + ", score=" + score + ", gameSubmitted=" + gameSubmitted
				+ "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + gameId;
		result = prime * result + ((gameSubmitted == null) ? 0 : gameSubmitted.hashCode());
		result = prime * result + score;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Game other = (Game) obj;
		if (gameId != other.gameId)
			return false;
		if (gameSubmitted == null) {
			if (other.gameSubmitted != null)
				return false;
		} else if (!gameSubmitted.equals(other.gameSubmitted))
			return false;
		if (score != other.score)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}





}
