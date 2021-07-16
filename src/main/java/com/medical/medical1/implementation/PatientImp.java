package com.medical.medical1.implementation;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medical.medical1.dao.Patient;
import com.medical.medical1.repository.PatientRepository;
import com.medical.medical1.service.IPatientService;

@Service 
public class PatientImp implements IPatientService {
	@Autowired
	PatientRepository patientRepo;

	@Override
	public void addPatient(Patient p) {
		// TODO Auto-generated method stub
		patientRepo.save(p);
	}

	@Override
	public void editPatient(Patient p) {
		// TODO Auto-generated method stub
		patientRepo.save(p);
	}

	@Override
	public void deletePatient(long id) {
		// TODO Auto-generated method stub
		patientRepo.deleteById(id);
	}

	@Override
	public Patient getPatientById(long id) {
		// TODO Auto-generated method stub
		return patientRepo.getById(id);
	}

	@Override
	public List<Patient> getAllPatients() {
		// TODO Auto-generated method stub
		return patientRepo.findAll();
	}


}
