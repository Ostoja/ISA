package com.isa.ISA.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.ISA.model.Mesto;
import com.isa.ISA.model.Sala;
import com.isa.ISA.model.SegmentUSali;
import com.isa.ISA.model.TipSedista;
import com.isa.ISA.model.DTO.SalaDTO;
import com.isa.ISA.model.DTO.SegmentUSaliDTO;
import com.isa.ISA.repository.MestoRepository;
import com.isa.ISA.repository.PozoristeBioskopRepository;
import com.isa.ISA.repository.SalaRepository;
import com.isa.ISA.repository.SegmentUSaliRepository;

@Service
public class SegmentUSaliService {
	@Autowired
	private SegmentUSaliRepository susr;
	@Autowired
	private SalaRepository sRepo;
	@Autowired
	private MestoRepository mr;

	public List<SegmentUSali> getAll() {
		return null;
	}

	public SegmentUSali getOne(Long id) {
		return susr.findOne(id);
	}

	public SegmentUSali converter(SegmentUSaliDTO s) {
		SegmentUSali sala = new SegmentUSali();
		sala.setNaziv(s.getNaziv());
		sala.setSala(sRepo.findOne(s.getSala()));
		sala.setRedovi(s.getRedovi());
		sala.setKolone(s.getKolone());
		sala.setJeZatvoreno(s.isJeZatvoreno());
		sala.setTipSedista(s.getTipSedista());
		return sala;

	}

	public void addSala(SegmentUSaliDTO s) {
		SegmentUSali sus = converter(s);
		System.out.println("SegSer + "+sus.toString());
		susr.save(sus);
		List<Mesto> mesta = new ArrayList<>();
		for (int i = 0; i < s.getKolone(); i++) {
			for (int j = 0; j < s.getRedovi(); j++) {
				Mesto mesto = new Mesto();
				mesto.setKolona(i);
				mesto.setRed(j);
				mesto.setTipSedista(sus.getTipSedista());
				mesta.add(mesto);
				mesto.setSegmentUSali(sus);
				mr.save(mesto);
			}
		}

		sus.setMesta(mesta);
		susr.save(sus);

	}

	public void editSala(SegmentUSali s, Long id) {
		// TODO Auto-generated method stub

	}

	public void deleteSala(Long id) {
		// TODO Auto-generated method stub

	}

}
