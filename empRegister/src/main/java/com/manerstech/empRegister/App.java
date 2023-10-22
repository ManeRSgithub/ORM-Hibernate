package com.manerstech.empRegister;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.manerstech.entities.employeeRegister;

public class App 
{
    public static void main( String[] args )
    {
        employeeRegister emp=new employeeRegister();
        
        Configuration cfg=new Configuration();
        cfg.configure("/com/manerstech/resources/hibernate.cfg.xml");
        
        SessionFactory sessionfactory= cfg.buildSessionFactory();
        Session session= sessionfactory.openSession();
        Transaction transaction= session.beginTransaction(); 
       
        try {
        	emp=session.get(employeeRegister.class, 3);
        	
        	
        	session.delete(emp);
        	transaction.commit();
        	System.out.println("Success");
        }catch(Exception e) {
        	System.out.println("Failed...");
        	e.printStackTrace();
        	transaction.rollback();
        }
        finally {
        	session.close();
        	sessionfactory.close();
        }
        
    }
}
