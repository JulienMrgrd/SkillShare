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

		String email = (String) request.getParameter("email");
		String password = (String)request.getParameter("password");
		String firstname = (String)request.getParameter("firstname");
		String name = (String)request.getParameter("lastname");
		String tel = (String)request.getParameter("tel");

		if(email == null || password == null || firstname == null || name == null || tel == null)
		{
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		if(service.getUserFromLogin(email) != null)
		{
			response.sendError(HttpServletResponse.SC_FORBIDDEN);
			return;
		}

		User user = new User();
		user.setPrenom(firstname);
		user.setNom(name);
		user.setTel(tel);
		user.setMail(email);
		user.setMdp(password);
		service.createAccount(user);

		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		response.setStatus(HttpServletResponse.SC_ACCEPTED);
		return;
	}

}
