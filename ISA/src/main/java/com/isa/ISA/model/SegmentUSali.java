package com.isa.ISA.model;

import java.util.List;

import javax.persistence.*;


@Entity
public class SegmentUSali {
	@Id
	@GeneratedValue
	private long id;
	
	private String naziv;
	
	private boolean jeZatvoreno;
	
	private TipSedista tipSedista;
	
	@OneToMany
    private List<Mesto> mesta;

	
	public SegmentUSali() {
		
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

	public boolean isJeZatvoreno() {
		return jeZatvoreno;
	}

	public void setJeZatvoreno(boolean jeZatvoreno) {
		this.jeZatvoreno = jeZatvoreno;
	}

	public TipSedista getTipSedista() {
		return tipSedista;
	}

	public void setTipSedista(TipSedista tipSedista) {
		this.tipSedista = tipSedista;
	}

	public List<Mesto> getMesta() {
		return mesta;
	}

	public void setMesta(List<Mesto> mesta) {
		this.mesta = mesta;
	}
	
	
	

}
