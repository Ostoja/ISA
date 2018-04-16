package com.isa.ISA.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isa.ISA.model.Admin;
import com.isa.ISA.model.Korisnik;
import com.isa.ISA.model.User;
import com.isa.ISA.service.AdminService;
import com.isa.ISA.service.KorisnikService;

@RestController
public class LoginController {
	@Autowired
    private KorisnikService ks;
    @Autowired
    private AdminService as;

    @RequestMapping(method = RequestMethod.POST, value = "/api/login") 
    public User login(@RequestBody User us, HttpServletRequest request){
    	System.out.println("BBB "+us);
    	String username = us.getUsername();
		String password = us.getPassword();
		 
        User u;
        Korisnik reg = ks.getUser(username);
        Admin adm = as.getAdmin(username);
        if(reg==null && adm==null)
            return null;
        
        else{
            u = (reg != null) ? reg: adm;
        }
        if(u.getPassword().equals(password)){
        	if(u instanceof Admin && u.getPassword().equals("default") )
        		u.setJeAktivan(false);
        	request.getSession().setAttribute("loggedUser", u);
        	System.out.println("User je "+u.getIme()+" "+request.getSession().getAttribute("loggedUser"));
            return u;
        }
        	
        else
            return null;
}
}
