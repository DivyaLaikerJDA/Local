package com.jda.servlets.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.jda.dao.DataBaseUtil;
import core.jda.servlets.model.Model;

public class RegisterController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		Model model = new Model();
		model.setFirstName(request.getParameter("firstName"));
		model.setLastName(request.getParameter("lastName"));
		model.setUserName(request.getParameter("userName"));
		model.setEmail(request.getParameter("email"));
		model.setGender(request.getParameter("gender"));
		model.setPassword(request.getParameter("password"));
		boolean flag = DataBaseUtil.registerUser(model);
		 System.out.println(flag);
	}
}
