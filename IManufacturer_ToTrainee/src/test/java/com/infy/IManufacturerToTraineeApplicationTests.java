package com.infy;

import java.time.LocalDate;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.infy.dto.EmployeeDTO;
import com.infy.dto.ManufacturingUnit;
import com.infy.repository.EmployeeRepository;
import com.infy.service.EmployeeService;
import com.infy.service.EmployeeServiceImpl;

@SpringBootTest
public class IManufacturerToTraineeApplicationTests {
	
	@Mock
	private EmployeeRepository employeeRepository;
	
	@InjectMocks
	private EmployeeService employeeServiceImpl = new EmployeeServiceImpl();

	@Test
	public void addEmployeeInvalidEmailId() throws Exception {
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setEmployeeId(2007);
			employeeDTO.setName("Wilson");
			employeeDTO.setEmailId("wilson@mail.com");
			employeeDTO.setDateOfBirth(LocalDate.of(1996, 4, 10));
			employeeDTO.setManufacturingUnit(ManufacturingUnit.U001);
			EmployeeDTO employeeDTO1 = new EmployeeDTO();
			employeeDTO1.setEmployeeId(2007);
			employeeDTO1.setName("Wilson");
			employeeDTO1.setEmailId("wilson@mail9.com");
			employeeDTO1.setDateOfBirth(LocalDate.of(1996, 4, 10));
			employeeDTO1.setManufacturingUnit(ManufacturingUnit.U001);

	Mockito.when(employeeRepository.getEmployeeDetails(2007)).thenReturn(employeeDTO);

		Exception ex= Assertions.assertThrows(Exception.class, ()-> 
employeeServiceImpl.addEmployee(employeeDTO1));
		Assertions.assertEquals("Validator.INVALID_EMAIL_ID", ex.getMessage());
}
@Test
public void getEmployeeInvalidEmployeeId() throws Exception {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setEmployeeId(2007);
		employeeDTO.setName("Wilson");
		employeeDTO.setEmailId("wilson@mail.com");
		employeeDTO.setDateOfBirth(LocalDate.of(1996, 4, 10));
		employeeDTO.setManufacturingUnit(ManufacturingUnit.U001);
		EmployeeDTO employeeDTO1 = new EmployeeDTO();
		employeeDTO1.setEmployeeId(null);
		employeeDTO1.setName("Wilson");
		employeeDTO1.setEmailId("wilson@mail.com");
		employeeDTO1.setDateOfBirth(LocalDate.of(1996, 4, 10));
		employeeDTO1.setManufacturingUnit(ManufacturingUnit.U001);

	Mockito.when(employeeRepository.getEmployeeDetails(2007)).thenReturn(employeeDTO);
Exception ex= Assertions.assertThrows(Exception.class, ()-> 
employeeServiceImpl.getEmployeeDetails(employeeDTO1.getEmployeeId()));
Assertions.assertEquals("Service.EMPLOYEE_NOT_FOUND", ex.getMessage());
}
@Test
public void updateEmployeeInvalidEmployeeId() throws Exception {
EmployeeDTO employeeDTO = new EmployeeDTO();
employeeDTO.setEmployeeId(2007);
employeeDTO.setName("Wilson");
employeeDTO.setEmailId("wilson@mail.com");
employeeDTO.setDateOfBirth(LocalDate.of(1996, 4, 10));
employeeDTO.setManufacturingUnit(ManufacturingUnit.U001);
EmployeeDTO employeeDTO1 = new EmployeeDTO();
employeeDTO1.setEmployeeId(null);
employeeDTO1.setName("Wilson");
employeeDTO1.setEmailId("wilson@mail.com");
employeeDTO1.setDateOfBirth(LocalDate.of(1996, 4, 10));
employeeDTO1.setManufacturingUnit(ManufacturingUnit.U001);


Mockito.when(employeeRepository.getEmployeeDetails(2007)).thenReturn(employeeDTO);
	Exception ex= Assertions.assertThrows(Exception.class, ()-> 
		employeeServiceImpl.updateEmployee(employeeDTO1.getEmployeeId(), 
				employeeDTO1.getEmailId()));
Assertions.assertEquals("Service.EMPLOYEE_NOT_FOUND", ex.getMessage());
}
@Test
public void deleteEmployeeInvalidEmployeeId() throws Exception {
EmployeeDTO employeeDTO = new EmployeeDTO();
employeeDTO.setEmployeeId(2007);
employeeDTO.setName("Wilson");
employeeDTO.setEmailId("wilson@mail.com");
employeeDTO.setDateOfBirth(LocalDate.of(1996, 4, 10));
employeeDTO.setManufacturingUnit(ManufacturingUnit.U001);
EmployeeDTO employeeDTO1 = new EmployeeDTO();
employeeDTO1.setEmployeeId(null);
employeeDTO1.setName("Wilson");
employeeDTO1.setEmailId("wilson@mail.com");
employeeDTO1.setDateOfBirth(LocalDate.of(1996, 4, 10));
employeeDTO1.setManufacturingUnit(ManufacturingUnit.U001);
Mockito.when(employeeRepository.getEmployeeDetails(2007)).thenReturn(employeeDTO);
Exception ex= Assertions.assertThrows(Exception.class, ()-> 
employeeServiceImpl.deleteEmployee(employeeDTO1.getEmployeeId()));
Assertions.assertEquals("Service.EMPLOYEE_NOT_FOUND", ex.getMessage());
}
}