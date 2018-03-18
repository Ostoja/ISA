package com.isa.ISA.model;

import javax.persistence.*;

public class Mesto {
	@Id
	@GeneratedValue
	private long id;
	
	private int red;
	
	private int kolona;
	
	public Mesto() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getRed() {
		return red;
	}

	public void setRed(int red) {
		this.red = red;
	}

	public int getKolona() {
		return kolona;
	}

	public void setKolona(int kolona) {
		this.kolona = kolona;
	}
	
	
}
