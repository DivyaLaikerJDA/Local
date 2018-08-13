package com.jda.Filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class validation implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filter)
	      throws IOException, ServletException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		  String  emailRegex= "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
		  String passwordP = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
		  String password  = request.getParameter("password");
			 Pattern patternE,patternP;
			 Matcher matcherE,matcherP;
			 patternE = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
			 patternP = Pattern.compile(passwordP, Pattern.CASE_INSENSITIVE);
			 
			 matcherE = patternE.matcher(email);
			 matcherP = patternP.matcher(password);
			if(!matcherE.matches()){
				RequestDispatcher dispatcher = request.getRequestDispatcher("registeration.jsp");
				PrintWriter out = response.getWriter();
				out.println("<font color=red><center>please enter valid email</center></font>");
				dispatcher.include(request, response);
			}
			if(!matcherP.matches()){
				RequestDispatcher dispatcher = request.getRequestDispatcher("registeration.jsp");
				PrintWriter out = response.getWriter();
				out.println("<font color=red><center>please enter valid password</center></font>");
				dispatcher.include(request, response);
			}
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
