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
		<%
		while (rs.next()) {
		%>
		<tr>
			<td><%=rs.getInt(1)%></td>
			<td><%=rs.getString("MobileModel")%></td>
			<td><%=rs.getString(3)%></td>
			<td><%=rs.getInt(4)%></td>
			<td><a href="update-mobile?mobileId=<%=rs.getInt(1)%>">UPDATE</a>
			</td>
			<td><a href="delete-mobile?mobileId=<%=rs.getInt(1)%>">DELETE</a></td>
		</tr>
		<%
		}
		%>
	</table>

	<h2>
		<a href="index.jsp">Go Back To Dash Board</a>
	</h2>

</body>
</html>