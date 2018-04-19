package com.isa.ISA.service;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.ISA.model.Karta;
import com.isa.ISA.model.PozoristeBioskop;
import com.isa.ISA.model.Rezervacija;
import com.isa.ISA.model.DTO.ReportDTO;
import com.isa.ISA.repository.FilmPredstavaRepository;
import com.isa.ISA.repository.KartaRepository;
import com.isa.ISA.repository.PozoristeBioskopRepository;
import com.isa.ISA.repository.RezervacijaRepository;

@Service
public class ReportService {
	@Autowired
	private PozoristeBioskopRepository pbr;

	@Autowired
	private FilmPredstavaRepository fpr;

	@Autowired
	private RezervacijaRepository rezervacijaRepository;
	
	@Autowired
	private KartaRepository kartaRepository;

	public double getOcenaPB(Long id) {
		return pbr.findOne(id).getProsecnaOcena();
	}

	public double getOcenaFP(Long id) {
		return fpr.findOne(id).getProsecnaOcena();
	}

	public int getPrihodIzmedju(Long id, Date p, Date k) {
		PozoristeBioskop pb = new PozoristeBioskop();
		pb = pbr.getOne(id);
		int sum = 0;
		List<Karta> allP = new ArrayList<>();
		kartaRepository.findByPozoristeBioskopAndVremeOdrzavanjaBetween(pb, p, k).forEach(allP::add);
		for (int i = 0; i < allP.size(); i++) {
			Rezervacija r = rezervacijaRepository.findByKarta(allP.get(i)); 
			//System.out.println("AAAAA "+r.getOcenaAmbijenta());
			if(r==null) {
				continue;
			}
			if(!r.isJePotvrdjena()) {
				continue;
			}
			sum += (allP.get(i).getPunaCena() - allP.get(i).getPopust() * allP.get(i).getPunaCena() / 100);
		}
		return sum;
	}

	public int getPrihodPre(Long id, Date p) {
		PozoristeBioskop pb = new PozoristeBioskop();
		pb = pbr.getOne(id);
		int sum = 0;
		List<Karta> allP = new ArrayList<>();
		kartaRepository.findByPozoristeBioskopAndVremeOdrzavanjaBefore(pb, p).forEach(allP::add);
		for (int i = 0; i < allP.size(); i++) {
			Rezervacija r = rezervacijaRepository.findByKarta(allP.get(i)); 
			//System.out.println("AAAAA "+r.getOcenaAmbijenta());
			if(r==null) {
				continue;
			}
			if(!r.isJePotvrdjena()) {
				continue;
			}
			sum += (allP.get(i).getPunaCena() - allP.get(i).getPopust() * allP.get(i).getPunaCena() / 100);
		}
		return sum;
	}

	public int getPrihodPosle(Long id, Date p) {
		PozoristeBioskop pb = new PozoristeBioskop();
		pb = pbr.getOne(id);
		int sum = 0;
		List<Karta> allP = new ArrayList<>();
		kartaRepository.findByPozoristeBioskopAndVremeOdrzavanjaAfter(pb, p).forEach(allP::add);
		for (int i = 0; i < allP.size(); i++) {
			Rezervacija r = rezervacijaRepository.findByKarta(allP.get(i)); 
			//System.out.println("AAAAA "+r.getOcenaAmbijenta());
			if(r==null) {
				continue;
			}
			if(!r.isJePotvrdjena()) {
				continue;
			}
			sum += (allP.get(i).getPunaCena() - allP.get(i).getPopust() * allP.get(i).getPunaCena() / 100);
		}
		return sum;
	}

	public List<ReportDTO> getPoseteIzmedju(Long id, Date od, Date ka) {
		PozoristeBioskop pb = new PozoristeBioskop();
		pb = pbr.getOne(id);
		List<ReportDTO> ret = new ArrayList<>();
		List<Karta> karte = new ArrayList<>();
		kartaRepository.findByPozoristeBioskopAndVremeOdrzavanjaBetween(pb, od, ka).forEach(karte::add);
		for (int i = 0; i < karte.size(); i++) {
			ReportDTO rdto = new ReportDTO();
			SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
			rdto.setDatum(DATE_FORMAT.format(karte.get(i).getProjekcija().getDatum()));
			Rezervacija r = rezervacijaRepository.findByKarta(karte.get(i)); 
			//System.out.println("AAAAA "+r.getOcenaAmbijenta());
			if(r==null) {
				continue;
			}
			if(!r.isJePotvrdjena()) {
				continue;
			}
			if (ret.size() == 0) {
				rdto.setPoseta(1);
				ret.add(rdto);
			} else {
				for (int j = 0; j < ret.size(); j++) {
					if (ret.get(j).getDatum().equals(rdto.getDatum())) {
						rdto.setPoseta(rdto.getPoseta() + 1);
						ret.add(rdto);
					} else {
						rdto.setPoseta(1);
						ret.add(rdto);
					}
				}
			}
		}
		return ret;
	}

	public List<ReportDTO> getPosetePosle(Long id, Date od) {
		PozoristeBioskop pb = new PozoristeBioskop();
		pb = pbr.getOne(id);
		List<ReportDTO> ret = new ArrayList<>();
		List<Karta> karte = new ArrayList<>();
		kartaRepository.findByPozoristeBioskopAndVremeOdrzavanjaAfter(pb, od).forEach(karte::add);
		for (int i = 0; i < karte.size(); i++) {
			ReportDTO rdto = new ReportDTO();
			SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
			rdto.setDatum(DATE_FORMAT.format(karte.get(i).getProjekcija().getDatum()));
			Rezervacija r = rezervacijaRepository.findByKarta(karte.get(i)); 
			//System.out.println("AAAAA "+r.getOcenaAmbijenta());
			if(r==null) {
				continue;
			}
			if(!r.isJePotvrdjena()) {
				continue;
			}
			if (ret.size() == 0) {
				rdto.setPoseta(1);
				ret.add(rdto);
			} else {
				for (int j = 0; j < ret.size(); j++) {
					if (ret.get(j).getDatum().equals(rdto.getDatum())) {
						rdto.setPoseta(rdto.getPoseta() + 1);
						ret.add(rdto);
					} else {
						rdto.setPoseta(1);
						ret.add(rdto);
					}
				}
			}
		}
		return ret;
	}

	public List<ReportDTO> getPosetePre(Long id, Date od) {
		PozoristeBioskop pb = new PozoristeBioskop();
		pb = pbr.getOne(id);
		List<ReportDTO> ret = new ArrayList<>();
		List<Karta> karte = new ArrayList<>();
		kartaRepository.findByPozoristeBioskopAndVremeOdrzavanjaBefore(pb, od).forEach(karte::add);
		for (int i = 0; i < karte.size(); i++) {
			ReportDTO rdto = new ReportDTO();
			SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
			rdto.setDatum(DATE_FORMAT.format(karte.get(i).getProjekcija().getDatum()));
			Rezervacija r = rezervacijaRepository.findByKarta(karte.get(i)); 
			//System.out.println("AAAAA "+r.getOcenaAmbijenta());
			if(r==null) {
				continue;
			}
			if(!r.isJePotvrdjena()) {
				continue;
			}
			if (ret.size() == 0) {
				rdto.setPoseta(1);
				ret.add(rdto);
			} else {
				for (int j = 0; j < ret.size(); j++) {
					if (ret.get(j).getDatum().equals(rdto.getDatum())) {
						rdto.setPoseta(rdto.getPoseta() + 1);
						ret.add(rdto);
					} else {
						rdto.setPoseta(1);
						ret.add(rdto);
					}
				}
			}
		}
		return ret;
	}

}
