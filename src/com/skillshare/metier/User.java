package com.skillshare.metier;

import java.util.HashMap;
import java.util.Map;

public class User {
	
	private String id;
	private String nom;
	private String prenom;
	private String pseudo;
	private String mail;
	@SuppressWarnings("unused")
	private String mdp; // le mdp ne doit pas être stocké dans l'objet. Juste un setter pour mettre en base, aucun getter
	private String tel;
	private Map<Skill,Integer> competences = new HashMap<>(); //  peut contenir des objets String, à renseigner lors de la modif du profil
	
	public User() {}
	
	public User(String id) {
		this.id = id;
	}
	
	public User(String id, String nom, String prenom, String pseudo, String mail, String tel, Map<Skill,Integer> competences) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.pseudo = pseudo;
		this.mail = mail;
		this.tel = tel;
		this.competences = competences;
	}
	
	public User(String nom, String prenom, String pseudo, String mail, String tel, Map<Skill,Integer> competences) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.pseudo = pseudo;
		this.mail = mail;
		this.tel = tel;
		this.competences = competences;
	}

	/**
	 * Constructeur par copie
	 * @param copy
	 */
	public User(User copy){
		this.id = copy.id;
		this.nom = copy.nom;
		this.prenom = copy.prenom;
		this.pseudo = copy.pseudo;
		this.mail = copy.mail;
		this.tel = copy.tel;
		this.competences = copy.competences;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}

	public Map<Skill, Integer> getCompetences() {
		return competences;
	}

	public void setCompetences(Map<Skill, Integer> competences) {
		this.competences = competences;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}


}
