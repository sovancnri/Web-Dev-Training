<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert Record</title>
	</head>
	<body>
		<c:if test="${empty param.txtsid or empty param.txtsname or param.txtsamount }">
			<c:redirect url="apply.jsp">
				<c:param name="errMsg" value="SID SName Amount are required"></c:param>
			</c:redirect>
		</c:if>
		
		<sql:setDataSource var="dbsource" driver="com.mysql.jdbc.Driver" 
		url="jdbc:mysql://localhost:3306/bnk_web_app?characterEncoding=utf8"
		user="root" password="oracle"/>
		
		<sql:update dataSource="${dbsource}" var="result">
			INSERT INTO tblservice VALUES (?,?,?)
			<sql:param value="${param.txtsid}"></sql:param>
			<sql:param value="${param.txtsname}"></sql:param>
			<sql:param value="${param.txtsamount}"></sql:param>
		</sql:update>
		
		<c:if test="${result>=1 }">
			<c:redirect url="apply.jsp" >
				<c:param name="successMsg" value="Congo! You're record got inserted"></c:param>
			</c:redirect>
		</c:if>
	</body>
</html>
<!-- 
JSP codes are of two types:
1. Scriptless - JSTL & Expression Language(EL)

EL - ${variable} = out.println(variable)
JSP 2.0 
 -->