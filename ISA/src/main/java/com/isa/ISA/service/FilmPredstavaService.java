package com.isa.ISA.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.ISA.model.FilmPredstava;
import com.isa.ISA.model.DTO.FilmPredstavaDTO;
import com.isa.ISA.repository.FilmPredstavaRepository;

@Service
public class FilmPredstavaService {

	@Autowired
	private FilmPredstavaRepository fpr;

	@Autowired
	private PozoristeBioskopService pbs;

	public List<FilmPredstava> getAllFilmPredstava() {
		List<FilmPredstava> allFP = new ArrayList<>();
		fpr.findAll().forEach(allFP::add);
		return allFP;
	}

	private boolean check(FilmPredstava fp) {

		if (fp.getBrojOcena() >= 0)
			if (fp.getNosiBodova() >= 0)
				if (fp.getSpisakGlumaca().length() > 0)
					if (fp.getNaziv().length() > 0)
						if (fp.getOpis().length() > 0)
							if (fp.getReditelj().length() > 0)
								if (fp.getTrajanje() > 0)
									if (fp.getZanr().length() > 0)
										return true;
		return false;

	}

	private FilmPredstava converter(FilmPredstavaDTO d) {
		FilmPredstava dog = new FilmPredstava();
		dog.setTrajanje(d.getTrajanje());
		dog.setZanr(d.getZanr());
		dog.setReditelj(d.getReditelj());
		dog.setOpis(d.getOpis());
		dog.setNaziv(d.getNaziv());
		dog.setSpisakGlumaca(d.getSpisakGlumaca());
		dog.setNosiBodova(d.getNosiBodova());
		dog.setProsecnaOcena(d.getProsecnaOcena());
		dog.setBrojOcena(d.getBrojOcena());
		return dog;

	}

	public void addFilmPredstava1(FilmPredstava fp) {
		if (check(fp))
			fpr.save(fp);
	}

	public void addFilmPredstava(FilmPredstavaDTO fp2) {
		FilmPredstava fp = converter(fp2);
		if (check(fp))
			fpr.save(fp);
	}

	public void updateFilmPredstava(FilmPredstava fp) {
		fpr.save(fp);
	}

	public void deleteFilmPredstava(Long id) {
		fpr.delete(id);
	}

	public FilmPredstava getFilmPredstava(Long l) {
		return fpr.findOne(l);
	}

	public List<FilmPredstava> getAllFilmPredstava(String s) {
		return fpr.findByNaziv(s);
	}

	public void oceniFilmPredstava(int ambijentOcena, int projekcijaOcena, Long pozoristeBioskopId,
			Long FilmPredstavaID) {
		FilmPredstava fp = fpr.findOne(FilmPredstavaID);
		int broj = fp.getBrojOcena();
		broj++;
		double prosecna = fp.getProsecnaOcena();
		if (broj == 1) {
			fp.setBrojOcena(broj);
			fp.setProsecnaOcena(projekcijaOcena);
		} else {
			double nova = (prosecna * broj + projekcijaOcena) / broj;
			fp.setBrojOcena(broj);
			fp.setProsecnaOcena(nova);
		}
		fpr.save(fp);
		pbs.updateOcena(pozoristeBioskopId, ambijentOcena);
	}
}
