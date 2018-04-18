package com.isa.ISA.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isa.ISA.model.Karta;
import com.isa.ISA.model.Korisnik;
import com.isa.ISA.model.PozoristeBioskop;
import com.isa.ISA.model.Rezervacija;
import com.isa.ISA.model.TipKorisnika;
import com.isa.ISA.model.User;
import com.isa.ISA.model.DTO.KartaDTO;
import com.isa.ISA.model.DTO.OcenaDTO;
import com.isa.ISA.model.DTO.RezervacijaDTO;
import com.isa.ISA.repository.KartaRepository;
import com.isa.ISA.repository.KorisnikRepository;
import com.isa.ISA.repository.RezervacijaRepository;
import com.isa.ISA.service.FilmPredstavaService;
import com.isa.ISA.service.PozoristeBioskopService;

@RestController
public class RezervacijaController {
	@Autowired
	private RezervacijaRepository rr;
	@Autowired 
	private KorisnikRepository kor;
	@Autowired
	private KartaRepository kartaRepo;
	@Autowired
	private PozoristeBioskopService pbs;
	@Autowired
	private FilmPredstavaService fps;
	
	@RequestMapping("/rezervacije")
	private List<RezervacijaDTO> getAllRezervacija(HttpServletRequest request) {
		List<Rezervacija> allP = new ArrayList<>();
		System.out.println("BBBB +"+rr.findAll().size());
		allP = rr.findAll();
		User u = (User) request.getSession().getAttribute("loggedUser");
		if(u.getTip()!=TipKorisnika.Obican) {
			return null;
		}
		Korisnik k = kor.getOne(u.getId());
		List<Rezervacija> temp = allP;
		List<RezervacijaDTO> tempDTO = new ArrayList<>();
		for(int i = 0; i<allP.size(); i++) {
			if(allP.get(i).getRezervisao().getId()==k.getId()) {
				tempDTO.add(converter(allP.get(i)));
			}
		}
		return tempDTO;
		
	}
	
	
	private RezervacijaDTO converter(Rezervacija rezervacija) {
		RezervacijaDTO r = new RezervacijaDTO();
		r.setOcenaAmbijenta(rezervacija.getOcenaAmbijenta());
		r.setOcenaProjekcije(rezervacija.getOcenaProjekcije());
		r.setProjekcija(rezervacija.getProjekcija().getId());
		r.setJePotvrdjena(rezervacija.isJePotvrdjena());
		r.setKorisnik(rezervacija.getRezervisao().getId());
		r.setSname(rezervacija.getProjekcija().getSname());
		r.setFname(rezervacija.getProjekcija().getFname());
		r.setMesto(rezervacija.getMesto().getBroj());
		r.setPbname(rezervacija.getKarta().getPozoristeBioskop().getNaziv());
		r.setId(rezervacija.getId());
		System.out.println("RezCont + "+ r);
		return r;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/ocenjujem/{id}")
	public void addKarta3(@PathVariable String id, HttpServletRequest request) {
		Long idl = Long.parseLong(id);
		request.getSession().setAttribute("rezervacija", rr.findOne(idl));
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/rate")
	public void addRating(@RequestBody OcenaDTO ocena, HttpServletRequest request) {
		Rezervacija roz = (Rezervacija) request.getSession().getAttribute("rezervacija");
		Rezervacija r = rr.getOne(roz.getId());
		r.setOcenaAmbijenta(ocena.getOcenaAmbijenta());
		r.setOcenaProjekcije(ocena.getOcenaProjekcije());
		r.setJePotvrdjena(true);
		rr.save(r);
		pbs.updateOcena(r.getKarta().getPozoristeBioskop().getId(), ocena.getOcenaAmbijenta());
		fps.oceniFilmPredstava(ocena.getOcenaProjekcije(), r.getProjekcija().getFilmPredstava().getId());
	}
	//@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	@RequestMapping(method = RequestMethod.POST, value = "/rezervisi/{id}")
	public void addRezervacija(@PathVariable String id, HttpServletRequest request) {
		Long idl = Long.parseLong(id);
		User u = (User) request.getSession().getAttribute("loggedUser");
		if(u.getTip()!=TipKorisnika.Obican) {
			return;
		}
		Korisnik ko = kor.getOne(u.getId());
		Karta k = kartaRepo.getOne(idl);
		k.setIzvrsena(true);
		kartaRepo.save(k);
		Rezervacija re = new Rezervacija();
		re.setJePotvrdjena(false);
		re.setKarta(k);
		re.setMesto(k.getMesto());
		re.setProjekcija(k.getProjekcija());
		re.setRezervisao(ko);
		rr.save(re);
		System.out.println("AAAA "+rr.findAll().size());
		/*
		r.setBroj(k.getMesto().getBroj());
		r.setFname(k.getProjekcija().getFname());
		r.setSname(k.getProjekcija().getSname());
		r.setKorisnik(ko.getId());
		r.setPbname(k.getPozoristeBioskop().getNaziv());
		r.setMesto(k.getMesto().getId());
		r.setProjekcija(k.getProjekcija().getId());
		r.setJePotvrdjena(false);*/
		
	}
}
