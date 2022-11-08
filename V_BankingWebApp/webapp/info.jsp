<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*,java.util.*,java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- Scriplet Syntax -->
	<%
		int num = 10;
		
		/* void sum(){
			System.out,.println("Hi:);	Can't declare functions in scriplet syntax
		} */
		String time = Calendar.getInstance().getTime().toLocaleString();
		out.println("Welcome To Home! Request Received on Server At "+time);
	%>
	<!-- Declarative Syntax -->
	<%! String name = "Indian Banking Website"; %>
	<!-- Expression Syntax = out.println -->
	<%=	name%>
</body>
</html>