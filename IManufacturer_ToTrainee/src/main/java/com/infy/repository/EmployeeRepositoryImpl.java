package com.infy.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import com.infy.dto.EmployeeDTO;
import com.infy.entity.Employee;

@Repository(value = "employeeRepository")
public class EmployeeRepositoryImpl implements EmployeeRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Integer addEmployee(EmployeeDTO employee) {
		Employee e = new Employee();
		e.setEmployeeId(employee.getEmployeeId());
		e.setEmailId(employee.getEmailId());
		e.setName(employee.getName());
		e.setDateOfBirth(employee.getDateOfBirth());
		e.setManufacturingUnit(employee.getManufacturingUnit());
		entityManager.persist(e);
		return e.getEmployeeId();

	}
	@Override
	public EmployeeDTO getEmployeeDetails(Integer employeeId) {
	EmployeeDTO employeeDTO = null;
	Employee employee = entityManager.find(Employee.class, employeeId);
	if (employee != null) {
	employeeDTO = new EmployeeDTO();
	employeeDTO.setEmployeeId(employee.getEmployeeId());
	employeeDTO.setEmailId(employee.getEmailId());
	employeeDTO.setName(employee.getName());
	employeeDTO.setDateOfBirth(employee.getDateOfBirth());
	employeeDTO.setManufacturingUnit(employee.getManufacturingUnit());
	}
	return employeeDTO;
	}
	@Override
	public void updateEmployee(Integer employeeId, String emailId) {
	Employee employee = entityManager.find(Employee.class, employeeId);
	employee.setEmailId(emailId);
	
	}
	@Override
	public void deleteEmployee(Integer employeeId) {
	Employee employee = entityManager.find(Employee.class, employeeId);
	entityManager.remove(employee);
	
	}
}