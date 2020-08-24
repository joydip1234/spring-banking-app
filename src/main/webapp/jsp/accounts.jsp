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


	<br>
	<table>
		<tr>
			<td><h1>Balance Check - Dashboard</h1></td>
		</tr>
	</table>
	<br>
	<table>
		<tr>
			<td><h1>${balance}</h1></td>
		</tr>
	</table>
	<table>
		<c:forEach items="${userList}" var="element">
			<tr>
				<td><a href="checkaccounts?user=${element}">${element}</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>