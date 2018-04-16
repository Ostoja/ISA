package com.isa.ISA.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isa.ISA.model.Karta;
import com.isa.ISA.model.PozoristeBioskop;

public interface KartaRepository extends JpaRepository<Karta, Long> {
	List<Karta> findByPozoristeBioskopAndVremeOdrzavanjaBetween(PozoristeBioskop pb, Date pocetak, Date kraj);
	List<Karta> findByPozoristeBioskopAndVremeOdrzavanjaAfter(PozoristeBioskop pb, Date pocetak);
	List<Karta> findByPozoristeBioskopAndVremeOdrzavanjaBefore(PozoristeBioskop pb, Date kraj);
}
