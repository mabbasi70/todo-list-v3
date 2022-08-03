<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Save Task</title>
	<style> .error {color:red} </style>
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">
		  
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
		  
		  
		  
	
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>ToDo List - Your works manager!!!</h2>
		</div>
	</div>
	
	<i> * required </i>
	
	
		<div id="container">
		<h3>Save Task</h3>
		
		<form:form action="saveTask" modelAttribute="task" method="POST">
			<form:hidden path="id"/>
			<table>
				<tbody>
					<tr>
						<td><label>Task name:(*)</label></td>
						<td><form:input path="taskName" /></td>
						<td><form:errors path="taskName" cssClass="error"/></td>
					</tr>
					
					<tr>
						<td><label>Description:</label></td>
						<td><form:input path="description" /></td>
					</tr>
					
				   <tr>
						<td><label>Deadline:(*)</label></td>
						<td><form:input  type="date" path="deadline" /></td>
						<td><form:errors path="deadline" cssClass="error"/></td>
					</tr>    
					
					<tr>
						<td><label>Priority:</label></td>
						<td><form:input path="priority" /></td>
						<td><form:errors path="priority" cssClass="error"/></td>
					</tr>
					   
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
					
					
					
				</tbody>
			</table>
		
		</form:form>
		
		
		<br><br>

		
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/task/list">Back to List</a>
		</p>
		
	</div>
	

</body>
</html>