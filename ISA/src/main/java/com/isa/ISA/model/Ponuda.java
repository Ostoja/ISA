package com.isa.ISA.model;

import javax.persistence.*;

@Entity
public class Ponuda {
	@Id
	@GeneratedValue
	private long id;
	
	private int ponuda;
}
