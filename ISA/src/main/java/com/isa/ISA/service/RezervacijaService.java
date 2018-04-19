package com.isa.ISA.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.ISA.model.Karta;
import com.isa.ISA.repository.KartaRepository;
import com.isa.ISA.repository.RezervacijaRepository;

@Service
public class RezervacijaService {

	@Autowired
	private RezervacijaRepository rRepository;
	@Autowired
	private KartaRepository kRepository;
	public void deleteSala(long id) {
		if(rRepository.getOne(id).isJePotvrdjena()) {
			return;
		}
		Karta k = kRepository.getOne(rRepository.getOne(id).getKarta().getId());
		k.setIzvrsena(false);
		kRepository.save(k);
		rRepository.delete(id);
		System.out.println("ÄAAAA +++ "+kRepository.findAll().size());
	}
}
