package com.medical.medical1.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medical.medical1.dao.User;
import com.medical.medical1.repository.UserRepository;
import com.medical.medical1.service.IUserService;

@Service
public class UserImp implements IUserService{
	@Autowired
	UserRepository userRepo;

	@Override
	public User loginUser(String login, String password) {
		List<User> all = userRepo.findAll();
		User u = null; 
		for(int i=0; i<all.size(); i++){
			if(all.get(i).getLogin().equals(login) && all.get(i).getPassword().equals(password)){
				u = all.get(i);
			}
		}
		return u;
	}

	@Override
	public void validerUser(long id, String etat) {
		User u = userRepo.findById(id).get();
		u.setEtat(etat);
		userRepo.save(u);
		
	}
 

 
}
