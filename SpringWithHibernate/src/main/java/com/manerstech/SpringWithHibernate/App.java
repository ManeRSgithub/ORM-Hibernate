package com.manerstech.SpringWithHibernate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.manerstech.dao.UserDao;
import com.manerstech.entities.User;

class App 
{
    public static void main( String[] args )
    {
    	User user=new User();
    	user.setId(5);
    	user.setName("Shridhar Jadhav");
    	user.setEmail("shridharJ@gmail.com");
    	user.setPassword("Shridhar@123");
    	
    	ApplicationContext context=new ClassPathXmlApplicationContext("/com/manerstech/resources/applicationContext.xml");
    	UserDao userDao=(UserDao) context.getBean("UserDaoImplBean");
//    	userDao.addUser(user);
//    	userDao.updateUser(user);
//    	userDao.getUser(5);
    	userDao.deleteUser(user);
    	
    }
}
