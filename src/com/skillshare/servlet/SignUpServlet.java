package com.skillshare.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.skillshare.metier.User;
import com.skillshare.services.SkillShareService;

public class SignUpServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	private SkillShareService service = new SkillShareService();
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = (String) request.getAttribute("login");
		String email = (String) request.getAttribute("email");
		String password = (String)request.getAttribute("password");
		String firstname = (String)request.getAttribute("firstname");
		String name = (String)request.getAttribute("name");
		String tel = (String)request.getAttribute("tel");
		
		if(login != null && password != null && service.checkConnection(login, password)){
			HttpSession session = request.getSession();
			User user = new User();
			user.setPseudo(login);
			user.setPrenom(firstname);
			user.setNom(name);
			user.setTel(tel);
			user.setMail(email);
			user.setMdp(password);
			
			service.createAccount(user);
			session.setAttribute("user", user);
			response.setStatus(HttpServletResponse.SC_ACCEPTED);
			return;
		}
		
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		
	}
}
