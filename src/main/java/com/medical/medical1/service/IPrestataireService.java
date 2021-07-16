package com.medical.medical1.service;

import java.util.List;

import com.medical.medical1.dao.Prestataire;

public interface IPrestataireService {
	public void addPrestatire(Prestataire p);
	public void editPrestataire(Prestataire p);
	public void deletePrestataire(long id); 
	public Prestataire getPrestataireById(long id);
	public List<Prestataire> getAllPrestataires();
	public List<Prestataire> getAllPrestatairesMedical();
	public List<Prestataire> getAllMedecins();
}
