package com.isa.ISA;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.isa.ISA.model.Admin;
import com.isa.ISA.model.FilmPredstava;
import com.isa.ISA.model.Korisnik;
import com.isa.ISA.model.Mesto;
import com.isa.ISA.model.PozoristeBioskop;
import com.isa.ISA.model.Projekcija;
import com.isa.ISA.model.Sala;
import com.isa.ISA.model.TipKorisnika;
import com.isa.ISA.model.TipSedista;
import com.isa.ISA.model.VrstaAmbijenta;
import com.isa.ISA.repository.MestoRepository;
import com.isa.ISA.repository.SalaRepository;
import com.isa.ISA.service.AdminService;
import com.isa.ISA.service.FilmPredstavaService;
import com.isa.ISA.service.KorisnikService;
import com.isa.ISA.service.PozoristeBioskopService;
import com.isa.ISA.service.ProjekcijaService;

@Component
public class TestData {
	@Autowired
	private KorisnikService korisnikService;

	@Autowired
	private AdminService adminService;

	@Autowired
	private MestoRepository mr;
	
	@Autowired
	private SalaRepository salaRepository;

	@Autowired
	private PozoristeBioskopService pbService;

	@Autowired
	private FilmPredstavaService filmPredstavaService;

	@Autowired
	private ProjekcijaService projekcijaService;

	@PostConstruct
	public void init() {
		Korisnik k = new Korisnik();
		k.setUsername("niko");
		k.setPassword("rozberg1");
		k.setIme("Nikos");
		k.setPrezime("Galis");
		k.setEmail("niko@niko.com");
		k.setJeAktivan(true);
		k.setTip(TipKorisnika.Obican);
		System.out.println("Kreiran korisnik: " + k.getUsername());
		korisnikService.addUser(k);
		
		Admin a = new Admin();
        a.setUsername("admin");
        a.setPassword("admini");
        a.setTip(TipKorisnika.AdminBioPoz);
        a.setEmail("admin@admin.com");
        a.setIme("Adam");
        a.setPrezime("Adamovic");
        a.setGrad("Aleksinac");
        a.setJeAktivan(true);
        System.out.println("Kreiran korisnik: " + a.getUsername());
        adminService.addAdmin(a);
        
        PozoristeBioskop p1 = new PozoristeBioskop();
        p1.setBrojOcena(0);
        p1.setProsecnaOcena(0);
        List<Admin> adminList = new ArrayList<>();
        adminList.add(a);
        p1.setAdmini(adminList);
        p1.setNaziv("ABC Cinema");
        p1.setPromotivniOpis("Vrlo mainstream bioskop");
        p1.setVrstaAmbijenta(VrstaAmbijenta.Bioskop);
        p1.setAdresa("Gondolin, Tolkinova 43");

        //pbService.addPozoristeBioskop(p1);
        Sala s1 = new Sala();
        s1.setBrojKolona(10);
        s1.setBrojRedova(10);
        s1.setNaziv("A1");
        List<Sala> sale = new ArrayList<>();

   /*

        List<Mesto> mesta = new ArrayList<>();
        for(int i =0; i<=99; i++){
            Mesto mesto = new Mesto();
            mesto.setKolona(i%10);
            mesto.setRed( Math.floorDiv(i, 10));
            mesto.setTipSedista(TipSedista.Obicno);
            mesta.add(mesto);
            mr.save(mesto);
        }
*/
      //  s1.setMesta(mesta);
        salaRepository.save(s1);
        sale.add(s1);
        p1.setSale(sale);
        s1.setPozoristeBioskop(p1);
        List<Projekcija> projekcije = new ArrayList<>();
        Projekcija p = new Projekcija();
        p.setCena(300);
        p.setSala(s1);
        p.setDatum(new Date());
        FilmPredstava fp = new FilmPredstava();
        fp.setBrojOcena(0);
        fp.setProsecnaOcena(0);
        fp.setNosiBodova(1);
        fp.setNaziv("Transformers 25");
        fp.setOpis("25. nastavak.");
        fp.setReditelj("Christopher Nolan");
        fp.setSpisakGlumaca("The Rock, Jackie Chan");
        fp.setZanr("CGI mess");
        fp.setTrajanje(180);
     
        FilmPredstava fp2 = new FilmPredstava();
        fp2.setBrojOcena(0);
        fp2.setProsecnaOcena(0);
        fp2.setNosiBodova(1);
        fp2.setNaziv("Goodfellas");
        fp2.setOpis("Klasik");
        fp2.setReditelj("Martin Scorcese");
        fp2.setSpisakGlumaca("Ray Liotta, Joe Pesci");
        fp2.setZanr("Gangster");
        fp2.setTrajanje(172);

        
        filmPredstavaService.addFilmPredstava1(fp);
        filmPredstavaService.addFilmPredstava1(fp2);

        p.setFilmPredstava(fp);
        projekcijaService.addProjekcija(p);

        projekcije.add(p);
        p1.setRepertoar(projekcije);

        pbService.addPozoristeBioskop(p1);
        fp.setMestoOdrzavanja(p1);
        filmPredstavaService.updateFilmPredstava(fp);
        
	}
}
