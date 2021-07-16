package com.medical.medical1.service;
 
import com.medical.medical1.dao.User;


public interface IUserService {

    public User loginUser(String login, String password);
    public void validerUser(long id, String etat);
    
}
