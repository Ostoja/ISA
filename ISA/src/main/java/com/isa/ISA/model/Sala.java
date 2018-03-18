package com.isa.ISA.model;

import javax.persistence.*;

@Entity
public class Sala {
	@Id
	@GeneratedValue
	private long id;
	
	private String naziv;
	
	private int brojRedova;
	
	private int brojKolona;
	
	public Sala() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public int getBrojRedova() {
		return brojRedova;
	}

	public void setBrojRedova(int brojRedova) {
		this.brojRedova = brojRedova;
	}

	public int getBrojKolona() {
		return brojKolona;
	}

	public void setBrojKolona(int brojKolona) {
		this.brojKolona = brojKolona;
	}
	
	
}
