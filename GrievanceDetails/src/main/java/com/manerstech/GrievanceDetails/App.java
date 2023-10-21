package com.manerstech.GrievanceDetails;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.manerstech.entities.GrievanceDetails;

public class App 
{
    public static void main( String[] args )
    {
        GrievanceDetails details=new GrievanceDetails();
        
        details.setName("Akash");
        details.setEmail("Akash@gmail.com");
        details.setContactNo("+91-9876543221");
        details.setMessage("I'm unable to pay and submit my form");
        System.out.println();
        
        Configuration config=new Configuration();
        config.configure("/com/manerstech/resources/hibernate.cfg.xml");
        
        SessionFactory sessionfactory= config.buildSessionFactory();
        Session session= sessionfactory.openSession();
        
        Transaction transaction= session.beginTransaction();
        
        try {
        	session.save(details);
        	System.out.println("Data saved successfully...");
        	transaction.commit();
        }catch(Exception e) {
        	System.out.println("Error occured while saving the data...Please check");
        	transaction.rollback();
        	e.printStackTrace();
        }
        finally {
        	session.close();
        	sessionfactory.close();
        }
        
        
        
        
    }
}
