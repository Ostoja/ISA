package com.isa.ISA.model;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Termin {
	@Id
	@GeneratedValue
	private long id;
	
	private Date vremePocetka;
}
