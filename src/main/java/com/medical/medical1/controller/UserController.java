package com.medical.medical1.controller;

 
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medical.medical1.dao.User;
import com.medical.medical1.service.IUserService;
 
 
@RestController
@RequestMapping("/user")
@CrossOrigin(originPatterns="http://localhost:4200" , allowedHeaders="*")
public class UserController {
	@Autowired
	IUserService userService; 
	
	 @PostMapping("/login")
	 public  User  add(@RequestBody JSONObject obj){   
		 System.out.println("obj is : "+obj.toString());
		 String login = obj.get("login").toString();
		 String password = obj.get("password").toString();
		 System.out.println("nom of user is : "+userService.loginUser(login, password)); 
		 return userService.loginUser(login, password);
	 }
	 
	 
 	
}



