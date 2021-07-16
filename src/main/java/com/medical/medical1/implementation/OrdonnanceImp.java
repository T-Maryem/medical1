package com.medical.medical1.implementation;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medical.medical1.dao.Ordonnance;
import com.medical.medical1.repository.ConsultationRepository;
import com.medical.medical1.repository.OrdonnanceRepository;
import com.medical.medical1.service.IOrdonnanceService;

@Service
public class OrdonnanceImp implements IOrdonnanceService{
	@Autowired
	OrdonnanceRepository ordoRepo;
	@Autowired
	ConsultationRepository consRepo; 
	@Override
	public void addOrdonnance(String descrip,  long consultation) {
		// TODO Auto-generated method stub
		Ordonnance o = new Ordonnance();
		o.setConsultation(consRepo.getById(consultation));
		o.setDateOrdo(new Date());
		o.setDescription(descrip); 
		ordoRepo.save(o);
	}

	@Override
	public void editOrdonnance(long id, String descrip  ) {
		// TODO Auto-generated method stub
		Ordonnance o = ordoRepo.getById(id) ; 
		o.setDateOrdo(new Date());
		o.setDescription(descrip); 
		ordoRepo.save(o);
	}

	@Override
	public void deleteOrdonnance(long id) {
		// TODO Auto-generated method stub
		ordoRepo.deleteById(id);
	}

	@Override
	public Ordonnance getOrdonnanceByRDV(long id) {
		List<Ordonnance> all = ordoRepo.findAll(); 
		Ordonnance o = null; 
		for(int i=0; i<all.size(); i++){
			if(all.get(i).getConsultation().getRdv().getId()==id){
				o = all.get(i);
			}
		}
		return o;
	}

	@Override
	public List<Ordonnance> getAllOrdonnances() {
		// TODO Auto-generated method stub
		return ordoRepo.findAll();
	}
}
