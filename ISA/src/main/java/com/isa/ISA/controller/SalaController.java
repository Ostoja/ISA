package com.isa.ISA.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isa.ISA.model.Sala;
import com.isa.ISA.service.ProjekcijaService;
import com.isa.ISA.service.SalaService;

@RestController
public class SalaController {

	@Autowired
	private SalaService sService; 
	
	@Autowired
	private ProjekcijaService ps;

	@RequestMapping("/sale")
	public List<Sala> getAllPozoristeBioskop() {
		return sService.getAll();
	}

	@RequestMapping("/sala/{id}")
	public Sala getSala(@PathVariable Long id) {
		return sService.getOne(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/sala/add")
	public void addSala(@RequestBody Sala s) {
		sService.addSala(s);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/sala/edit/{id}")
	public void editSala(@RequestBody Sala s, @PathVariable Long id) {
		sService.editSala(s, id);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/sala/delete/{pbId}/{id}")
	public void deleteSala(@PathVariable Long pbId, @PathVariable Long id) {
		ArrayList<Long> ids = ps.getProjekcijeToBeDeleted(id);
		sService.deleteProjekcijeFromPB(ids, pbId);
		ps.deleteProjekcijaByIds(ids);
		sService.deleteSala(id, pbId, ids);

	}
}