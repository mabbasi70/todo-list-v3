<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Done Tasks</title>
	
	<!-- reference our style sheet -->
	
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css"/>
		  

</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>ToDo List - Your works manager!!!</h2>
		</div>
	</div>
			
			
	<div id="container">
		
		<div id="content">
		
			
	
			
				<!-- adding html table -->
			<table>
				<tr>
					<th>Task Name</th>		
					<th>Description</th>
					<th>Done Date</th>
					<th>Action</th>	
				</tr>
				
				<!-- loop over and print out tasks -->
				<c:forEach var="theTask" items="${doneTasks}">
					
					
					<c:url var="deleteLink" value="/doneTask/delete">
						<c:param name="taskId" value="${theTask.id}" />
					</c:url>   
					
					<tr>
						<td> ${theTask.taskName}</td>
						<td> ${theTask.description}</td>
						<td> ${theTask.doneDate}</td>						
						
					 	<td>
							<a href="${deleteLink}"
								onclick="if (!(confirm('Are you sure you want to delete this customer?!'))) return false">Delete</a>
						</td>  
												
					</tr>
				
				</c:forEach>
			
			</table>

			<br>
			<a href="${pageContext.request.contextPath}/">Back to Home</a>
			<hr>
			<a href="${pageContext.request.contextPath}/task/list">Task list</a>
							
		</div>
		
	</div>
	
</body>
</html>