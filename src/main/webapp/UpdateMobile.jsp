<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Mobile</title>
</head>
<body>
	<h1>Enter the details to be Updated</h1>

	<% ResultSet rs =  (ResultSet) request.getAttribute("resultSet");
	rs.next();
	%>
	
	<form action="save-updated-mobile" method="get">
	<input type="text" value=<%=rs.getInt(1)%> name="mobileId" readonly="readonly"> <br><br>
	<input type="text" value=<%=rs.getString(2)%> name="mobileModel"><br><br> 
	<input type="text" value=<%=rs.getString(3)%> name="mobileBrand"><br><br>
	<input type="number" value=<%=rs.getInt(4)%> name="mobilePrice"><br><br>
	<input type="submit" value="UPDATE">
	</form>
</body>
</html>