<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Apply Service</title>
</head>
<body>
	<center>
		<form action="insertdb.jsp" method="post">
			<table border="0" cellspacing="2" cellpadding="2">
				<thead>
					<tr>
						<th colspan="2">Apply For Our Bank Services</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><label>SID</label></td>
						<td><input type="text" name="txtsid"></td>
					</tr>
					<tr>
						<td><label>Service Name</label></td>
						<td><input type="text" name="txtsname"></td>
					</tr>
					<tr>
						<td><label>Loan Amount</label></td>
						<td><input type="text" name="txtsamount"></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="Apply Loan Service"><input type="reset" value="Clear"></td>
					</tr>
				</tbody>
			</table>
		</form>
		
		<font color="red">
			<c:if test="${not empty param.errMsg }">
				<c:out value="${param.errMsg}"></c:out>
				<a href-"service.jsp">Go To Service</a>
			</c:if>
		</font>
		<font color="green">
			<c:if test="${not empty param.successMsg }">
				<c:out value="${param.successMsg}"></c:out>
				<a href-"service.jsp">Go To Service</a>
			</c:if>
		</font>
		
	</center>
</body>
</html>

<!-- 
JSP use to 

 -->