package com.medical.medical1.implementation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medical.medical1.dao.Prestataire;
import com.medical.medical1.dao.RendezVous;
import com.medical.medical1.repository.PatientRepository;
import com.medical.medical1.repository.PrestataireRepository;
import com.medical.medical1.repository.RendezVousRepository;
import com.medical.medical1.service.IRendezVousService;

@Service
public class RendezVousImp implements IRendezVousService {
	@Autowired
	RendezVousRepository rdvRepo;
	@Autowired
	PatientRepository patientRepo;
	@Autowired
	PrestataireRepository prestRepo;
	
	@Override
	public void addRendezVous(String comment, long patient, long prestataire, Date date, String heure) {
		// TODO Auto-generated method stub
		RendezVous r = new RendezVous(); 
		r.setComment(comment);
		r.setDateRDV(date);
		r.setEtatRDV("En Attente");
		r.setHeureRDV(heure);
		r.setPatient(patientRepo.getById(patient));
		r.setPrestataire(prestRepo.getById(prestataire));
		rdvRepo.save(r);
	}

	@Override
	public void editRendezVous(long id, String comment,   long prestataire, Date date, String heure) {
		// TODO Auto-generated method stub
		RendezVous r =  rdvRepo.getById(id);
		r.setComment(comment);
		r.setDateRDV(date); 
		r.setHeureRDV(heure);
		//r.setPatient(patientRepo.getById(patient));
		r.setPrestataire(prestRepo.getById(prestataire));
		rdvRepo.save(r);
	}

	@Override
	public void deleteRendezVous(long id) {
		// TODO Auto-generated method stub
		rdvRepo.deleteById(id);
	}

	@Override
	public RendezVous getRendezVousById(long id) {
		// TODO Auto-generated method stub
		return rdvRepo.findById(id).get();
	}

	@Override
	public List<RendezVous> getAllRendezVouss() {
		// TODO Auto-generated method stub
		return rdvRepo.findAll();
	}

	@Override
	public void traiterDmdRendezVous(long id, String etat) {
		RendezVous r = rdvRepo.getById(id); 
		r.setEtatRDV(etat);
		rdvRepo.save(r);
	}

	@Override
	public List<RendezVous> getAllRendezVousRecusByUser(int user) {
		List<RendezVous> all = rdvRepo.findAll();
		List<RendezVous> rdvs = new ArrayList<>();
		for(int i=0; i<all.size(); i++){
			if(all.get(i).getPrestataire().getId()==user && all.get(i).getEtatRDV().equals("Accepté")){
				rdvs.add(all.get(i));
			}
		}
		return rdvs;
	}

	@Override
	public List<RendezVous> getAllRendezVousEnvoyeByPatient(int patient) {
		List<RendezVous> all = rdvRepo.findAll();
		List<RendezVous> rdvs = new ArrayList<>();
		for(int i=0; i<all.size(); i++){
			if(all.get(i).getPatient().getId()==patient){
				rdvs.add(all.get(i));
			}
		}
		return rdvs;
	}

	@Override
	public List<RendezVous> getAllDemandesRecusByUser(int user) {
		List<RendezVous> all = rdvRepo.findAll();
		List<RendezVous> rdvs = new ArrayList<>();
		for(int i=0; i<all.size(); i++){
			if(all.get(i).getPrestataire().getId()==user && (all.get(i).getEtatRDV().equals("En Attente") || all.get(i).getEtatRDV().equals("Refusé") )){
				rdvs.add(all.get(i));
			}
		}
		return rdvs;
	}
}
