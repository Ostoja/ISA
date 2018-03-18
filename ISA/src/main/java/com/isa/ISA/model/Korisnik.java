package com.isa.ISA.model;

import javax.persistence.*;

@Entity
public class Korisnik extends User {
	
	@Enumerated(EnumType.STRING)
	private RangKorisnika rangKorisnika;
	
	public Korisnik(){
		super();
	}
}
