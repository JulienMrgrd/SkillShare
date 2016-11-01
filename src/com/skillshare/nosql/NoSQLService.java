package com.skillshare.nosql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cloudant.client.api.Database;
import com.cloudant.client.api.model.Response;
import com.skillshare.metier.User;

public class NoSQLService {
	Database db;	

	public NoSQLService() {
		db = CloudantClientMgr.getDB();	
	}

	public boolean connectionCheck(String pseudo, String pass)
	{
		return true;
	}

	@SuppressWarnings("unchecked")
	public String createAccount(User user){
		Response resp = db.save(user);
		Map<String, String> createdObject = db.find(HashMap.class, resp.getId());
		if(createdObject !=null){
			System.out.println();			
		}
		return resp.getId();
	}

	public boolean changeInfos(Map<String, String> params){
		return true;
	}

	public List<User> searchProfiles(Map<String, String> params){
		return null;
	}

}
