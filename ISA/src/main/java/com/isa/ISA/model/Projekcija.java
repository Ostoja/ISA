package com.isa.ISA.model;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Projekcija {
	@Id
	@GeneratedValue
	private long id;
	
	private int popust;
	
	private Date datum;
	
	public Projekcija() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getPopust() {
		return popust;
	}

	public void setPopust(int popust) {
		this.popust = popust;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}
	
	
}
