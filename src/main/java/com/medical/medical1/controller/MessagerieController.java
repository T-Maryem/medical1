package com.medical.medical1.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medical.medical1.dao.Messagerie; 
import com.medical.medical1.service.IMessagerieService;

@RestController
@RequestMapping("/message")
@CrossOrigin(originPatterns="http://localhost:4200" , allowedHeaders="*")
public class MessagerieController {
	@Autowired
	IMessagerieService msgService ;
	 
  
	
	@GetMapping("/allRecivedToUser/{id}")
	 public List<Messagerie> getAllByUser(@PathVariable long id){
		 return msgService.getAllToUser(id);
	 }
	 
	 @GetMapping("/show/{id}")
	 public  Messagerie  getOne(@PathVariable long id){
		 return msgService.getMessageById(id);
	 }
	 
	 @DeleteMapping("/delete/{id}")
	 public  void  remove(@PathVariable long id){
		 msgService.deleteMessage(id);
	 }
	  
	 @PostMapping("/add")
	 public  void  add(@RequestBody JSONObject obj){  
		 String sujet = obj.get("sujet").toString();
	 	 String contenue = obj.get("contenue").toString();
		 long expediteur = (long) obj.get("expediteur"); 
		 long recepteur = (long) obj.get("recepteur"); 
		 msgService.sendMessage(sujet, contenue, expediteur, recepteur);
	 }
	 
 
}
