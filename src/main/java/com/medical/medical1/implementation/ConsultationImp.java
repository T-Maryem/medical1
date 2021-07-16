package com.medical.medical1.implementation;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medical.medical1.dao.Consultation;
import com.medical.medical1.repository.ConsultationRepository;
import com.medical.medical1.repository.RendezVousRepository;
import com.medical.medical1.service.IConsultationService;

@Service
public class ConsultationImp  implements IConsultationService{
	@Autowired
	ConsultationRepository consRepo;
	@Autowired
	RendezVousRepository rdvRepo;
	
	@Override
	public Consultation addConsultation(String diagnostic, long rdv) {
		// TODO Auto-generated method stub
		Consultation c = new Consultation();
		c.setDateConsultation(new Date());
		c.setDiagnostic(diagnostic);
		c.setRdv(rdvRepo.getById(rdv));
		return consRepo.save(c);
	}

	@Override
	public void editConsultation(long id, String diagnostic ) {
		// TODO Auto-generated method stub
		Consultation c = consRepo.getById(id);
		c.setDateConsultation(new Date());
		c.setDiagnostic(diagnostic); 
		consRepo.save(c);
	}

	@Override
	public void deleteConsultation(long id) {
		// TODO Auto-generated method stub
		consRepo.deleteById(id);
	}

	@Override
	public Consultation getConsultationByRDV(long id) {
		List<Consultation> all = consRepo.findAll(); 
		Consultation c = null; 
		for(int i=0; i<all.size(); i++){
			if(all.get(i).getRdv().getId()==id){
				c = all.get(i);
			}
		}
		return c;
	}

	@Override
	public List<Consultation> getAllConsultations() {
		// TODO Auto-generated method stub
		return consRepo.findAll();
	} 
}
