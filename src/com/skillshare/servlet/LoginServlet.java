package com.skillshare.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.skillshare.metier.User;
import com.skillshare.services.SkillShareService;

/**
 * Servlet implementation class ContactServlet
 */
public class LoginServlet extends HttpServlet {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3580539381623668117L;
	
	private static final SkillShareService service = new SkillShareService();

    /**
     * Default constructor. 
     */
    public LoginServlet() { }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = (String) request.getParameter("email");
		String password = (String)request.getParameter("password");
		
		if(login != null && password != null && service.checkConnection(login, password)){
			HttpSession session = request.getSession();
			User user = new User(login);
			session.setAttribute("user", user);
			response.setStatus(HttpServletResponse.SC_ACCEPTED);
			return;
		}
		
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		
	}

}
