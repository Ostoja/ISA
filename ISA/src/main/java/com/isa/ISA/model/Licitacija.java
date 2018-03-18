package com.isa.ISA.model;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Licitacija {
	@Id
	@GeneratedValue
	private long id;
	
	private Date datumPocetka;
	
	private Date datumKraja;
	
	private int minimalniIznos;
	
	private boolean jeZatvorena;
	
	public Licitacija() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDatumPocetka() {
		return datumPocetka;
	}

	public void setDatumPocetka(Date datumPocetka) {
		this.datumPocetka = datumPocetka;
	}

	public Date getDatumKraja() {
		return datumKraja;
	}

	public void setDatumKraja(Date datumKraja) {
		this.datumKraja = datumKraja;
	}

	public int getMinimalniIznos() {
		return minimalniIznos;
	}

	public void setMinimalniIznos(int minimalniIznos) {
		this.minimalniIznos = minimalniIznos;
	}

	public boolean isJeZatvorena() {
		return jeZatvorena;
	}

	public void setJeZatvorena(boolean jeZatvorena) {
		this.jeZatvorena = jeZatvorena;
	}
	
	
}
