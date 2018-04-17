package com.isa.ISA.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isa.ISA.model.FilmPredstava;
import com.isa.ISA.model.Projekcija;
import com.isa.ISA.model.DTO.FilmPredstavaDTO;
import com.isa.ISA.repository.FilmPredstavaRepository;
import com.isa.ISA.repository.ProjekcijaRepository;
import com.isa.ISA.service.FilmPredstavaService;
import com.sun.jersey.server.impl.model.method.dispatch.HttpReqResDispatchProvider;

@RestController
public class FilmPredstavaController {

	@Autowired
	private FilmPredstavaService fps;

	@Autowired 
	private ProjekcijaRepository pr;
	
	@Autowired
	private FilmPredstavaRepository fpr;
	
	@RequestMapping("/fp")
	public List<FilmPredstava> getAllFilmPredstava() {
		System.out.println("FPCONT +LLLLLLlLLLLLLL");
		return fps.getAllFilmPredstava();
	}

	@RequestMapping("/filmpred/{id}")
	public String postavljanje(@PathVariable String id, HttpServletRequest request) {
		Long idl = Long.parseLong(id);
		request.getSession().setAttribute("film", fpr.findOne(idl));
		return "Ok";
	}
	
	@RequestMapping("/fpa")
	public FilmPredstava getAllFilmPredstavaA(HttpServletRequest request) {
		Projekcija p = (Projekcija) request.getSession().getAttribute("projekc");
		System.out.println("FPCONT fpa+ "+ p.getFilmPredstava().getNaziv());
		return p.getFilmPredstava();
	}

	@RequestMapping("/film/{id}")
    private String getAllProjekcijaPB(@PathVariable String id, HttpServletRequest request){
		System.out.println("FPCont + " +id);
		Long idl = Long.parseLong(id);
		request.getSession().setAttribute("projekc", pr.findOne(idl));
		System.out.println("FPCont "+ pr.findOne(idl).getFname());
        return "izabrao je projekciju" + idl;
	}
	
	@RequestMapping("/editfilm/{id}")
    private String getEditFilmPB(@PathVariable String id, HttpServletRequest request){
		System.out.println("FPCont editujem+ " +id);
		Long idl = Long.parseLong(id);
		request.getSession().setAttribute("projekc", fpr.findOne(idl));
		System.out.println("FPCont editujem "+ fpr.findOne(idl).getNaziv());
        return "izabrao je projekciju" + idl;
	}
	
	@RequestMapping("/fp/{id}")
	public FilmPredstava getFilmPredstava(@PathVariable Long id) {
		return fps.getFilmPredstava(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/fp")
	public void addFilmPredstava(@RequestBody FilmPredstavaDTO fp) {
		System.out.println("FPCOnT dodajem "+fp.getNaziv());
		fps.addFilmPredstava(fp);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/fp")
	public void updateFilmPredstava(@RequestBody FilmPredstavaDTO fp, HttpServletRequest request) {
		Long id = ((FilmPredstava)request.getSession().getAttribute("film")).getId();
		fps.updateFilmPredstava(fp, id);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/fp/{id}")
	public void deleteFilmPredstava(@PathVariable Long id) {
		fps.deleteFilmPredstava(id);
	}
}
