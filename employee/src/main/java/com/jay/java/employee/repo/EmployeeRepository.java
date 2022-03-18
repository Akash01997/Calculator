package com.jay.java.employee.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jay.java.employee.entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
