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

/**
 * Servlet implementation class LogOutServlet
 */
@WebServlet("/logout")
public class LogOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogOutServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
		requestDispatcher.include(request, response);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		if (session != null) {
			request.getSession().removeAttribute("username");
			session.invalidate();
			System.out.println("session has invalidated and logged out");
		}
		out.println("<font color=red><h4>Thank you! You are successfully logged out.</h4></font>");
		out.close();
	}

}
