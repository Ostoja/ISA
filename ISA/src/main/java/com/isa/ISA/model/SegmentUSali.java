package com.isa.ISA.model;

import javax.persistence.*;

@Entity
public class SegmentUSali {
	@Id
	@GeneratedValue
	private long id;
	
	private String naziv;
	
	private boolean jeZatvoreno;
	
	public SegmentUSali() {
		
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

	public boolean isJeZatvoreno() {
		return jeZatvoreno;
	}

	public void setJeZatvoreno(boolean jeZatvoreno) {
		this.jeZatvoreno = jeZatvoreno;
	}
	
	
	

}
