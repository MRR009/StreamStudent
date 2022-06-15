package com.stg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Aspirant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int aspirantId;

	@Column(length = 35)
	private String aspirantName;

	@Column(length = 40)
	private String aspirantEmail;

	@Column(length = 20)
	private String username;

	@Column(length = 30)
	private String password;

	public Aspirant() {
		super();
	}

	public Aspirant(int aspirantId, String aspirantName, String aspirantEmail, String username, String password) {
		super();
		this.aspirantId = aspirantId;
		this.aspirantName = aspirantName;
		this.aspirantEmail = aspirantEmail;
		this.username = username;
		this.password = password;
	}

	public int getAspirantId() {
		return aspirantId;
	}

	public void setAspirantId(int aspirantId) {
		this.aspirantId = aspirantId;
	}

	public String getAspirantName() {
		return aspirantName;
	}

	public void setAspirantName(String aspirantName) {
		this.aspirantName = aspirantName;
	}

	public String getAspirantEmail() {
		return aspirantEmail;
	}

	public void setAspirantEmail(String aspirantEmail) {
		this.aspirantEmail = aspirantEmail;
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

}
