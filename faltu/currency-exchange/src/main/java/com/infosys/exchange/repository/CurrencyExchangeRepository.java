package com.infosys.exchange.repository;

import com.infosys.exchange.model.CurrencyExchange;


public interface CurrencyExchangeRepository{
	
	CurrencyExchange getExchangeValue(String currencyFrom, String currencyTo);
	CurrencyExchange save(CurrencyExchange currencyExchange);

}
