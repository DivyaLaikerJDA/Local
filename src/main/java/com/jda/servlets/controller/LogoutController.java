package com.jda.servlets.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutController extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException
	{
	HttpSession session = request.getSession();
	

	if(session.getAttribute("user")!=null)
	{
		session.removeAttribute("user");
		request.getSession(false).invalidate();
		response.sendRedirect("Login.jsp");
		
		System.out.println("logout successful!");
	}
	}

}
