/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.currencyconverter.model;

import com.currencyconverter.model.jpa.Exchangevalue;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author davidsoendoro
 */
@Stateless
public class ExchangevalueFacade extends AbstractFacade<Exchangevalue> {
    @PersistenceContext(unitName = "CurrencyConverterPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ExchangevalueFacade() {
        super(Exchangevalue.class);
    }
 
    public double getExchangevalue(String fromCode, String toCode) {
        TypedQuery<Exchangevalue> query = em.createNamedQuery(
                "Exchangevalue.findByName", Exchangevalue.class)
                .setParameter("name", fromCode + toCode);
        Exchangevalue exchangevalue = query.getSingleResult();
        
        return exchangevalue.getRate();
    }
}
