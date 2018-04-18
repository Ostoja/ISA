package com.isa.ISA.model.DTO;


/**
 * prenosi mesto, segmentUsali, projekciju i popust*/
public class KartaDTO {
	
	private long mesto;

	private long rezervacija;

	private long projekcija;

	private long pozoristeBioskop;

	private String vremeOdrzavanja; //date

	private String termin;
	
	private int punaCena;

	private int popust;

	private long segmentUsali;
	
	private String sala;
	
	public KartaDTO() {
		
	}

	public long getMesto() {
		return mesto;
	}

	public void setMesto(long mesto) {
		this.mesto = mesto;
	}

	public long getRezervacija() {
		return rezervacija;
	}

	public void setRezervacija(long rezervacija) {
		this.rezervacija = rezervacija;
	}

	public long getProjekcija() {
		return projekcija;
	}

	public void setProjekcija(long projekcija) {
		this.projekcija = projekcija;
	}

	public long getPozoristeBioskop() {
		return pozoristeBioskop;
	}

	public void setPozoristeBioskop(long pozoristeBioskop) {
		this.pozoristeBioskop = pozoristeBioskop;
	}

	public String getVremeOdrzavanja() {
		return vremeOdrzavanja;
	}

	public void setVremeOdrzavanja(String vremeOdrzavanja) {
		this.vremeOdrzavanja = vremeOdrzavanja;
	}

	public int getPunaCena() {
		return punaCena;
	}

	public void setPunaCena(int punaCena) {
		this.punaCena = punaCena;
	}

	public int getPopust() {
		return popust;
	}

	public void setPopust(int popust) {
		this.popust = popust;
	}

	public String getTermin() {
		return termin;
	}

	public void setTermin(String termin) {
		this.termin = termin;
	}

	public long getSegmentUsali() {
		return segmentUsali;
	}

	public void setSegmentUsali(long segmentUsali) {
		this.segmentUsali = segmentUsali;
	}

	@Override
	public String toString() {
		return "KartaDTO [mesto=" + mesto + ", rezervacija=" + rezervacija + ", projekcija=" + projekcija
				+ ", pozoristeBioskop=" + pozoristeBioskop + ", vremeOdrzavanja=" + vremeOdrzavanja + ", termin="
				+ termin + ", punaCena=" + punaCena + ", popust=" + popust + ", segmentUsali=" + segmentUsali
				+ ", sala=" + sala + "]";
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}
	
	

}
