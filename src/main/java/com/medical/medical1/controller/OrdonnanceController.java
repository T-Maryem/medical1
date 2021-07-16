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
 
import com.medical.medical1.dao.Ordonnance;
import com.medical.medical1.service.IOrdonnanceService;

@RestController
@RequestMapping("/ordonnance")
@CrossOrigin(originPatterns="http://localhost:4200" , allowedHeaders="*")
public class OrdonnanceController {
	@Autowired
	IOrdonnanceService ordoService ; 

	 @GetMapping("/all")
	 public List<Ordonnance> getAll(){
		 return ordoService.getAllOrdonnances();
	 }
	 
	 @GetMapping("/show/{id}")
	 public  Ordonnance  getOne(@PathVariable long id){
		 System.out.print("data ordoo  is : "+id);
		 return ordoService.getOrdonnanceByRDV(id);
	 }
	 
	 @DeleteMapping("/delete/{id}")
	 public  void  remove(@PathVariable long id){
		 ordoService.deleteOrdonnance(id);
	 }
 
	 
	 @PutMapping("/edit")
	 public  void  edit(@RequestBody JSONObject obj){
		 String descrip = obj.get("descrip").toString();  
		 Integer idC = Integer.parseInt(obj.get("id").toString());
		 long id = idC.longValue(); 
		 ordoService.editOrdonnance(id, descrip );
	 }

}
