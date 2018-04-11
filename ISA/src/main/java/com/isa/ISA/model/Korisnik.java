package com.isa.ISA.model;

import java.util.ArrayList;

import javax.persistence.*;

@Entity
public class Korisnik extends User {
	
	@Enumerated(EnumType.STRING)
	private RangKorisnika rangKorisnika;
	
	private ArrayList<Korisnik> prijatelji;
	
	private int bodovi;
	
	public Korisnik(){
		super();
	}
}
