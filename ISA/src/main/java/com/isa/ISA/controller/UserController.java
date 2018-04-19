package com.isa.ISA.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isa.ISA.model.Admin;
import com.isa.ISA.model.Korisnik;
import com.isa.ISA.model.TipKorisnika;
import com.isa.ISA.model.User;
import com.isa.ISA.model.DTO.PasswordDTO;
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
	
	@RequestMapping(value ="/changepassword")
	private boolean changePassword(@RequestBody PasswordDTO p, HttpServletRequest request) {
		if(!p.getNewpass().equals(p.getNewpass2())) {
			return false;
		}
		else {
			User u = (User) request.getSession().getAttribute("loggedUser");
			if(!u.getPassword().equals(p.getOldpass())) {
				return false;
			}
			else {
				request.getSession().setAttribute("loggedUser", u);
				if(u.getTip()==TipKorisnika.Obican) {
					Korisnik k = ks.getUser(u.getUsername());
					k.setJeAktivan(true);
					k.setPassword(p.getNewpass());
					ks.addUser(k);
				}
				else {
					Admin a = as.getAdmin(u.getUsername());
					a.setJeAktivan(true);
					a.setPassword(p.getNewpass());
					as.updateAdmin(a);
				}
				return true;
			}
			
		}
	}
	
	@RequestMapping(value ="/edituser")
	private String editUser(@RequestBody User kor, HttpServletRequest request) {
		System.out.println("AAAAAAA");
		System.out.println("AA "+kor.toString());
		Korisnik reg = ks.getUser(kor.getUsername());
		Admin adm = as.getAdmin(kor.getUsername());
		if (reg != null || adm != null) {

			return "Username is already taken.";
		}
		User korEmail = ks.findByEmail(kor.getEmail());
		Admin adminEmail = as.getAdminByEmail(kor.getEmail());
		if (korEmail != null || adminEmail != null) {

			return "Email is already taken.";
		}
		Korisnik k = new Korisnik();
		k.setUsername(kor.getUsername());
		k.setPassword(kor.getPassword());
		k.setEmail(kor.getEmail());
		k.setJeAktivan(kor.getJeAktivan());
		k.setBrojTelefona(kor.getBrojTelefona());
		k.setGrad(kor.getGrad());
		k.setIme(kor.getIme());
		k.setPrezime(kor.getPrezime());
		ks.addUser(k);
		request.getSession().setAttribute("loggedUser", k);
		//EmailService es = new EmailService(k.getEmail());
		System.out.println("Account with username " + k.getUsername() + "has been edited");
		return "";
	}
}
