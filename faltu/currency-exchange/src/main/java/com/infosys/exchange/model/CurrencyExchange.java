package com.infosys.exchange.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CurrencyExchange implements Serializable {

	private static final long serialVersionUID = -3649251754921059416L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String currencyFrom;
	private String currencyTo;
	private Double exchangeValue;

	public CurrencyExchange(Integer id, String currencyFrom, String currencyTo, Double exchangeValue) {
		super();
		this.id = id;
		this.currencyFrom = currencyFrom;
		this.currencyTo = currencyTo;
		this.exchangeValue = exchangeValue;
	}

	public CurrencyExchange() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "CurrencyExchange [id=" + id + ", currencyFrom=" + currencyFrom + ", currencyTo=" + currencyTo
				+ ", exchangeValue=" + exchangeValue + "]";
	}

}
