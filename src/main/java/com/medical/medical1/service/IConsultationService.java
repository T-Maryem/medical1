package com.medical.medical1.service;
 
import java.util.List;

import com.medical.medical1.dao.Consultation; 

public interface IConsultationService {
	 
	public Consultation addConsultation(String diagnostic, long rdv);
	public void editConsultation(long id, String diagnostic );
	public void deleteConsultation(long id); 
	public Consultation getConsultationByRDV(long id);
	public List<Consultation> getAllConsultations();

}
