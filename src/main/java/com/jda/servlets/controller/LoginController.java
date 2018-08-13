package com.jda.servlets.controller;

import java.io.IOException;
import java.net.ResponseCache;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.jda.dao.DataBaseUtil;
import core.jda.servlets.model.Model;

public class LoginController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Model model = new Model();
		model.setUserName(request.getParameter("userName"));
		model.setPassword(request.getParameter("password"));
		Model userModel = DataBaseUtil.getUser(model.getUserName(), model.getPassword());
		if (userModel != null) {
			if(userModel.getPassword().equals(model.getPassword())){
				userModel.setPassword(null);
				request.getSession().setAttribute("user", userModel);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher(response.encodeRedirectUrl("WelcomePage.jsp"));
				requestDispatcher.forward(request, response);
				System.out.println("User logged in successfully");
			}else{
				request.setAttribute("passwordError", "Invalid password");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher(response.encodeRedirectURL("Login.jsp"));
				requestDispatcher.forward(request, response);
				System.out.println("User is not  logged in successfully");
			}
		} else {
			request.setAttribute("usernameErrorMessage", "error during login occured");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Login.jsp");
			requestDispatcher.forward(request, response);
			System.out.println("User is not  logged in successfully");
			System.out.println("authentication failed");
		}
	}
}
