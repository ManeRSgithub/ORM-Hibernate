package com.manerstech.springWithHibernateAnnotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.manerstech.dao.EmployeeDao;
import com.manerstech.entities.Employee;
import com.manerstech.resources.SpringConfigFile;

public class App 
{
    public static void main( String[] args )
    {
       Employee emp=new Employee();
       emp.setId(2);
       emp.setName("Rushikesh S. Mane");
       emp.setEmail("rushikeshmane@gmail.com");
       emp.setSalary(32345.56);
       
       
       ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfigFile.class);
       EmployeeDao empDao=(EmployeeDao) context.getBean("EmployeeDaoImpl");
       empDao.addEmployee(emp);
       
//       empDao.getEmployee(1);
//       empDao.updateEmployee(emp);
    }
}
