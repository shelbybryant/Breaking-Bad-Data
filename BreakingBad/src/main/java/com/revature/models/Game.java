package com.revature.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Game")
public class Game implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="game_id", nullable = false)
	private int gameId;//game id
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private int userId;
	@Column(name="score")
	private int score;
	@Column(name="game_submitted")
	private Date Gameubmitted;
	
	
	public Game() {
		super();
	}


	public Game(int score, Date Gameubmitted) {
		super();
		this.score = score;
		this.Gameubmitted = Gameubmitted;
	}


	public Game(int userId, int score, Date Gameubmitted) {
		super();
		this.userId = userId;
		this.score = score;
		this.Gameubmitted = Gameubmitted;
	}


	public Game(int gameId, int userId, int score, Date Gameubmitted) {
		super();
		this.gameId = gameId;
		this.userId = userId;
		this.score = score;
		this.Gameubmitted = Gameubmitted;
	}


	public int getGameId() {
		return gameId;
	}


	public void setGameId(int gameId) {
		this.gameId = gameId;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public Date getGameubmitted() {
		return Gameubmitted;
	}


	public void setGameubmitted(Date Gameubmitted) {
		this.Gameubmitted = Gameubmitted;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Game [gameId=" + gameId + ", userId=" + userId + ", score=" + score + ", Gameubmitted="
				+ Gameubmitted + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + gameId;
		result = prime * result + ((Gameubmitted == null) ? 0 : Gameubmitted.hashCode());
		result = prime * result + score;
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
		Game other = (Game) obj;
		if (gameId != other.gameId)
			return false;
		if (Gameubmitted == null) {
			if (other.Gameubmitted != null)
				return false;
		} else if (!Gameubmitted.equals(other.Gameubmitted))
			return false;
		if (score != other.score)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
}
