package com.jay.java.employee.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jay.java.employee.entity.Employee;
import com.jay.java.employee.service.EmployeeService;

@RestController
public class EmployeeCtrl {
	@Autowired
	EmployeeService employeeService;
 @PostMapping("/employees")
 public Employee createEmployee(@RequestBody Employee employee) {
	 return employeeService.saveEmployee(employee);
 }
 
 @GetMapping("/employees")
 public List<Employee> getEmployees(){
	 return employeeService.getEmployees();
 }
 
 @GetMapping("/employees/{id}")
 public Employee getEmployeeById(@PathVariable int id) {
	 return employeeService.getEmployee(id);
 }
 
 @DeleteMapping("/employees")
 public String deleteAllEmployees() {
	 return employeeService.deleteEmployees();
 }
 
 @DeleteMapping("/employees/{id}")
 public String deleteEmployee(@PathVariable int id) {
	 return employeeService.deleteEmployeeById(id);
 }
 
 @PutMapping("/employees/{id}")
 public String updateEmployees(@PathVariable int id,@RequestBody Employee employee)
 {
	 return employeeService.updateEmployeeById(id,employee);
 }
}
