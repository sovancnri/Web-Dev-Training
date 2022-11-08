<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<sql:setDataSource var="dbsource" driver="com.mysql.jdbc.Driver" 
			url="jdbc:mysql://localhost:3306/bnk_web_app?characterEncoding=utf8"
			user="root" password="oracle"/>
	<sql:update dataSource="${dbsource}" var="count">
		UPDATE tblservice SET servicename = ?, amount = ? WHERE serviceid = "${param.txtsid}"
		<sql:param value="${param.txtsname}"></sql:param>
		<sql:param value="${param.txtsamount}"></sql:param>
	</sql:update>
	
	<c:if test="${count>=1}">
		<font size="5" color="green">Congo !! Record got updated</font>
		<a href="service.jsp">Go To Service</a>
	</c:if>
</body>
</html>