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
	
	private int cena;
	
	@ManyToOne
	private FilmPredstava filmPredstava;
	
	@ManyToOne
    private Sala sala;

	
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

	public int getCena() {
		return cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

	public FilmPredstava getFilmPredstava() {
		return filmPredstava;
	}

	public void setFilmPredstava(FilmPredstava filmPredstava) {
		this.filmPredstava = filmPredstava;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}
	
	
	
}
