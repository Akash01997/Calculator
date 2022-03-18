package com.infosys.restful.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.restful.employee.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
