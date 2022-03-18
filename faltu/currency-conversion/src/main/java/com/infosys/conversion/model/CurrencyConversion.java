package com.infosys.conversion.model;

import java.io.Serializable;

public class CurrencyConversion implements Serializable {

	private static final long serialVersionUID = -7254172377585429891L;

	private String currencyFrom;
	private String currencyTo;
	private Double exchangeValue;
	private Double totalConversionValue;

	public CurrencyConversion(String currencyFrom, String currencyTo, Double exchangeValue,
			Double totalConversionValue) {
		super();
		this.currencyFrom = currencyFrom;
		this.currencyTo = currencyTo;
		this.exchangeValue = exchangeValue;
		this.totalConversionValue = totalConversionValue;
	}

	public CurrencyConversion() {
		super();
	}

	public String getCurrencyFrom() {
		return currencyFrom;
	}

	public void setCurrencyFrom(String currencyFrom) {
		this.currencyFrom = currencyFrom;
	}

	public String getCurrencyTo() {
		return currencyTo;
	}

	public void setCurrencyTo(String currencyTo) {
		this.currencyTo = currencyTo;
	}

	public Double getExchangeValue() {
		return exchangeValue;
	}

	public void setExchangeValue(Double exchangeValue) {
		this.exchangeValue = exchangeValue;
	}

	public Double getTotalConversionValue() {
		return totalConversionValue;
	}

	public void setTotalConversionValue(Double totalConversionValue) {
		this.totalConversionValue = totalConversionValue;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "CurrencyConversion [currencyFrom=" + currencyFrom + ", currencyTo=" + currencyTo + ", exchangeValue="
				+ exchangeValue + ", totalConversionValue=" + totalConversionValue + "]";
	}

}
