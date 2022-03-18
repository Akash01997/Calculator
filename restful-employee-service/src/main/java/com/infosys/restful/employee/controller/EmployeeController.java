package com.infosys.restful.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.restful.employee.model.Employee;
import com.infosys.restful.employee.repository.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@RequestMapping(value = "/save", method = RequestMethod.PUT)
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}
	
	
	@RequestMapping(value = "/getEmployee/{empId}", method = RequestMethod.GET)
	public Employee getEmployee(@PathVariable int empId) {
		return employeeRepository.findById(empId).get();
	}
	
	@RequestMapping(value = "/removeEmployee/{empId}", method = RequestMethod.DELETE)
	public void deleteEmployee(@PathVariable int empId) {
		employeeRepository.deleteById(empId);
	}
	
	
	
	
	
	
	
	
	
	
	

}
