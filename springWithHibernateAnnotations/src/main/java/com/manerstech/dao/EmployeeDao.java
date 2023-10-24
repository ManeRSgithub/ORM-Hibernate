package com.manerstech.dao;

import com.manerstech.entities.Employee;

public interface EmployeeDao {
	public void addEmployee(Employee emp);
	public void updateEmployee(Employee emp);
	public void deleteEmployee(Employee emp);
	public void getEmployee(int id);
}
