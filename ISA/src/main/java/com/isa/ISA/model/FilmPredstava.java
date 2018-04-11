package com.isa.ISA.model;

import java.util.ArrayList;

import javax.persistence.*;

@Entity
public class FilmPredstava {
	@Id
	@GeneratedValue
	private long id;
	
	private String naziv;
	
	private String spisakGlumaca;
	
	private String zanr;
	
	private String reditelj;
	
	private int trajanje;
	
	private String poster; //??
	
	private double prosecnaOcena;
	
	private int brojOcena;
	
	private String opis;
	
	private int cena;
	
	@OneToMany(fetch = FetchType.EAGER)
	private ArrayList<Projekcija> projekcije;
	
	@ManyToOne
	private Repertoar repertoar;
	
	public FilmPredstava() {
		
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

	public String getSpisakGlumaca() {
		return spisakGlumaca;
	}

	public void setSpisakGlumaca(String spisakGlumaca) {
		this.spisakGlumaca = spisakGlumaca;
	}

	public String getZanr() {
		return zanr;
	}

	public void setZanr(String zanr) {
		this.zanr = zanr;
	}

	public String getReditelj() {
		return reditelj;
	}

	public void setReditelj(String reditelj) {
		this.reditelj = reditelj;
	}

	public int getTrajanje() {
		return trajanje;
	}

	public void setTrajanje(int trajanje) {
		this.trajanje = trajanje;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public double getProsecnaOcena() {
		return prosecnaOcena;
	}

	public void setProsecnaOcena(double prosecnaOcena) {
		this.prosecnaOcena = prosecnaOcena;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public int getCena() {
		return cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

	public int getBrojOcena() {
		return brojOcena;
	}

	public void setBrojOcena(int brojOcena) {
		this.brojOcena = brojOcena;
	}

	public ArrayList<Projekcija> getProjekcije() {
		return projekcije;
	}

	public void setProjekcije(ArrayList<Projekcija> projekcije) {
		this.projekcije = projekcije;
	}

	public Repertoar getRepertoar() {
		return repertoar;
	}

	public void setRepertoar(Repertoar repertoar) {
		this.repertoar = repertoar;
	}

	
	
	
}
