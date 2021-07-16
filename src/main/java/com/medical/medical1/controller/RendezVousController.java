package com.medical.medical1.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import org.json.simple.JSONObject;

import com.medical.medical1.dao.Consultation;
import com.medical.medical1.dao.RendezVous;
import com.medical.medical1.service.IConsultationService;
import com.medical.medical1.service.IOrdonnanceService;
import com.medical.medical1.service.IRendezVousService;

@RestController
@RequestMapping("/rdv")
@CrossOrigin(originPatterns="http://localhost:4200" , allowedHeaders="*")
public class RendezVousController {
	@Autowired
	IRendezVousService rdvService; 
	@Autowired
	IConsultationService consService ;
	@Autowired
	IOrdonnanceService ordoService ; 
	
	
	 @GetMapping("/all")
	 public List<RendezVous> getAll(){
		 return rdvService.getAllRendezVouss() ;
	 }
	 
	 @GetMapping("/allDMDRecusToUser/{id}")
	 public List<RendezVous> allDMDRecusToUser(@PathVariable int id){
		 return rdvService.getAllDemandesRecusByUser(id) ;
	 }
	 
	 @GetMapping("/allRDVRecusToUser/{id}")
	 public List<RendezVous> allRDVRecusToUser(@PathVariable int id){
		 return rdvService.getAllRendezVousRecusByUser(id)  ;
	 }
	 
	 @GetMapping("/show/{id}")
	 public  RendezVous  getOne(@PathVariable long id){
		 System.out.print("data rdv is : "+id);
		 return rdvService.getRendezVousById(id) ;
	 }
	 
	 @DeleteMapping("/delete/{id}")
	 public  void  remove(@PathVariable long id){
		 rdvService.deleteRendezVous(id);
	 }
	 
 
	 @PostMapping("/add")
	 public  void  add(@RequestBody JSONObject obj){
		 String comment = obj.get("comment").toString();
		 long patient = (long) obj.get("patient");
		 long prestataire = (long) obj.get("prestataire");
		 Date dateR = null; 
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 try {
			dateR = sdf.parse(obj.get("date").toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		 String heure = obj.get("heure").toString(); 
		 rdvService.addRendezVous(comment, patient, prestataire, dateR, heure);
	 }
	 
	 @PutMapping("/edit")
	 public  void  edit(@RequestBody JSONObject obj){
		 String comment = obj.get("comment").toString();
		 long id = (long) obj.get("id");
		 //long patient = (long) obj.get("patient");
		 long prestataire = (long) obj.get("prestataire");
		 Date dateR = null; 
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 try {
			dateR = sdf.parse(obj.get("date").toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		 String heure = obj.get("heure").toString(); 
		 rdvService.editRendezVous(id, comment, prestataire, dateR, heure);
	 }
	 
	 @PutMapping("/valider")
	 public  void  valider(@RequestBody JSONObject obj){
		 String etat = obj.get("etat").toString();
		 Integer idrdv =  Integer.parseInt(obj.get("id").toString());
		 long id = idrdv.longValue();   
		 rdvService.traiterDmdRendezVous(id , etat);
		 if(etat.equals("Accepté")){
			 Consultation   c = consService.addConsultation("", id); 
			 ordoService.addOrdonnance("", c.getId());
		 }
		 
	 }

}
