<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Record Form</title>
</head>
<body>
	<sql:setDataSource var="dbsource" driver="com.mysql.jdbc.Driver" 
			url="jdbc:mysql://localhost:3306/bnk_web_app?characterEncoding=utf8"
			user="root" password="oracle"/>
	
	
	<sql:query dataSource="${dbsource}" var="result">
		SELECT * FROM tblservice WHERE serviceid = '${param.sid}'
	</sql:query>
	
	<center>
		<form action="updatedb.jsp" method="post"></form>
			<table border="0" width="40%">
			<caption>Update Filtered Record</caption>
			<tr>
				<th>Name</th>
				<th>Amount</th>
			</tr>
			<c:forEach var="row" items="${result.rows}">
			<tr>	
				<td>
					<input type="hidden" value="${param.sid} name="txtsid">
					<input type="text" value="${row.servicename}" name="txtsname">
				</td>
				<td>
					<input type="text" value="${row.amount}" name="txtsamount">
				</td>
	
			</tr>
				</c:forEach>
				<tr>
					<td>
						<input type="submit" value="Update">
					</td>
				</tr>
			</table>
	</center>
</body>
</html>