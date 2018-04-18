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
		int k =0;
		List<Mesto> mesta = new ArrayList<>();
		for (int i = 1; i <= s.getKolone(); i++) {
			for (int j = 1; j <= s.getRedovi(); j++) {
				Mesto mesto = new Mesto();
				k++;
				mesto.setKolona(i);
				mesto.setRed(j);
				mesto.setBroj(k);
				mesto.setTipSedista(sus.getTipSedista());
				mesta.add(mesto);
				mesto.setSegmentUSali(sus);
				mr.save(mesto);
			}
		}

		sus.setMesta(mesta);
		susr.save(sus);

	}

	public void addSala(SegmentUSaliDTO s, long id) {
		// TODO Auto-generated method stub
		SegmentUSali sus = converter(s);
		sus.setId(id);
		susr.save(sus);
		int k = 0;
		List<Mesto> mesta = new ArrayList<>();
		for (int i = 1; i <= s.getKolone(); i++) {
			for (int j = 1; j <= s.getRedovi(); j++) {
				Mesto mesto = new Mesto();
				mesto.setKolona(i);
				k++;
				mesto.setRed(j);
				mesto.setTipSedista(sus.getTipSedista());
				mesta.add(mesto);
				mesto.setSegmentUSali(sus);
				mesto.setBroj(k);
				mr.save(mesto);
			}
		}

		sus.setMesta(mesta);
		susr.save(sus);
	}

	public void deleteSala(Long id) {
		// TODO Auto-generated method stub
		
	}

	public void addSala(SegmentUSali s, Long id) {
		// TODO Auto-generated method stub
		
	}

}