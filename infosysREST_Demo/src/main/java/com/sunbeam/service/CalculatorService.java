package com.sunbeam.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorService {
	
	@RequestMapping(value="/add/{x}/{y}", method = RequestMethod.GET)
	public int addition(@PathVariable int x,@PathVariable int y) {
		return x+y;
	}
	@RequestMapping(value="/sub/{x}/{y}", method = RequestMethod.GET)
	public int subtraction(@PathVariable  int x,@PathVariable int y) {
		return x-y;
	}
	@RequestMapping(value="/mul/{x}/{y}", method = RequestMethod.GET)
	public int multiplication(@PathVariable int x,@PathVariable int y) {
		return x*y;
	}
	@RequestMapping(value="/div/{x}/{y}", method = RequestMethod.GET)
	public int division(@PathVariable int x,@PathVariable int y) {
		return x/y;
	}
	
}
