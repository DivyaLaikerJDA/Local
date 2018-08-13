<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
    <%@page import="core.jda.servlets.model.Model"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>welcome</title>
</head>
<body>
<a href="Login.jsp"></a><button type="submit"> back</button></a>

<center>


<%
 Model userModel = null;
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); 
if(session.getAttribute("user") == null){
	response.sendRedirect("Login.jsp");
}
	else
	userModel = (Model) session.getAttribute("user"); 
		

	
%>
<h1>Welcome!</h1>
<p>
<%=userModel.getFirstName() %>
</p>
</center>
<form action="logout" method="post">
<button type="submit" >Logout</button>
</form>
</body>
</html>