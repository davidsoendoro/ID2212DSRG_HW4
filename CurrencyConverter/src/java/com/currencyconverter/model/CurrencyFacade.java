/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.currencyconverter.model;

import com.currencyconverter.model.jpa.Currency;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author davidsoendoro
 */
@Stateless
public class CurrencyFacade extends AbstractFacade<Currency> {
    @PersistenceContext(unitName = "CurrencyConverterPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CurrencyFacade() {
        super(Currency.class);
    }
    
}
