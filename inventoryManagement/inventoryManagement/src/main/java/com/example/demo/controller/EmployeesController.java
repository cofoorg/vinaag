package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.EmployeesService;
import com.example.demo.model.Employees;

@RestController
@CrossOrigin
@RequestMapping("/employees")
public class EmployeesController {
	@Autowired
	private EmployeesService employeesService;
	
	@PostMapping("/add")
	public Employees addEmployee(@RequestBody Employees employee) {
		System.out.println(employee);
		return employeesService.addEmployee(employee);
	}
	
	@GetMapping("/get/{employeeId}")
	public Employees getEmployee(@PathVariable int employeeId) {
		return employeesService.findEmployeeById(employeeId);
	}
	
	@PutMapping("/update/{employeeId}")
	public Employees updateEmployee(@PathVariable int employeeId,@RequestBody Employees employee) {
		return employeesService.editEmployee(employeeId,employee);
	}
	
	@DeleteMapping("/delete/{employeeId}")
	public void deleteEmployee(@PathVariable int employeeId) {
		employeesService.deleteEmployee(employeeId);
	}
	
	@GetMapping("/getall")
	public List<Employees> getAllEmployees(){
		return employeesService.findAll();
	}
}
