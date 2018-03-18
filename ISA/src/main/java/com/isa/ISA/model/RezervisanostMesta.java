package com.isa.ISA.model;

import javax.persistence.*;

@Entity
public class RezervisanostMesta {
	@Id
	@GeneratedValue
	private long id;
	
	private boolean zauzeto;
	
	public RezervisanostMesta() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isZauzeto() {
		return zauzeto;
	}

	public void setZauzeto(boolean zauzeto) {
		this.zauzeto = zauzeto;
	}
	
	
}
