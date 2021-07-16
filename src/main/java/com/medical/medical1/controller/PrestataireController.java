package com.medical.medical1.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.medical.medical1.dao.Prestataire;
import com.medical.medical1.service.IPrestataireService;
import com.medical.medical1.service.IUserService;

@RestController
@RequestMapping("/prestataire")
@CrossOrigin(originPatterns="http://localhost:4200" , allowedHeaders="*")
public class PrestataireController {
	@Autowired
	IPrestataireService prestataireService; 
	@Autowired
	IUserService userService; 
	
	
	 @GetMapping("/all")
	 public List<Prestataire> getAll(){
		 return prestataireService.getAllPrestataires() ;
	 }
	 
	 @GetMapping("/allMedical")
	 public List<Prestataire> getallMedical(){
		 return prestataireService.getAllPrestatairesMedical() ;
	 }
	 
	 @GetMapping("/allMedecin")
	 public List<Prestataire> getallMedecin(){
		 return prestataireService.getAllMedecins() ;
	 }
	 
	 @GetMapping("/show/{id}")
	 public  Prestataire  getOne(@PathVariable long id){
		 return prestataireService.getPrestataireById(id) ;
	 }
	 
	 @DeleteMapping("/delete/{id}")
	 public  void  remove(@PathVariable long id){
		 prestataireService.deletePrestataire(id);;
	 }
	 
	 @PostMapping("/add")
	 public  void  add(@RequestBody Prestataire p){
		 prestataireService.addPrestatire(p);;
	 }
	 
	 @PutMapping("/edit")
	 public  void  edit(@RequestBody Prestataire p){
		 prestataireService.editPrestataire(p);
	 }
	 
	 @PutMapping("/valider")
	 public  void  valider(@RequestBody JSONObject obj){
		 String etat = obj.get("etat").toString();
		 Integer idrdv =  Integer.parseInt(obj.get("id").toString());
		 long id = idrdv.longValue();   
		 userService.validerUser(id, etat); 
	 }
}
