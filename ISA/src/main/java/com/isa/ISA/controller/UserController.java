package com.isa.ISA.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isa.ISA.model.Admin;
import com.isa.ISA.model.Korisnik;
import com.isa.ISA.model.TipKorisnika;
import com.isa.ISA.model.User;
import com.isa.ISA.repository.KorisnikRepository;
import com.isa.ISA.service.AdminService;
import com.isa.ISA.service.KorisnikService;

@RestController
public class UserController {

	@Autowired
	private KorisnikService ks;
	@Autowired
	private AdminService as;
	@RequestMapping(value = "/returnUser")
	public User returnUser(HttpServletRequest request) {
		User u = (User) request.getSession().getAttribute("loggedUser");

		Korisnik reg = ks.getUser(u.getUsername());
		Admin adm = as.getAdmin(u.getUsername());
		if (reg == null && adm == null)
			return null;

		else {
			u = (reg != null) ? reg : adm;
		}
		return u;
	}
}
