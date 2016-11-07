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

	public User connectionCheck(String mail, String pass){
		//TODO
		return null;
	}
	
	/**
	 * Login exists
	 * @param login
	 * @return
	 */
	public boolean checkMail(String mail){
		List<User> users = db.findByIndex("\"selector\": {* \"mail\": \""+mail+"\"* }", User.class);
		if(users != null && !users.isEmpty()){
			return true;
		}
		return false;
	}

	public User createAccount(User user){
		user.setId(db.save(user).getId());
		user.setMdp(null);
		return user;
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
		User u = new NoSQLService().createAccount(new User("test", "test", "test", "test", "test", null));
		System.out.println(u);
		//TODO vos méthodes à tester ici
	}

}
