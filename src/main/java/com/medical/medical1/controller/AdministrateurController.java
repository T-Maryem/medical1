 package com.medical.medical1.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medical.medical1.service.IAdministrateurService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(originPatterns="http://localhost:4200" , allowedHeaders="*")
public class AdministrateurController {
	@Autowired
	IAdministrateurService adminService; 
	
	//https://ncovid.themetags.com/contact-us.html

}
