package com.manerstech.dao;

import com.manerstech.entities.User;

public interface UserDao {
	public void addUser(User user);
	public void updateUser(User user);
	public void getUser(int id);
	public void deleteUser(User user);
}
