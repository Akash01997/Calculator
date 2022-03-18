package com.infosys.exchange.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.exchange.model.CurrencyExchange;
import com.infosys.exchange.repository.CurrencyExchangeRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
@RequestMapping("/exchange")
public class CurrencyExchangeController {

	private CurrencyExchangeRepository currencyExchangeRepository;
	
	@Autowired
	public CurrencyExchangeController(CurrencyExchangeRepository repo) {
		this.currencyExchangeRepository = repo;
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.PUT)
	public CurrencyExchange save(@RequestBody CurrencyExchange currencyExchange) {
		return currencyExchangeRepository.save(currencyExchange);
	}
	
	/**
	@RequestMapping(value = "/getValue/{currencyFrom}/{currencyTo}", method = RequestMethod.GET)
	public CurrencyExchange getExchangeValue(@PathVariable String currencyFrom, @PathVariable String currencyTo) {
		return currencyExchangeRepository.getExchangeValue(currencyFrom, currencyTo);
	}**/
	
	@RequestMapping(value = "/getValue/{currencyFrom}/{currencyTo}", method = RequestMethod.GET)
	@CircuitBreaker(name = "getValue", fallbackMethod = "defaultResponse")
	@RateLimiter(name = "getValue")
	public CurrencyExchange getExchangeValueCB(@PathVariable String currencyFrom, @PathVariable String currencyTo) {
		return currencyExchangeRepository.getExchangeValue(currencyFrom, currencyTo);
	}
	
	public CurrencyExchange defaultResponse(Exception ex) {
		return new CurrencyExchange(0, "EURO", "INR", 85.0);
	}
	

	
}
