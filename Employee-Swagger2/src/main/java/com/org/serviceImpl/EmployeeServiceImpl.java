package com.org.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.exception.ResourceNotFoundException;
import com.org.model.Employee;
import com.org.repository.EmployeeRepository;
import com.org.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee editEmployee(Employee employee, int employeeId) throws ResourceNotFoundException {
	
		Employee employee1 = 
			employeeRepository.findById(employeeId).orElseThrow( () -> 
	new ResourceNotFoundException("Employee Id is not found " + employeeId));
			
		employee1 = employeeRepository.saveAndFlush(employee);
		return employee1;
	//	return employeeRepository.saveAndFlush(employee);
	
		}

	@Override
	public void deleteEmployee(int employeeId) throws ResourceNotFoundException {
		
		
		
		// System.out.println(employee);
		
		 employeeRepository.deleteById(employeeId);
		
	}

	@Override
	public Employee getEmployeeById(int employeeId)throws ResourceNotFoundException {
		 
		Employee employee1 = 
				employeeRepository.findById(employeeId).orElseThrow( () -> 
		new ResourceNotFoundException("Employee Id is not found " + employeeId));
			
		return employee1;
		
	}

	
}
