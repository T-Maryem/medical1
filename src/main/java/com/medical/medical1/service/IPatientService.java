package com.medical.medical1.service;

import java.util.List;

import com.medical.medical1.dao.Patient;
import com.medical.medical1.dao.Prestataire;

public interface IPatientService {


	public void addPatient(Patient p);
	public void editPatient(Patient p);
	public void deletePatient(long id); 
	public Patient getPatientById(long id);
	public List<Patient> getAllPatients();

}
