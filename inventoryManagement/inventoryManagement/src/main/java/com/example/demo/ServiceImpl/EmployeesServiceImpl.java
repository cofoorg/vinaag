package com.example.demo.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.EmployeesRepo;
import com.example.demo.Service.EmployeesService;
import com.example.demo.model.Employees;
@Service
public class EmployeesServiceImpl implements EmployeesService{
	@Autowired
	private EmployeesRepo employeesRepo;

	@Override
	public Employees addEmployee(Employees employee) {
		// TODO Auto-generated method stub
		return employeesRepo.save(employee);
	}

	@Override
	public Employees findEmployeeById(int employeeId) {
		// TODO Auto-generated method stub
		return employeesRepo.getByEmployeeId(employeeId);
	}

	@Override
	public Employees editEmployee(int employeeId, Employees employee) {
		// TODO Auto-generated method stub
		Employees s1=employeesRepo.getByEmployeeId(employeeId);
		
		s1.setName(employee.getName());
		s1.setAge(employee.getAge());
		s1.setDob(employee.getDob());
		s1.setQualification(employee.getQualification());
		s1.setSalary(employee.getSalary());
		
		return employeesRepo.save(s1);
	}

	@Override
	public void deleteEmployee(int employeeId) {
		// TODO Auto-generated method stub
		employeesRepo.deleteById(employeeId);
		
	}

	@Override
	public List<Employees> findAll() {
		// TODO Auto-generated method stub
		return employeesRepo.findAll();
	}
	
	
}
