package com.medical.medical1.service;

import java.util.List;

import com.medical.medical1.dao.Messagerie; 

public interface IMessagerieService {

	
	public void sendMessage(String sujet, String contenue, long expediteur, long recepteur); 
	public void deleteMessage(long id); 
	public Messagerie getMessageById(long id);
	public List<Messagerie> getAllToUser(long id); 
}
