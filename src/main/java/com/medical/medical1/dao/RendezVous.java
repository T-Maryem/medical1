package com.medical.medical1.dao;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
public class RendezVous {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Temporal(TemporalType.DATE)
	private Date dateRDV;
	private String heureRDV;
	private String etatRDV;
	private String comment;
	
	@ManyToOne
	@JoinColumn(name="prestataire_id")
	private Prestataire prestataire;
	@ManyToOne
	@JoinColumn(name="patient_id")
	private Patient patient  ; 
	
	@OneToOne(mappedBy = "rdv")
	private Consultation consultation ;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateRDV() {
		return dateRDV;
	}

	public void setDateRDV(Date dateRDV) {
		this.dateRDV = dateRDV;
	}

	public String getHeureRDV() {
		return heureRDV;
	}

	public void setHeureRDV(String heureRDV) {
		this.heureRDV = heureRDV;
	}

	public String getEtatRDV() {
		return etatRDV;
	}

	public void setEtatRDV(String etatRDV) {
		this.etatRDV = etatRDV;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Prestataire getPrestataire() {
		return prestataire;
	}

	public void setPrestataire(Prestataire prestataire) {
		this.prestataire = prestataire;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Consultation getConsultation() {
		return consultation;
	}

	public void setConsultation(Consultation consultation) {
		this.consultation = consultation;
	} 
	

	
	

}

