package com.isa.ISA.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.ISA.model.FilmPredstava;
import com.isa.ISA.model.Projekcija;
import com.isa.ISA.model.Sala;
import com.isa.ISA.model.DTO.ProjekcijaDTO;
import com.isa.ISA.repository.FilmPredstavaRepository;
import com.isa.ISA.repository.ProjekcijaRepository;
import com.isa.ISA.repository.SalaRepository;

@Service
public class ProjekcijaService {

	@Autowired
	private ProjekcijaRepository pr;

	@Autowired
	FilmPredstavaRepository fpr;

	@Autowired
	private SalaRepository sr;

	public List<Projekcija> getAll() {
		List<Projekcija> allP = new ArrayList<>();
		pr.findAll().forEach(allP::add);
		return allP;
	}

	public Projekcija getProjekcija(Long id) {
		return pr.findOne(id);
	}

	public void deleteProjekcija(Long id) {
		pr.delete(id);
	}

	public void updateProjekcija(Projekcija p) {
		pr.save(p);
	}

	public void addProjekcija(Projekcija p) {
		System.out.println("A");
		pr.save(p);
	}

	public List<Projekcija> getProjekcije(FilmPredstava d) {
		List<Projekcija> allP = new ArrayList<>();
		pr.findByFilmPredstava(d).forEach(allP::add);
		return allP;
	}

	public List<Projekcija> getProjekcijeNakon(Date d) {
		List<Projekcija> allP = new ArrayList<>();
		pr.findByDatumAfter(d).forEach(allP::add);
		return allP;
	}

	public List<Projekcija> getProjekcijePre(Date d) {
		List<Projekcija> allP = new ArrayList<>();
		pr.findByDatumBefore(d).forEach(allP::add);
		return allP;
	}

	public List<Projekcija> getProjekcijeOdDo(Date od, Date dok) {
		List<Projekcija> allP = new ArrayList<>();
		pr.findByDatumBetween(od, dok).forEach(allP::add);
		return allP;
	}

	public List<Projekcija> getProjekcijeizSale(Sala s) {
		List<Projekcija> allP = new ArrayList<>();
		pr.findBySala(s).forEach(allP::add);
		return allP;
	}

	public List<Projekcija> getProjekcijeizSaleDogadjaja(Sala s, FilmPredstava d) {
		List<Projekcija> allP = new ArrayList<>();
		pr.findBySalaAndFilmPredstava(s, d).forEach(allP::add);
		return allP;
	}

	public List<Projekcija> getProjekcijeizSalePosle(Sala s, Date d) {
		List<Projekcija> allP = new ArrayList<>();
		pr.findBySalaAndDatumAfter(s, d).forEach(allP::add);
		return allP;
	}

	public List<Projekcija> getProjekcijeizSalePre(Sala s, Date d) {
		List<Projekcija> allP = new ArrayList<>();
		pr.findBySalaAndDatumBefore(s, d).forEach(allP::add);
		return allP;
	}

	public List<Projekcija> getProjekcijeizSaleIzmedju(Sala s, Date d, Date b) {
		List<Projekcija> allP = new ArrayList<>();
		pr.findBySalaAndDatumBetween(s, d, b).forEach(allP::add);
		return allP;
	}

	public void deleteProjekcijaByIds(List<Long> ids) {
		for (Long id : ids) {
			pr.delete(id);
		}
	}

	public ArrayList<Long> getProjekcijeToBeDeleted(Long id) {
		ArrayList<Long> ids = new ArrayList<>();
		Sala s = sr.findOne(id);
		List<Projekcija> projekcije = pr.findBySala(s);
		for (Projekcija p : projekcije) {
			ids.add(p.getId());
		}
		return ids;
	}

	public void deleteProjekcijaByDogadjaj(Long id) {
		FilmPredstava d = fpr.findOne(id);
		List<Projekcija> projekcije = pr.findByFilmPredstava(d);
		for (Projekcija p : projekcije) {
			pr.delete(p);
		}

	}
	
	public Projekcija converter(ProjekcijaDTO pp) {
		Projekcija p = new Projekcija();
		p.setCena(pp.getCena());
		p.setDatum(pp.getDatum());
		p.setFilmPredstava(fpr.getOne(pp.getFilmPredstava()));
		p.setTermin(pp.getTermin());
		p.setSala(sr.findOne(pp.getSala()));
		return p;
	}
	
	public void addProjekcija(ProjekcijaDTO pp) {
		// TODO Auto-generated method stub
		Projekcija p = converter(pp);
		int a = 2;
		a++;
		System.out.println(a);
		addProjekcija(p);
	}
	
}