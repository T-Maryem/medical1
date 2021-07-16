package com.medical.medical1.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity; 
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor; 

@Entity   
public class Prestataire extends User implements Serializable  {
	
	
	private static final long serialVersionUID = 1L;
  
	private String specialite; 
	private String adresse;  
	private String ville; 
	@JsonIgnore
	@OneToMany(mappedBy="prestataire")
	private List<RendezVous> rdvs;
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public List<RendezVous> getRdvs() {
		return rdvs;
	}
	public void setRdvs(List<RendezVous> rdvs) {
		this.rdvs = rdvs;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	

}
