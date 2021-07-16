package com.medical.medical1.dao;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
public class Messagerie {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Temporal(TemporalType.DATE)
	private Date dateEnvoie;
	private String sujet;
	private String contenue ; 
	@ManyToOne
	@JoinColumn(name="expediteur_id")
	private User expediteur  ; 
	@ManyToOne
	@JoinColumn(name="recepteur_id")
	private User recepteur;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDateEnvoie() {
		return dateEnvoie;
	}
	public void setDateEnvoie(Date dateEnvoie) {
		this.dateEnvoie = dateEnvoie;
	}
	public String getSujet() {
		return sujet;
	}
	public void setSujet(String sujet) {
		this.sujet = sujet;
	}
	public String getContenue() {
		return contenue;
	}
	public void setContenue(String contenue) {
		this.contenue = contenue;
	}
	public User getExpediteur() {
		return expediteur;
	}
	public void setExpediteur(User expediteur) {
		this.expediteur = expediteur;
	}
	public User getRecepteur() {
		return recepteur;
	}
	public void setRecepteur(User recepteur) {
		this.recepteur = recepteur;
	}
		

}
