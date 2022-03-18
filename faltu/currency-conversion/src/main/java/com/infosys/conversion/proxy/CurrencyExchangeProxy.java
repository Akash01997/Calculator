package com.infosys.conversion.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.infosys.conversion.model.CurrencyConversion;

@FeignClient(name="currency-exchange")
public interface CurrencyExchangeProxy {
	
	@RequestMapping(value = "/exchange/getValue/{currencyFrom}/{currencyTo}", method = RequestMethod.GET)
	CurrencyConversion getExchangeValue(@PathVariable String currencyFrom, @PathVariable String currencyTo);

}
