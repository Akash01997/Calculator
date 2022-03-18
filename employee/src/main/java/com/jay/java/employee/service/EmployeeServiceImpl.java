package com.jay.java.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jay.java.employee.entity.Employee;
import com.jay.java.employee.repo.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
EmployeeRepository employeeRepository;
	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	@Override
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}
	@Override
	public Employee getEmployee(int id) {
		Optional<Employee> empContainer =  employeeRepository.findById(id);
		if(empContainer.isPresent()) {
			return empContainer.get();
		}else {
			return new Employee();
			//throw new RuntimeException("Employee Not Found.");
		}
	}
	@Override
	public String deleteEmployees() {
		try {
		employeeRepository.deleteAll();
		}catch(Exception e) {
			return "Error in Deletion: "+e.getMessage();
		}
		return "All Employees Deleted Successfully";
	}
	@Override
	public String deleteEmployeeById(int id) {
		try {
			employeeRepository.deleteById(id);
		}catch(Exception e) {
			return "Error in Deleting the Employee With ID -: "+id;
		}
		return "Successfully deleted!!";
		
	}
	@Override
	public String updateEmployeeById(int id, Employee employee) {
		try{
			Optional<Employee> employeeContainer = employeeRepository.findById(id);
		
		if(employeeContainer.isPresent()) {
			Employee oldEmployee = employeeContainer.get();
			oldEmployee.setDepartment(employee.getDepartment());
			oldEmployee.setDesignation(employee.getDesignation());
			oldEmployee.setName(employee.getName());
			employeeRepository.saveAndFlush(oldEmployee);
			return "Succesfully Updated!";
		}
		return "The Employee Id"+id+" is not present";
		}catch(Exception e) {
		return "Error in Update "+e.getMessage();
		}
	}

}
