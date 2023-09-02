package com.ram.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ram.dao.UserDao;
import com.ram.model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;

	public void init() {
		userDao = new UserDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
			System.out.println("Inside login");
		User login = new User();
		login.setUsername(username);
		login.setPassword(password);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			if (userDao.validate(login)) {
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				response.sendRedirect("/QuestionPaper/list");
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				out.print("<font color=red><h2>Sorry username or Password is error.</h2></font>");
				rd.include(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
