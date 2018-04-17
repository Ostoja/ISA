package com.isa.ISA.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isa.ISA.model.PozoristeBioskop;
import com.isa.ISA.model.Projekcija;
import com.isa.ISA.model.Sala;
import com.isa.ISA.model.DTO.ProjekcijaDTO;
import com.isa.ISA.repository.PozoristeBioskopRepository;
import com.isa.ISA.repository.ProjekcijaRepository;
import com.isa.ISA.repository.SalaRepository;
import com.isa.ISA.service.ProjekcijaService;

@RestController
public class ProjekcijaController {

	@Autowired
	private ProjekcijaService ps;
	
	@Autowired
	private PozoristeBioskopRepository pbr;
	
	@Autowired
	private SalaRepository sr;
	
	@RequestMapping("/projekcije")
    private List<Projekcija> getAllProjekcija(HttpServletRequest request){
		PozoristeBioskop pb = (PozoristeBioskop) request.getSession().getAttribute("pozbio");
		System.out.println("Proj COnt, pb "+pb.getNaziv());
        List<Projekcija> allP = new ArrayList<>();
        ps.getAll().forEach(allP::add);
        PozoristeBioskop pbio = pbr.getOne(pb.getId());
        System.out.println("Proj Cont allP "+allP.size());
        List<Projekcija> temp = pbio.getRepertoar();
        /*for(int i = 0; i<allP.size(); i++) {
        	Sala sala = sr.getOne((allP.get(i).getSala().getId()));
        	//System.out.println("ProjCont projekcija: "+allP.get(i).getSala().getPozoristeBioskop().getNaziv());
        	if(!sala.getPozoristeBioskop().equals(pb)) {
        		temp.remove(allP.get(i));
        	}
        }*/
        return temp;
	}

	@RequestMapping("/projekcije/{id}")
    private String getAllProjekcijaPB(@PathVariable String id, HttpServletRequest request){
		System.out.println("ProjCont + " +id);
		Long idl = Long.parseLong(id);
		request.getSession().setAttribute("pozbio", pbr.findOne(idl));
		System.out.println("ProjCont "+ pbr.findOne(idl).getNaziv());
        return "izabrao je projekciju" + idl;
	}
	
	@RequestMapping("/pb/{id}/projekcije/{id}")
	private Projekcija getProjekcija(@PathVariable Long id){
		return ps.getProjekcija(id);
	}
	
	/*@RequestMapping(method = RequestMethod.POST, value = "/pb/{id}/projekcije")
    public void addProjekcija(@RequestBody Projekcija p, @PathVariable Long id){
        ps.addProjekcija(p);
    }*/
	
	@RequestMapping(method = RequestMethod.POST, value = "/pb/projekcije")
    public void addProjekcija(@RequestBody ProjekcijaDTO p){
        ps.addProjekcija(p);
    }
	
	@RequestMapping(method = RequestMethod.PUT, value = "/pb/{id}/projekcije/{id2}")
    public void updateProjekcija(@RequestBody Projekcija pr, @PathVariable Long id, @PathVariable Long id2){
        ps.updateProjekcija(pr);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/pb/{id}/projekcije/{id2}")
    public void deleteProjekcija(@PathVariable Long id, @PathVariable Long id2 ){
        ps.deleteProjekcija(id2);

}

	 
}
