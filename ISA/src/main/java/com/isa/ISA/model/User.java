package com.isa.ISA.model;

import javax.persistence.*;

@Entity
public abstract class User {

	@Id
    @GeneratedValue
    private long id;
	
	private String email;
	
	private String password;
	
	private String salt;
	
	private String ime;
	
	private String prezime;
	
	private String grad;
	
	private String brojTelefona;
	
	@Enumerated(EnumType.STRING)
	private TipKorisnika tipKorisnika;
	
	private Boolean jeAktivan;
	
	public User(){
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getGrad() {
		return grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}

	public String getBrojTelefona() {
		return brojTelefona;
	}

	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}

	public TipKorisnika getTipKorisnika() {
		return tipKorisnika;
	}

	public void setTipKorisnika(TipKorisnika tipKorisnika) {
		this.tipKorisnika = tipKorisnika;
	}

	public Boolean getJeAktivan() {
		return jeAktivan;
	}

	public void setJeAktivan(Boolean jeAktivan) {
		this.jeAktivan = jeAktivan;
	}
	
	
}
