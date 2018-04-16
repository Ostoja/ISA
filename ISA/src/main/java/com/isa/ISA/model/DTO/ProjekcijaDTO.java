package com.isa.ISA.model.DTO;

import java.sql.Time;
import java.util.Date;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.isa.ISA.CustomerDateAndTimeDeserialize;



public class ProjekcijaDTO {
	private Date datum;
	
	private String termin;

	private int cena;
	
	private Long filmPredstava;
	
    private Long sala;

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

	public Long getFilmPredstava() {
		return filmPredstava;
	}

	public void setFilmPredstava(Long filmPredstava) {
		this.filmPredstava = filmPredstava;
	}

	public Long getSala() {
		return sala;
	}

	public void setSala(Long sala) {
		this.sala = sala;
	}
    
	
	
    public ProjekcijaDTO() {
    	
    }

	public String getTermin() {
		return termin;
	}

	public void setTermin(String termin) {
		this.termin = termin;
	}
}
