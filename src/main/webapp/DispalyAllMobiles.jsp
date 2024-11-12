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
<h1>Display All Mobiles</h1>
	<%
	ResultSet rs = (ResultSet) request.getAttribute("resultSet");
	%>
	<table border="2px">
		<tr>
			<th>MobileId</th>
			<th>MobileModel</th>
			<th>MobileBrand</th>
			<th>MobilePrice</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>

</body>
</html>