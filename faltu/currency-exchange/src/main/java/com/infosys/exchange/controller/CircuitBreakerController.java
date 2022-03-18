package com.infosys.exchange.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
public class CircuitBreakerController {

	private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
	
	@RequestMapping(value = "/default-api", method = RequestMethod.GET)
	@CircuitBreaker(name = "default-api", fallbackMethod = "defaultResponse")
	@RateLimiter(name = "default-api")
	public String actualResponse() {
		logger.info("Actual Response is called");
		ResponseEntity<String> entity = new RestTemplate().getForEntity("http://localhost:8000/dummy-url", String.class);
		return entity.getBody();
	}
	
	
	public String defaultResponse(Exception ex) {
		return "This is default response";
	}
	
	@RequestMapping(value = "/default-api-rl", method = RequestMethod.GET)
	@RateLimiter(name = "default-api-rl")
	public String actualResponseRateLimiter() {
		logger.info("Actual Response RateLimiter is called");
		return "default fallback response";
		
	}
	
	
	
	
}
