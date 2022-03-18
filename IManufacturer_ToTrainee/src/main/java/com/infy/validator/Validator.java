package com.infy.validator;

import com.infy.dto.EmployeeDTO;
import com.infy.exception.InfyEmployeeException;

public class Validator {
	
	public static void validate(EmployeeDTO employee) throws InfyEmployeeException	{
		if(Boolean.FALSE.equals(validateEmailId(employee.getEmailId()))) {
			throw new InfyEmployeeException("Validator.INVALID_EMAIL_ID");
		}
		
	}
	
	public static Boolean validateEmailId(String emailId)	{
		if(emailId.matches("[\\w]+[@][A-Za-z]+[.][A-Za-z]+")){
			return true;
		}
		return false;
 }

}
