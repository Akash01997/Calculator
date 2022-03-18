package com.jay.java.employee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jay.java.employee.entity.Employee;
@Service
public interface EmployeeService {

	Employee saveEmployee(Employee employee);

	List<Employee> getEmployees();

	Employee getEmployee(int id);

	String deleteEmployees();

	String deleteEmployeeById(int id);

	String updateEmployeeById(int id, Employee employee);

}
