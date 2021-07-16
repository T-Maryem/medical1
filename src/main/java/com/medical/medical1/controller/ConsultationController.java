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

import com.medical.medical1.dao.Consultation; 
import com.medical.medical1.service.IConsultationService;

@RestController
@RequestMapping("/consultation")
@CrossOrigin(originPatterns="http://localhost:4200" , allowedHeaders="*")
public class ConsultationController {
	@Autowired
	IConsultationService consService ;
	
	 @GetMapping("/all")
	 public List<Consultation> getAll(){
		 return consService.getAllConsultations();
	 }
	 
	 @GetMapping("/show/{id}")
	 public  Consultation  getOne(@PathVariable long id){
		 System.out.print("data  conss is : "+id);
		 return consService.getConsultationByRDV(id);
	 }
	 
	 @DeleteMapping("/delete/{id}")
	 public  void  remove(@PathVariable long id){
		 consService.deleteConsultation(id);
	 }
	 
  
	 
	 @PutMapping("/edit")
	 public  void  edit(@RequestBody JSONObject obj){
		 System.out.print("data is : "+obj);
		 String diagnostic = obj.get("diagnostic").toString(); 
		 Integer idC = Integer.parseInt(obj.get("id").toString());
		 long id = idC.longValue(); 
		 consService.editConsultation(id, diagnostic);
	 }


}
