package com.skillshare.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;

import com.skillshare.metier.Skill;
import com.skillshare.metier.User;
import com.skillshare.nosql.NoSQLService;
import com.skillshare.services.SkillShareService;


public class UpdateServet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private SkillShareService service = new SkillShareService();


    public UpdateServet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		//User user = (User) session.getAttribute("user");
		
		User user = new NoSQLService().createAccount(new User("test", "test", "test", "test", "test", null));

		
		String email = (String) request.getAttribute("email");
		/*Rajouter la vérification que le mail est unique */
		String password = (String)request.getAttribute("password");
		String firstname = (String)request.getAttribute("firstname");
		String name = (String)request.getAttribute("lastname");
		String tel = (String)request.getAttribute("tel");
		JSONArray skills = (JSONArray)request.getAttribute("skills");
		
		System.out.println("email:"+email);
		System.out.println("password:"+password);
		System.out.println("firstname"+firstname);
		System.out.println("name:"+name);
		System.out.println("tel:"+tel);
		System.out.println("skills:"+skills);


		
		if(email == null) email = user.getMail();
		if(firstname == null) firstname = user.getPrenom();
		if(name == null) name = user.getNom();
		if(tel == null) tel = user.getTel();
		Map<Skill, Integer> competences = user.getCompetences();
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

		//User userup = new User();
		user.setPrenom(firstname);
		user.setNom(name);
		user.setTel(tel);
		user.setMail(email);
		user.setMdp(password);
		user.setCompetences(competences);
		service.changeProfilInfos(user);

		session.setAttribute("user", user);

		response.setStatus(HttpServletResponse.SC_ACCEPTED);
		return;
	}

}

