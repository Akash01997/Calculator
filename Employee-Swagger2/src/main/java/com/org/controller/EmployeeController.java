package com.org.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.exception.ResourceNotFoundException;
import com.org.model.Employee;
import com.org.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "EmployeeRestController")
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@ApiOperation(value = "Get list of Employee from the Company ", 
			response = Iterable.class, tags = "getAllEmployee")
	@GetMapping("/getEmployee")
	public List<Employee> getAllEmployee() {
		return employeeService.getEmployee();
	}

	@ApiOperation(value = "Add Employee to the Company ", 
			response = Employee.class, tags = "postEmployee")
	@PostMapping("/saveEmployee")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}

	@ApiOperation(value = "Update Employee in  the Company records ", 
			response = Employee.class, tags = "putEmployee")
	@PutMapping("/edit/{id}")
	public Employee updateEmployee(@RequestBody Employee employee, @PathVariable int id) 
			throws ResourceNotFoundException {
		return employeeService.editEmployee(employee, id);
	}

	@ApiOperation(value = "Get Employee by Id from the Company records ", 
			response = Employee.class, tags = "getEmployeeId")
	  @GetMapping("/getEmployee/{id}") 
		public Employee getEmployeeID(@PathVariable int id) throws ResourceNotFoundException{
		  return employeeService.getEmployeeById(id);
		  }
		 
	 @ApiOperation(value = "Delete Employee from the Company ", 
				response = Employee.class, tags = "deleteEmployee")
	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable int id) throws ResourceNotFoundException {

		employeeService.deleteEmployee(id); // delete the employee

		return "Employee Id is Deleted " + id;

	}

}
