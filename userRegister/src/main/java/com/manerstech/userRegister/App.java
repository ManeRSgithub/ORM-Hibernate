package com.manerstech.userRegister;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.manerstech.entities.userRegister;

public class App 
{
    public static void main( String[] args )
    {
        userRegister register=new userRegister();
//        register.setId(1);
//        register.setName("Shrinivas S. THodsare");
//        register.setEmail("shrinivas@gmail.com");
//        register.setContactNO("+91-9876543266");
//        
        Configuration config=new Configuration();
        config.configure("/com/manerstech/resources/hibernate.cfg.xml");
        
        SessionFactory sessionfactory= config.buildSessionFactory();
        Session session= sessionfactory.openSession();
        
        Transaction transaction= session.beginTransaction();
        
        try {
        	register= session.get(userRegister.class, 3) ;
        	register.setId(3);
        	
        	session.delete(register);
        	System.out.println("Congrats! Data deleted successfully...");
        	transaction.commit();
        	
        }catch(Exception e) {
        	System.out.println("Oops! Some error occured. Check below description.");
        	transaction.rollback();
        	e.printStackTrace();
        }
        finally {
        	session.close();
        	sessionfactory.close();
        }
        
    }
}
