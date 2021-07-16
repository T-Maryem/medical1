package com.medical.medical1.service;

import java.util.Date;
import java.util.List;

import com.medical.medical1.dao.RendezVous;

public interface IRendezVousService {


	public void addRendezVous(String comment, long patient, long prestataire, Date date, String heure);
	public void editRendezVous(long id, String comment,   long prestataire, Date date, String heure);
	public void deleteRendezVous(long id); 
	public RendezVous getRendezVousById(long id);
	public List<RendezVous> getAllRendezVouss();
	public void traiterDmdRendezVous( long id, String etat); 
	public List<RendezVous> getAllRendezVousRecusByUser(int user);
	public List<RendezVous> getAllDemandesRecusByUser(int user);
	public List<RendezVous> getAllRendezVousEnvoyeByPatient(int patient);
}
