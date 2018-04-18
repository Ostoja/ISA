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
		FilmPredstava fp = new FilmPredstava();
		fp.setTrajanje(d.getTrajanje());
		fp.setZanr(d.getZanr());
		fp.setReditelj(d.getReditelj());
		fp.setOpis(d.getOpis());
		fp.setNaziv(d.getNaziv());
		fp.setSpisakGlumaca(d.getSpisakGlumaca());
		fp.setNosiBodova(d.getNosiBodova());
		fp.setProsecnaOcena(d.getProsecnaOcena());
		fp.setBrojOcena(d.getBrojOcena());
		return fp;

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

	public void oceniFilmPredstava(int projekcijaOcena,
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
	}

	public void updateFilmPredstava(FilmPredstavaDTO fp, Long id) {
		// TODO Auto-generated method stub
		FilmPredstava fp1 = converter(fp);
		fp1.setId(id);
		if (check(fp1))
			fpr.save(fp1);
	}
}
