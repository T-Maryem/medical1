package com.medical.medical1.implementation;
 
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medical.medical1.dao.Messagerie;
import com.medical.medical1.repository.MessagerieRepository;
import com.medical.medical1.repository.UserRepository;
import com.medical.medical1.service.IMessagerieService;

@Service
public class MessagerieImp implements IMessagerieService{
	@Autowired
	MessagerieRepository msgRepo;
	@Autowired
	UserRepository userRepo;
	@Override
	public void sendMessage(String sujet, String contenue, long expediteur, long recepteur) {
		// TODO Auto-generated method stub
		Messagerie m = new Messagerie();
		m.setContenue(contenue);
		m.setDateEnvoie(new Date());
		m.setExpediteur(userRepo.getById(expediteur));
		m.setRecepteur(userRepo.getById(recepteur));
		m.setSujet(sujet);
		msgRepo.save(m);
	}

	@Override
	public void deleteMessage(long id) {
		// TODO Auto-generated method stub
		msgRepo.deleteById(id);
	}

	@Override
	public Messagerie getMessageById(long id) {
		// TODO Auto-generated method stub
		return msgRepo.getById(id);
	}

	@Override
	public List<Messagerie> getAllToUser(long id) {
		List<Messagerie> all = msgRepo.findAll();
		List<Messagerie> msgs = new ArrayList<>();
		for(int i =0; i<all.size(); i++){
			if(all.get(i).getRecepteur().getId() == id){
				msgs.add(all.get(i));
			}
		}
		return msgs;
	}
 
}
