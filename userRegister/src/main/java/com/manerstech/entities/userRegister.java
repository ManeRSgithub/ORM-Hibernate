package com.manerstech.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userRegister_details")
public class userRegister {
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="user_name")
	private String name;
	@Column(name="user_email")
	private String email;
	@Column(name="user_contactNo")
	private String contactNO;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNO() {
		return contactNO;
	}
	public void setContactNO(String contactNO) {
		this.contactNO = contactNO;
	}
	
}
