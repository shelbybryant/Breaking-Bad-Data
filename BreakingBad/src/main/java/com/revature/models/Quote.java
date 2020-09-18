package com.revature.models;

import java.io.Serializable;

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
@Table(name="quotes")
public class Quote implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="quote_id")
	private int quoteId;
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private int userId;
	@Column(name="author_firstname")
	private String authorFName;
	@Column(name="author_lastname")
	private String authorLName;
	@Column(name="author_quote")
	private String authorQuote;
	

	public Quote() {
		super();
		
	}


	public Quote(int userId, String authorFName, String authorLName, String authorQuote) {
		super();
		this.userId = userId;
		this.authorFName = authorFName;
		this.authorLName = authorLName;
		this.authorQuote = authorQuote;
	}


	public Quote(int quoteId, int userId, String authorFName, String authorLName, String authorQuote) {
		super();
		this.quoteId = quoteId;
		this.userId = userId;
		this.authorFName = authorFName;
		this.authorLName = authorLName;
		this.authorQuote = authorQuote;
	}


	public int getQuoteId() {
		return quoteId;
	}


	public void setQuoteId(int quoteId) {
		this.quoteId = quoteId;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getAuthorFName() {
		return authorFName;
	}


	public void setAuthorFName(String authorFName) {
		this.authorFName = authorFName;
	}


	public String getAuthorLName() {
		return authorLName;
	}


	public void setAuthorLName(String authorLName) {
		this.authorLName = authorLName;
	}


	public String getAuthorQuote() {
		return authorQuote;
	}


	public void setAuthorQuote(String authorQuote) {
		this.authorQuote = authorQuote;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Quote [quoteId=" + quoteId + ", userId=" + userId + ", authorFName=" + authorFName + ", authorLName="
				+ authorLName + ", authorQuote=" + authorQuote + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authorFName == null) ? 0 : authorFName.hashCode());
		result = prime * result + ((authorLName == null) ? 0 : authorLName.hashCode());
		result = prime * result + ((authorQuote == null) ? 0 : authorQuote.hashCode());
		result = prime * result + quoteId;
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
		Quote other = (Quote) obj;
		if (authorFName == null) {
			if (other.authorFName != null)
				return false;
		} else if (!authorFName.equals(other.authorFName))
			return false;
		if (authorLName == null) {
			if (other.authorLName != null)
				return false;
		} else if (!authorLName.equals(other.authorLName))
			return false;
		if (authorQuote == null) {
			if (other.authorQuote != null)
				return false;
		} else if (!authorQuote.equals(other.authorQuote))
			return false;
		if (quoteId != other.quoteId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	

}
