package com.medical.medical1.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.medical.medical1.dao.Patient;
import com.medical.medical1.service.IPatientService;

@RestController
@RequestMapping("/patient")
@CrossOrigin(originPatterns="http://localhost:4200" , allowedHeaders="*")
public class PatientController {
	 @Autowired
	IPatientService patientService ; 
	 
	 @GetMapping("/all")
	 public List<Patient> getAll(){
		 return patientService.getAllPatients() ;
	 }
	 
	 @GetMapping("/show/{id}")
	 public  Patient  getOne(@PathVariable long id){
		 return patientService.getPatientById(id) ;
	 }
	 
	 @DeleteMapping("/delete/{id}")
	 public  void  remove(@PathVariable long id){
		 patientService.deletePatient(id);
	 }
	 
	 @PostMapping("/add")
	 public  void  add(@RequestBody Patient p){
		 patientService.addPatient(p);
	 }
	 
	 @PutMapping("/edit")
	 public  void  edit(@RequestBody Patient p){
		 patientService.editPatient(p);
	 }
	

}
