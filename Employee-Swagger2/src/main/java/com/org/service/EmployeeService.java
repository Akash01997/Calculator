package com.org.service;

import java.util.List;

import com.org.exception.ResourceNotFoundException;
import com.org.model.Employee;

public interface EmployeeService {

	public List<Employee> getEmployee();
	public Employee saveEmployee(Employee employee);
	public Employee editEmployee(Employee employee, int employeeId) throws ResourceNotFoundException;
	public void deleteEmployee(int id) throws ResourceNotFoundException;
	public Employee getEmployeeById(int employeeId)throws ResourceNotFoundException;
	
}
