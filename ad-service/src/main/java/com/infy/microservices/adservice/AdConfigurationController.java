package com.infy.microservices.adservice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import com.infy.microservices.adservice.bean.AdConfiguration;


@RestController 
public class AdConfigurationController {
	@Autowired    
	private Configuration configuration;
	
	@GetMapping("/Ad") 
	public AdConfiguration retriveAdFromConfigurations()  
	{  
		return new AdConfiguration(configuration.getMaximum(), configuration.getMinimum()); 
	}
		
}
