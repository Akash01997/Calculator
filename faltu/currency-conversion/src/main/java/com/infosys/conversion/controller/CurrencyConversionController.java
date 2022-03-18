package com.infosys.conversion.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.infosys.conversion.model.CurrencyConversion;
import com.infosys.conversion.proxy.CurrencyExchangeProxy;

@RestController
@RequestMapping("/conversion")
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyExchangeProxy currencyExchangeProxy;

	@RequestMapping(value = "/from/{currencyFrom}/to/{currencyTo}/quantity/{quantiry}", method = RequestMethod.GET)
	public CurrencyConversion getConversionValue(@PathVariable String currencyFrom, @PathVariable String currencyTo,
			@PathVariable int quantiry) {

		HashMap<String, String> uriVariables = new HashMap<String, String>();
		uriVariables.put("currencyFrom", currencyFrom);
		uriVariables.put("currencyTo", currencyTo);
		ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/exchange/getValue/{currencyFrom}/{currencyTo}", CurrencyConversion.class,
				uriVariables);
		CurrencyConversion conversion = responseEntity.getBody();
		if (null != conversion) {
			conversion.setTotalConversionValue(quantiry * conversion.getExchangeValue());
			return conversion;
		}
		return null;
	}

	
	
	@RequestMapping(value = "/feign/from/{currencyFrom}/to/{currencyTo}/quantity/{quantiry}", method = RequestMethod.GET)
	public CurrencyConversion getConversionValueFeign(@PathVariable String currencyFrom, @PathVariable String currencyTo,
			@PathVariable int quantiry) {
			CurrencyConversion conversion = currencyExchangeProxy.getExchangeValue(currencyFrom, currencyTo);
			if(null != conversion) {
				conversion.setTotalConversionValue(quantiry*conversion.getExchangeValue());
				return conversion;
			}
		
		return null;
	}

}
