/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.currencyconverter.model.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author davidsoendoro
 */
@Entity
@Table(name = "EXCHANGEVALUE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Exchangevalue.findAll", query = "SELECT e FROM Exchangevalue e"),
    @NamedQuery(name = "Exchangevalue.findById", query = "SELECT e FROM Exchangevalue e WHERE e.id = :id"),
    @NamedQuery(name = "Exchangevalue.findByName", query = "SELECT e FROM Exchangevalue e WHERE e.name = :name"),
    @NamedQuery(name = "Exchangevalue.findByRate", query = "SELECT e FROM Exchangevalue e WHERE e.rate = :rate")})
public class Exchangevalue implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RATE")
    private double rate;

    public Exchangevalue() {
    }

    public Exchangevalue(Integer id) {
        this.id = id;
    }

    public Exchangevalue(Integer id, String name, double rate) {
        this.id = id;
        this.name = name;
        this.rate = rate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Exchangevalue)) {
            return false;
        }
        Exchangevalue other = (Exchangevalue) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.currencyconverter.model.Exchangevalue[ id=" + id + " ]";
    }
    
}
