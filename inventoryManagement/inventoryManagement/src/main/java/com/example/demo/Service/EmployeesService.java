package com.example.demo.Service;

import java.util.List;

import com.example.demo.model.Employees;

public interface EmployeesService {
	public Employees addEmployee(Employees employee);
	public Employees findEmployeeById(int employeeId);
	public Employees editEmployee(int employeeId,Employees employee);
	public void deleteEmployee(int employeeId);
	public List<Employees> findAll();
}
