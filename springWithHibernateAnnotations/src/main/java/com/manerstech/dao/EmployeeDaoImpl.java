package com.manerstech.dao;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.manerstech.entities.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	
	private HibernateTemplate hibernateTemplate;
	

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
	@Override
	public void addEmployee(Employee emp) {
		try {
			hibernateTemplate.save(emp);
			System.out.println("Congrats! Employee added successfully...");
		}catch(Exception e) {
			System.out.println("Ooopppsss! Some error occured. Read the description below: ");
			e.printStackTrace();
		}
	}
	
	@Transactional
	@Override
	public void updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
         try {
        	 hibernateTemplate.update(emp);
        	 
        	 System.out.println("Congrats! Employee updated successfully...");
		}catch(Exception e) {
			
			System.out.println("Ooopppsss! Some error occured. Read the description below: ");
			e.printStackTrace();
		}
	}
	
	@Transactional
	@Override
	public void deleteEmployee(Employee emp) {
		// TODO Auto-generated method stub
        try {
			hibernateTemplate.delete(emp);
        	System.out.println("Congrats! Employee deleted successfully...");
		}catch(Exception e) {
			
			System.out.println("Ooopppsss! Some error occured. Read the description below: ");
			e.printStackTrace();
		}
	}
	
	@Transactional
	@Override
	public void getEmployee(int id) {
		// TODO Auto-generated method stub
        try {
			Employee emp=(Employee) hibernateTemplate.get(Employee.class, id);
			System.out.println("Employee Name: "+emp.getName());
			System.out.println("Employee Email: "+emp.getEmail());
			System.out.println("Employee Salary: "+emp.getSalary());
        	System.out.println("Congrats! Employee details fetched successfully...");
		}catch(Exception e) {
			
			System.out.println("Ooopppsss! Some error occured. Read the description below: ");
			e.printStackTrace();
		}
	}

}
