package com.skillshare.services;

import java.util.List;

import com.skillshare.metier.User;
import com.skillshare.nosql.*;

/**
 * 
 * @author JulienM
 */
public class SkillShareService 
{

	private NoSQLService nosql;

	public SkillShareService() {
		nosql = new NoSQLService();
	}

	// TODO : fonctionnalitées

	/**	
	 * En tant qu'utilisateur, je peux créer un compte à partir de mon nom, prénom, pseudo,
	 * 	email, mot de passe et téléphone
	 * 	dans le but d'être enregistré sur le site pour pouvoir me connecter.
	 * @param User 
	 */
	public void createAccount(User user)
	{
		//TODO: return id if OK
		 nosql.createAccount(user);
	}
	
	
	
	/**	
	 * En tant qu'utilisateur, je peux me connecter avec mon pseudo et mot de passe
	 *  à l'application dans le but de pouvoir accéder au contenu réservé du site.
	 */
	public boolean checkConnection(String pseudo, String pass)	{
		return nosql.connectionCheck(pseudo,pass);
	}
	
	
	

	/**
	 * En tant qu'utilisateur, je peux répondre à une demande de prise de contact d'une 
	 * personne pour permettre (ou non) à cette dernière de me contacter
	 * @param idOtherUser
	 * @param comment
	 */
	public void acceptRequestFromUser(int idOtherUser, String comment){

	}

	/**
	 * En tant qu'utilisateur, je peux éditer les champs nom, prénom, email 
	 * et/ou mot de passe et compétences de mon profil dans le but de mettre à jour 
	 * mes informations
	 * @param params
	 */
	public void changeProfilInfos(String nom, String prenom, String email, String mdp,
			List<String> skills){

	}

	/**
	 * En tant qu'utilisateur, je veux en cliquant sur un utilisateur de l'interface,
	 * afficher son profil dans le but de consulter ses informations
	 * @param idUser
	 * @return
	 */
	public User getUser(int idUser){
		return null;
	}





	/**
	 * 	En tant qu'utilisateur, je peux rechercher une personne ayant une compétence que 
	 * je souhaite acquérir en mentionnant les compétences désirées, 
	 * dans le but d'échange réciproque de cours avec cette personne
	 * @param params
	 * @return
	 */
	public List<User> searchProfiles(List<String> skills){
		return null;
	}

}