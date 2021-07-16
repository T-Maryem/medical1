package com.medical.medical1.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medical.medical1.dao.Prestataire;
import com.medical.medical1.repository.PrestataireRepository;
import com.medical.medical1.service.IPrestataireService;

@Service
public class PrestataireImp implements IPrestataireService{
	@Autowired
	PrestataireRepository prestRepo;

	@Override
	public void addPrestatire(Prestataire p) {
		// TODO Auto-generated method stub
		prestRepo.save(p);
	}

	@Override
	public void editPrestataire(Prestataire p) {
		// TODO Auto-generated method stub
		prestRepo.save(p);
	}

	@Override
	public void deletePrestataire(long id) {
		// TODO Auto-generated method stub
		prestRepo.deleteById(id);
	}

	@Override
	public Prestataire getPrestataireById(long id) {
		// TODO Auto-generated method stub
		return prestRepo.findById(id).get();
	}

	@Override
	public List<Prestataire> getAllPrestataires() { 
		// TODO Auto-generated method stub
		return prestRepo.findAll();
	}

	@Override
	public List<Prestataire> getAllPrestatairesMedical() {
		List<Prestataire> all = prestRepo.findAll();
		List<Prestataire> prests = new ArrayList<>();
		for(int i=0; i<all.size(); i++){
			if(all.get(i).getRole().equals("PRESTATAIRE")){
				prests.add(all.get(i));
			}
		}
		return prests;
	}

	@Override
	public List<Prestataire> getAllMedecins() {
		List<Prestataire> all = prestRepo.findAll();
		List<Prestataire> prests = new ArrayList<>();
		for(int i=0; i<all.size(); i++){
			if(all.get(i).getRole().equals("MEDECIN")){
				prests.add(all.get(i));
			}
		}
		return prests;
	} 
}
