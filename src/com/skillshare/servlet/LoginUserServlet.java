package com.skillshare.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skillshare.metier.*;
import com.skillshare.services.*;


public class LoginUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private SkillShareService service = new SkillShareService();

	public LoginUserServlet() {}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try 
		{

			response.setContentType("text/plain");
			String pseudo = request.getParameter("peudo");
			String password = request.getParameter("mdp");
			if (!pseudo.equals("") && !password.equals("")) {
				service.checkConnection(request.getParameter ("pseudo"),request.getParameter ("mdp"));
			} else {
				throw new Exception("Il manque des parametres à l'URL!");
			}

		} catch (Exception e)  {
			e.printStackTrace(); 
			/*request.setAttribute("error", e); 
			request.getRequestDispatcher("error.jsp").forward(request, response);*/
		}


	}

}
