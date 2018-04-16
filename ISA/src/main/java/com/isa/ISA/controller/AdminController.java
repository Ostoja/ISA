package com.isa.ISA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isa.ISA.model.Admin;
import com.isa.ISA.service.AdminService;

@RestController
public class AdminController {
	 @Autowired
	 private AdminService as;

	    @RequestMapping("/api/admins")
	    public List<Admin> getAllAdmins(){
	    	return as.getAllAdmins(); 
	    }

	    @RequestMapping(method = RequestMethod.POST,value = "/api/admins")
	    public void addAdmin(@RequestBody Admin a){
	        as.addAdmin(a);
	    }
	    
	    @RequestMapping(method = RequestMethod.GET,value = "/admin/{username}")
	    public Admin getAdmin(@PathVariable String username){ 
	    	return as.getAdmin(username); 
	    }
	    
	    @RequestMapping(method = RequestMethod.PUT,value="/admin/{id}")
	    public void updateAdmin(@RequestBody Admin a, @PathVariable Long id){
	        as.updateAdmin(a);
	    }

	    @RequestMapping(method = RequestMethod.PUT,value="/admin/{id}/pass")
	    public void updateAdminPassword(@RequestBody Admin a, @PathVariable Long id){
	        as.updatePassword(a);
	    }

	    @RequestMapping(method = RequestMethod.DELETE, value = "/admin/{id}")
	    public void deleteAdmin(@RequestBody Admin a, @PathVariable Long id){
	        as.deleteAdmin(a);
	    }

	    
	
}
