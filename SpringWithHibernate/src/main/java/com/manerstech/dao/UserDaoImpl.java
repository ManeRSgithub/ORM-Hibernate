package com.manerstech.dao;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.manerstech.entities.User;

public class UserDaoImpl implements UserDao {
	
	private HibernateTemplate hibernateTemplate;
	
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
	@Override
	public void addUser(User user) {
		try {
			hibernateTemplate.save(user);
			System.out.println("Congrats! User added successfully...");
			
		}catch(Exception e) {
			System.out.println("Oops...Some error occured.To know more, check below description.");
			e.printStackTrace();
		}
	}
	@Transactional
	@Override
	public void updateUser(User user) {
		try {
			hibernateTemplate.update(user);
			System.out.println("Congrats! User updated successfully...");
		}catch(Exception e) {
			System.out.println("Oopppsss! Some error occured. Check out the below description...");
			e.printStackTrace();
		}
		
	}
	@Transactional
	@Override
	public void deleteUser(User user) {
		try {
			hibernateTemplate.delete(user);
			System.out.println("Congrats! User deleted successfully...");
		}catch(Exception e) {
			System.out.println("Ooopppsss! Some error occured. Check description below...");
			e.printStackTrace();
		}
		
	}
	@Transactional
	@Override
	public void getUser(int id) {
		try {
			User user=(User) hibernateTemplate.get(User.class, id);
			System.out.println("Congrats! User details are: ");
			System.out.println("User Id: "+user.getId());
			System.out.println("User Name: "+user.getName());
			System.out.println("User Email: "+user.getEmail());
			System.out.println("User Password: "+user.getPassword());
		}catch(Exception e) {
			System.out.println("Ooppppsss! Some error occured. Check the description below:");
			e.printStackTrace();
		}
		
		
	}

	
	
	
	
	
		
	
	
	

}
