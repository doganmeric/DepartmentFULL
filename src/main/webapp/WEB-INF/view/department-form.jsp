<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Department Registration form</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">

<style>.error{color:red}</style>

</head>
<body>
<div id="wrapper">
	<div id="header">
		<h1>Department Registration Form</h1>
	</div>	
	<br><br>
</div>
<h3>Department Registration</h3>
<frm:form action="saveOrUpdateDepartment" modelAttribute="department" method="POST">

	<frm:hidden path="id"/>
	<input type="hidden" value="${mode}" name="mode"/>
	<table class="klasik-tablo">
		<tr>
			<td><label>Department name</label></td>
			<td><frm:input path="departmentName"/>
			<frm:errors path="departmentName" cssClass="error"/>
			</td>
			
		</tr>
		<tr>

			<td><label>Manager name</label></td>
			<td><select class ="form-control"  name="managerId" size="1">
				<option value="${department.manager.id }">${department.manager.firstName} ${department.manager.lastName}</option>
				<option value="-1111">-</option>
				<c:forEach var="manager" items="${employees}">
					<option value="${manager.id}">${manager.firstName} ${manager.lastName}</option>
				</c:forEach>					
			</select></td>
		</tr>
		<tr>
			<td><label>Location City</label></td>
			<td><select class ="form-control"  name="locationId" size="1">
				<option value="${department.location.id }">${department.location.city}</option>
				<option value="-1111">-</option>
				<c:forEach var="location" items="${locations}">
					<option value="${location.id}">${location.city}</option>
				</c:forEach>					
			</select></td>
			
			
		</tr>

		
		<tr>
			<td><label></label></td>
			
			<td><input class="temp-button" type="submit" value="Save" class="save-button"/></td>
			
		</tr>		
	</table>
	<label class="error">${errorMsg}</label>
	
</frm:form>

<div id="content">
	<button onclick="window.location.href='${pageContext.request.contextPath}/department/list'" class="temp-button">
		Back to list</button>
</div>

</body>
</html>