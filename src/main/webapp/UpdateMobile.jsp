<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Enter the details to be Updated</h1>

	<% ResultSet rs =  (ResultSet) request.getAttribute("resultSet");
	rs.next();
	%>
	
</body>
</html>