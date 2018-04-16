package com.isa.ISA.model.DTO;

public class FilmPredstavaDTO {
	private String naziv;

	private int trajanje;

	private String zanr;

	private String opis;

	private String reditelj;

	private float prosecnaOcena;

	private int brojOcena; 
	
	private int nosiBodova;

	private String spisakGlumaca;


	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public int getTrajanje() {
		return trajanje;
	}

	public void setTrajanje(int trajanje) {
		this.trajanje = trajanje;
	}

	public String getZanr() {
		return zanr;
	}

	public void setZanr(String zanr) {
		this.zanr = zanr;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public float getProsecnaOcena() {
		return prosecnaOcena;
	}

	public void setProsecnaOcena(float prosecnaOcena) {
		this.prosecnaOcena = prosecnaOcena;
	}

	public int getBrojOcena() {
		return brojOcena;
	}

	public void setBrojOcena(int brojOcena) {
		this.brojOcena = brojOcena;
	}


	public String getReditelj() {
		return reditelj;
	}

	public void setReditelj(String reditelj) {
		this.reditelj = reditelj;
	}

	public int getNosiBodova() {
		return nosiBodova;
	}

	public void setNosiBodova(int nosiBodova) {
		this.nosiBodova = nosiBodova;
	}

	public String getSpisakGlumaca() {
		return spisakGlumaca;
	}

	public void setSpisakGlumaca(String spisakGlumaca) {
		this.spisakGlumaca = spisakGlumaca;
	}

	public FilmPredstavaDTO(){}
}
