package com.isa.ISA.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Karta {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private Mesto mesto;

    @ManyToOne
    private Projekcija projekcija;

    @ManyToOne PozoristeBioskop pozoristeBioskop;
    
    private Date vremeOdrzavanja;
    
    private int punaCena;
    
    public Karta(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    public PozoristeBioskop getPozoristeBioskop() {
        return pozoristeBioskop;
    }

    public void setPozoristeBioskop(PozoristeBioskop pozoristeBioskop) {
        this.pozoristeBioskop = pozoristeBioskop;
    }

    public Date getVremeOdrzavanja() {
        return vremeOdrzavanja;
    }

    public void setVremeOdrzavanja(Date vremeOdrzavanja) {
        this.vremeOdrzavanja = vremeOdrzavanja;
    }

    public int getPunaCena() {
        return punaCena;
    }

    public void setPunaCena(int punaCena) {
        this.punaCena = punaCena;
    }

}
