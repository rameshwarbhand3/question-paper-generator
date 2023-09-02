package com.ram.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ram.dao.UserDao;
import com.ram.model.User;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/signUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDao userDao;

	public void init() {
		userDao = new UserDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("userName");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");

		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setLastName(lastName);
        
		try {
			userDao.insert(user);
		} catch (SQLException e) {	
			e.printStackTrace();
		}
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		out.println("<font color=red><h2 text-align=\"center\">You are successfully registerd!!!.</h2></font>");

		rd.include(request, response);
	
	}
}

