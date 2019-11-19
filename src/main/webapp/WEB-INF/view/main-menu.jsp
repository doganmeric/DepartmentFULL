<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Main Menu</title>
</head>
<body>

	<a href="department/list">Departments List</a>
	<frm:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type ="submit" value="Logout"/>
	</frm:form>	
</body>
</html>