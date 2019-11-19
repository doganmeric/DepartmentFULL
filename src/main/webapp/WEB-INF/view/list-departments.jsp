
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Departments</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">

</head>
<body>
 
<div id="wrapper">
	<div id="header">
		<h1>Departments Registration System</h1>
	</div>
	
</div>
<br>
<div id="search-bar">



 
	<table class="table">
		<tr>
		
			
			<frm:form action="searchDepartments" method="GET">
			
				<td align="right">Search:</td>
				<td width=80px><input type="text" name="searchDepName" /></td>
				<td><label>Manager name</label></td>
				<td><select class ="form-control"  name="searchMngrName" size="1">
					
					<option value="">-</option>
					<c:forEach var="manager" items="${employees}">
						<option value="${manager.firstName}">${manager.firstName} ${manager.lastName}</option>
					</c:forEach>					
				</select></td>
				<td><label>Location City</label></td>
				<td><select class ="form-control"  name="searchLocName" size="1">					
					<option value="">-</option>
					<c:forEach var="location" items="${locations}">
						<option value="${location.city}">${location.city}</option>
					</c:forEach>					
				</select></td>
				<!--  
				<td align="right">Managers:</td>
				<td width=80px><input type="text"  name="searchMngrName" /></td>
				<td align="right">Locations:</td>
				<td width=80px><input type="text" name="searchLocName" /></td>
				-->
				<td width=80px><input class="temp-button" type="submit" value="Search" /></td>
			</frm:form>	
			
		
		</tr>
	</table>

</div>
<br>
<frm:form action="updateOrDeleteDepartments" method="POST">
<div id="buttons-bar">



 
	<table class="table">
		<tr>
		<security:authorize access="hasRole('FULL')">
			<td><button type="button" onclick="window.location.href='addDepartmentForm'" 
			class="temp-button">Add department</button></td>
			
			<!--  
			<td><button onclick="window.location.href='updateDepartmentForm'" 
			class="update-button">Update</button></td>
			
			<td><button onclick="if (confirm('Confirm delete?')) window.location.href='deleteDepartment'"
					class="delete-button">Delete</button></td>
			-->
			<!--  bu dayılar ile uğraşmak lazım -->
			
			<td><input type="submit" class="temp-button" name="Update" value="Update" /> </td>
			
			<td><input type="submit" class="temp-button" name="Delete" value="Delete" onclick="return confirm('Are you sure?')" /> </td>		
		</security:authorize>
		</tr>
	</table>

</div>

<hr>

	<table class="standart-table">	
		<tr>
			
			<th>Department Name</th>
			<th>Department Manager</th>
			<th>Department Location</th>
			<th></th>

		</tr>
		
		<c:forEach var="department" items="${departments}">
			
			
			<tr>
				<td>${department.departmentName}</td>
				<td>${department.manager.firstName} ${department.manager.lastName}</td>
				<td>${department.location.city}-${department.location.streetAddress}</td>
				<td>
				<input  type="radio" name="radioButton"  value="${department.id}" required="required"  /></td>
			
			</tr>
		</c:forEach>
	
	</table>
	<label class="error">${errorMsg}</label>
	</frm:form>
</body>
</html>