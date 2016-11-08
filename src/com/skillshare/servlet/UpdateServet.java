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
import org.json.JSONObject;

import com.skillshare.metier.Skill;
import com.skillshare.metier.User;
import com.skillshare.nosql.NoSQLService;
import com.skillshare.services.SkillShareService;


public class UpdateServet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private SkillShareService service = new SkillShareService();


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		String email = null, password=null, firstname=null, name=null;
		String skillstring = null;


		if (request.getParameter("email")!=null) email =  request.getParameter("email");
		if (request.getParameter("password")!=null) password =  request.getParameter("password");
		if (request.getParameter("firstname")!=null) firstname =  request.getParameter("firstname");
		if (request.getParameter("lastname")!=null) name =  request.getParameter("lastname");
		if (request.getParameter("skills")!=null) skillstring =  request.getParameter("skills");


		if(email == null) email = user.getMail();
		if(firstname == null) firstname = user.getPrenom();
		if(name == null) name = user.getNom();


		try 
		{

			JSONArray skills = new JSONArray(skillstring);
			user.getCompetences().clear();
			for (int i=0; i<skills.length(); i++)	
			{
				String skill = (String) skills.getJSONObject(i).get("skill");
				Integer level = (Integer) skills.getJSONObject(i).getInt("level");
				//new_competences.put(Skill.valueOf(skill), level); 
				user.addCompetences(Skill.valueOf(skill), level);

			}
		} 
		catch (JSONException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		user.setPrenom(firstname);
		user.setNom(name);
		user.setMail(email);
		//user.setMdp(password);



		User user2 =service.changeProfilInfos(user);
		//System.out.println("Après update");
//		System.out.println(user2.getPrenom());
//		System.out.println(user2.getNom());
//		System.out.println(user2.getMail());
//		System.out.println(user2.getCompetences());

		session.setAttribute("user", user2);
		//response.setStatus(HttpServletResponse.SC_ACCEPTED);
		JSONObject jo = new JSONObject();
		try {
			jo.put("message", 1);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.getWriter().print(jo);
		return;
	}

}

