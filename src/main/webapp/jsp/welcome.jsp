<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<table>
		<tr>
			<td>Welcome ${firstname}</td>
		</tr>
		<tr>
		</tr>
		<tr>
		</tr>
		<tr>
			<td><a href="home.jsp">Home</a></td>
		</tr>
	</table>
	<br>
<h3>${status}</h3>
	<br>
	<br>
	<table>
		<tr>
			<td><h1>Dashboard</h1></td>
		</tr>
	</table>

	<table>
		<c:forEach items="${dashboardList}" var="element">
			<tr>
				<td>
					<a href="${element}">${element}</a>
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>