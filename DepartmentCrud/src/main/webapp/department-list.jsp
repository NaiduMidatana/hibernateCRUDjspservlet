<%@page import="com.mouritech.departmentcrud.entity.Department"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*" isELIgnored="false" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align = "center">

	<h1>Department Management System</h1>
	<h2>
		<a href="new">Add New Department</a> 
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="list">List of Department</a> 
	</h2>
</div>
<div align="center">

	<table border="1" cellpadding = "5">
		<caption><h2>List of Department</h2></caption>
		<tr>
			<th>DepartmentId </th>
			<th>DepartmentName </th>
			<th>DepartmentHead </th>
			<th>Actions</th>
		</tr>
		<c:forEach var="dep" items = "${listDeps}">
		<tr>
			<td><c:out value= "${dep.deptId}" /></td>
			<td><c:out value= "${dep.deptName}" /></td>
			<td><c:out value= "${dep.deptHead}" /> </td>
			<td>
				<a href="edit?id=<c:out value= "${dep.deptId}" />">Edit Department</a> 
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="delete?id=<c:out value= "${dep.deptId}" />">Delete Department</a> 
			</td>
		</tr>
		</c:forEach>
	</table>
	</div>
</body>

</html>