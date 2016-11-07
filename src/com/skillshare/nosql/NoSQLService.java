package com.skillshare.nosql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.cloudant.client.api.Database;
import com.skillshare.metier.Skill;
import com.skillshare.metier.User;
import com.skillshare.services.SkillShareService;

public class NoSQLService {
	Database db;	

	public NoSQLService() {
		db = CloudantClientMgr.getDB();	
	}

	public User connectionCheck(String pseudo, String pass){
		//TODO
		return null;
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

	public User createAccount(User user){
		user.setId(db.save(user).getId());
		user.setMdp(null);
		return user;
	}

	public User changeInfos(User user) {
        db.update(user);
        return user;
    }

	public List<User> searchProfiles(Skill skill){
		//TODO
		return null;
	}
	
	public static void main(String[] args) throws JSONException 
	{
		SkillShareService service = new SkillShareService();

		User user = new NoSQLService().createAccount(new User("1234","test", "test", "test", "test", "test", null));
		System.out.println(user.getId());
		
		Map<Skill, Integer> competences = user.getCompetences();
		
		JSONArray skills = new JSONArray();
		JSONObject jo = new JSONObject();
		jo.put("skill",Skill.JAVA);
		jo.put("level",2);
		skills.put(jo);
		
		
		Map<Skill,Integer> new_competences = new HashMap<>();

		
        for (int i=0; i<skills.length(); i++)	
        {
        	try 
        	{
				Skill skill = (Skill) skills.getJSONObject(i).get("skill");
				Integer level = (Integer) skills.getJSONObject(i).get("level");

				new_competences.put(skill, level);

			} 
        	catch (JSONException e) 
        	{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	

        }
        
		user.setId(user.getId());
		user.setPrenom("lina");
		user.setNom("nom");
		user.setTel("123456789");
		user.setMail("hi.lina@gmail.com");
		user.setMdp("123456789");
		user.setCompetences(new_competences);
		User user2 = service.changeProfilInfos(user);
		System.out.println(user2.getId());
		System.out.println(user2.getNom());
		System.out.println(user2.getPrenom());
		System.out.println(user2.getMail());
		System.out.println(user2.getCompetences());






		//TODO vos méthodes à tester ici
	}

}
