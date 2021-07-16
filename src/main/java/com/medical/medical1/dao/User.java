package com.medical.medical1.dao;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity 
@Inheritance(strategy= InheritanceType.JOINED)
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id ;
	private String nom;
	private String prenom; 
	private String email;
	private int tel ; 
	private String sexe; 
	private String login;
	private String password;
	private String role; 
	private String etat;
	@JsonIgnore
	@OneToMany(mappedBy="expediteur")
	private List<Messagerie> msg ; 
	@JsonIgnore
	@OneToMany(mappedBy="recepteur")
	private List<Messagerie> messages ;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public List<Messagerie> getMsg() {
		return msg;
	}
	public void setMsg(List<Messagerie> msg) {
		this.msg = msg;
	}
	public List<Messagerie> getMessages() {
		return messages;
	}
	public void setMessages(List<Messagerie> messages) {
		this.messages = messages;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	} 
	
	
	


	

}
