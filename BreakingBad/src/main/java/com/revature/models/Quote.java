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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Entity
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Table(name="quotes")
public class Quote implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="quote_id")
	private int quoteId;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="user_id_fk", referencedColumnName="user_id")
	private User user;
	@Column(name="author_firstname")
	private String authorFName;
	@Column(name="author_lastname")
	private String authorLName;
	@Column(name="author_quote")
	private String authorQuote;
	
	public Quote() {
		super();
		System.out.println("\n\nQuote constructor #0..");
	
	}

	public Quote(String authorFName, String authorLName, String authorQuote) {
		super();
		System.out.println("\n\nQuote constructor #1..");
		this.authorFName = authorFName;
		this.authorLName = authorLName;
		this.authorQuote = authorQuote;
	}

	@Autowired
	public Quote(User user, String authorFName, String authorLName, String authorQuote) {
		super();
		System.out.println("\n\nQuote constructor #2..");
		System.out.println("user: " + user);
		System.out.println("authorFName: " + authorFName);
		System.out.println("authorQuote: " + authorQuote);
		this.user = user;
		this.authorFName = authorFName;
		this.authorLName = authorLName;
		this.authorQuote = authorQuote;
	}


	public Quote(int quoteId, User user, String authorFName, String authorLName, String authorQuote) {
		super();
		System.out.println("\n\nQuote constructor #3..");
		this.quoteId = quoteId;
		this.user = user;
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


	public User getuser() {
		return user;
	}


	public void setuser(User user) {
		this.user = user;
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


	//added user.getId() so that spring knows I want this tied to a specific user id
	
	@Override
	public String toString() {
		return "Quote [quoteId=" + quoteId + ", user=" + user.getUserId() + ", authorFName=" + authorFName + ", authorLName="
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
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	

}
