package com.medical.medical1.dao;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;


import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity 
public class Patient extends User implements Serializable  {
	 
	private static final long serialVersionUID = 1L;

	private int age;
	private Date dateCreation; 
	@JsonIgnore
	@OneToMany(mappedBy="patient")
	private List<RendezVous> rdvs;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
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
