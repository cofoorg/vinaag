package com.example.demo.model;



import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Employees {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int employeeId;
	private String name;
	private int age;
	@DateTimeFormat(pattern="YYYY-MM-DD")
	private Date dob;
	private String qualification;
	private Long salary;
	
	@Override
	public String toString() {
		return "Employees [employeeId=" + employeeId + ", name=" + name + ", age=" + age + ", dob=" + dob + ", qualification="
				+ qualification + ", salary=" + salary + "]";
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int empId) {
		this.employeeId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}
	
	
}
