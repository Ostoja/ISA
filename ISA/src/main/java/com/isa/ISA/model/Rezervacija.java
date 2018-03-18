package com.isa.ISA.model;

import javax.persistence.*;

@Entity
public class Rezervacija {
	@Id
	@GeneratedValue
	private long id;
	
	private boolean jePotvrdjena;
	
	public Rezervacija() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isJePotvrdjena() {
		return jePotvrdjena;
	}

	public void setJePotvrdjena(boolean jePotvrdjena) {
		this.jePotvrdjena = jePotvrdjena;
	}
	
	
}
