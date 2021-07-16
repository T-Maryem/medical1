package com.medical.medical1.service;

import java.util.List;
 
import com.medical.medical1.dao.Ordonnance;

public interface IOrdonnanceService {
	

	public void addOrdonnance(String descrip,   long consultation );
	public void editOrdonnance(long id, String descrip   );
	public void deleteOrdonnance(long id); 
	public Ordonnance getOrdonnanceByRDV(long id);
	public List<Ordonnance> getAllOrdonnances();


}
