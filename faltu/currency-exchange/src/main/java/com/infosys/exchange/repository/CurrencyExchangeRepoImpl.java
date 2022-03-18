package com.infosys.exchange.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infosys.exchange.model.CurrencyExchange;

@Repository
public class CurrencyExchangeRepoImpl implements CurrencyExchangeRepository {

	@Autowired
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public CurrencyExchange getExchangeValue(String currencyFrom, String currencyTo) {
		Query query = entityManager
				.createQuery("from CurrencyExchange where currencyFrom=:currencyFrom and currencyTo=:currencyTo");
		query.setParameter("currencyFrom", currencyFrom);
		query.setParameter("currencyTo", currencyTo);
		List<CurrencyExchange> currencyExchanges = query.getResultList();
		if(null != currencyExchanges && currencyExchanges.size()>0) {
			return currencyExchanges.get(0);
		}
		return null;
		
	}

	@Override
	@Transactional
	public CurrencyExchange save(CurrencyExchange currencyExchange) {
		return entityManager.merge(currencyExchange);
	}

}
