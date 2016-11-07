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
	
	public User findById(String id){
		User doc = db.find(User.class,id);
		doc.setId(id);
		return doc;
	}

	public User connectionCheck(String mail, String pass){
		List<User> users = db.findByIndex("\"selector\": {\"mail\": \""+mail+"\", \"mdp\": \""+pass+"\"}", User.class);
		if(users != null && users.size()==1){
			return users.get(0);
		}
		return null;
	}
	
	public boolean checkMail(String mail){
		List<User> users = db.findByIndex("\"selector\": { \"mail\": \""+mail+"\"}", User.class);
		return (users != null && users.size()==1);
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
		NoSQLService no = new NoSQLService(); 
//		User user = new User("Julien2", "Margarido2", "jm2@gmail.com", "0606060608", null);
//		user.setMdp("mdp");
//		User res = no.createAccount(user);
//		System.out.println(res.getId());
		
		User b = no.connectionCheck("jm2@gmail.com", "mdp");
		System.out.println(b);
		System.out.println("Fin tests");
		//TODO vos méthodes à tester ici (en mode débug, c'est cool)
	}

}
