package com.isa.ISA.model;

import java.util.ArrayList;

import javax.persistence.*;

@Entity
public class PozoristeBioskop {
	@Id
	@GeneratedValue
	private long id;
	
	private String naziv;
	
	private String adresa;
	
	private String promotivniOpis;
	
	@Enumerated(EnumType.STRING)
	private VrstaAmbijenta vrstaAmbijenta;
	
	@OneToMany
	private ArrayList<Sala> sale;
	
	@OneToMany
	private ArrayList<FilmPredstava> repertoar;
	
	PozoristeBioskop() {
		
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

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getPromotivniOpis() {
		return promotivniOpis;
	}

	public void setPromotivniOpis(String promotivniOpis) {
		this.promotivniOpis = promotivniOpis;
	}

	public VrstaAmbijenta getVrstaAmbijenta() {
		return vrstaAmbijenta;
	}

	public void setVrstaAmbijenta(VrstaAmbijenta vrstaAmbijenta) {
		this.vrstaAmbijenta = vrstaAmbijenta;
	}

	public ArrayList<Sala> getSale() {
		return sale;
	}

	public void setSale(ArrayList<Sala> sale) {
		this.sale = sale;
	}

	public ArrayList<FilmPredstava> getRepertoar() {
		return repertoar;
	}

	public void setRepertoar(ArrayList<FilmPredstava> repertoar) {
		this.repertoar = repertoar;
	}
	
	

}
