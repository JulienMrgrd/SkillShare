package com.skillshare.nosql;

import java.util.List;

import com.cloudant.client.api.Database;
import com.skillshare.metier.Skill;
import com.skillshare.metier.User;

public class NoSQLService {
	Database db;	

	public NoSQLService() {
		db = CloudantClientMgr.getDB();	
	}

	public boolean connectionCheck(String pseudo, String pass){
		//TODO
		return true;
	}
	
	
	/**
	 * Login exists
	 * @param login
	 * @return
	 */
	public boolean checkLogin(String login){
		//TODO
		return false;
	}

	public String createAccount(User user){
		return db.save(user).getId();
	}

	public boolean changeInfos(User user) {
        db.update(user);
        return true;
    }

	public List<User> searchProfiles(Skill skill){
		//TODO
		return null;
	}
	
	public static void main(String[] args) {
		new NoSQLService().createAccount(new User("nkjhgkgkjgk"));
		//TODO vos méthodes à tester ici
	}

}
