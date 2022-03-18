package com.sunbeam;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sunbeam.service.CalculatorService;

@SpringBootApplication
public class InfosysRestDemoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(InfosysRestDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		CalculatorService c = new CalculatorService();
		System.out.println(c.addition(5, 6));
		
	}

}
