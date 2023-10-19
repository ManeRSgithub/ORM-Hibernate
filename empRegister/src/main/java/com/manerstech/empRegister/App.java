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
        emp.setId(101);
        emp.setName("Akash kadam");
        emp.setEmail("akashkadam@gmail.com");
        emp.setBalance(32500.98);
        System.out.println();
        
        Configuration cfg=new Configuration();
        cfg.configure("/com/manerstech/resources/hibernate.cfg.xml");
        
        SessionFactory sessionfactory= cfg.buildSessionFactory();
        Session session= sessionfactory.openSession();
        
        Transaction transaction= session.beginTransaction();
        try {
        	session.save(emp);
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
