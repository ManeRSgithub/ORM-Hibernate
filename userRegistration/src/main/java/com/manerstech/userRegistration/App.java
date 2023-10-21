package com.manerstech.userRegistration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.manerstech.entities.userRegister;

public class App 
{
    public static void main( String[] args )
    {
        userRegister uReg=new userRegister();
        uReg.setId(102);
        uReg.setName("Rushikesh Mane");
        uReg.setEmail("rushikeshmane@gmail.com");
        uReg.setContactNo("+91-9876543210");
        uReg.setPassword("Pass@123");
        System.out.println("-------------------------");
        
//        create configuration object
        Configuration cfg=new Configuration();
        
//        configure the hibernate configuration file using configuration object
        cfg.configure("/com/manerstech/resources/hibernate.cfg.xml");
        
//        create sessionfactory object using configuration object
        SessionFactory sessionfactory= cfg.buildSessionFactory();
        
//        create session object
        Session session= sessionfactory.openSession();
        
//        create transaction object
        Transaction transaction= session.beginTransaction();
        
        try {
        	session.save(uReg);
        	System.out.println("Success...");
        	transaction.commit();
        }catch(Exception e) {
        	System.out.println("Failed...");
        	transaction.rollback();
        	e.printStackTrace();
        } 
        finally {
        	session.close();
        	sessionfactory.close();
        }
        
    }
}
