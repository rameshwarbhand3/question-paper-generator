package com.ram.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession(false);
		if (!req.getRequestURI().contains("/login") && !req.getRequestURI().contains("/sign-up.jsp")
				&& !req.getRequestURI().contains("/signUpServlet")
				&& (session == null || session.getAttribute("username") == null)) {
			req.getRequestDispatcher("login.jsp").forward(req, response);
			return;
		}
		chain.doFilter(request, response);
	}

}
