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
	
	private String gmaps;
	@Enumerated(EnumType.STRING)
	private VrstaAmbijenta vrstaAmbijenta;
	
	@OneToMany
	private ArrayList<Sala> sale;
	
	@OneToOne //pogledati jos jednom.
	private Repertoar repertoar;
	
	private double prosecnaOcena;
	
	private int brojOcena;
	
	private int bronzeThreshold;
	
	private int silverThreshold;
	
	private int goldThreshold;
	
	private int bronzePopust;
	
	private int silverPopust;
	
	private int goldPopust;
	
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

	public Repertoar getRepertoar() {
		return repertoar;
	}

	public void setRepertoar(Repertoar repertoar) {
		this.repertoar = repertoar;
	}

	public double getProsecnaOcena() {
		return prosecnaOcena;
	}

	public void setProsecnaOcena(double prosecnaOcena) {
		this.prosecnaOcena = prosecnaOcena;
	}

	public int getBrojOcena() {
		return brojOcena;
	}

	public void setBrojOcena(int brojOcena) {
		this.brojOcena = brojOcena;
	}

	public String getGmaps() {
		return gmaps;
	}

	public void setGmaps(String gmaps) {
		this.gmaps = gmaps;
	}

	public int getBronzeThreshold() {
		return bronzeThreshold;
	}

	public void setBronzeThreshold(int bronzeThreshold) {
		this.bronzeThreshold = bronzeThreshold;
	}

	public int getSilverThreshold() {
		return silverThreshold;
	}

	public void setSilverThreshold(int silverThreshold) {
		this.silverThreshold = silverThreshold;
	}

	public int getGoldThreshold() {
		return goldThreshold;
	}

	public void setGoldThreshold(int goldThreshold) {
		this.goldThreshold = goldThreshold;
	}

	public int getBronzePopust() {
		return bronzePopust;
	}

	public void setBronzePopust(int bronzePopust) {
		this.bronzePopust = bronzePopust;
	}

	public int getSilverPopust() {
		return silverPopust;
	}

	public void setSilverPopust(int silverPopust) {
		this.silverPopust = silverPopust;
	}

	public int getGoldPopust() {
		return goldPopust;
	}

	public void setGoldPopust(int goldPopust) {
		this.goldPopust = goldPopust;
	}
	
	

}
