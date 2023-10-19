package com.manerstech.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="empRegister")
public class employeeRegister {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="empId")
	private int id;
	
	@Column(name="empName")
	private String name;
	
	@Column(name="empEmail")
	private String email;
	
	@Column(name="empBalance")
	private double balance;
	
	
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
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
}
