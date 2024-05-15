package com.example.demo.Repository;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employees;
@Repository
public interface EmployeesRepo extends JpaRepository<Employees,Integer>{
	@Query(value="select * from employees where employee_id=?",nativeQuery=true)
	public Employees getByEmployeeId(int employeeId);
	
//	 @Modifying
//    @Query("INSERT INTO Employees(name, age, dob, qualification, salary) VALUES (:name, :age, :dob, :qualification, :salary)")
//	public void addEmployee(String name,int age,Date dob,String qualification,Long salary);
	 
	
}
