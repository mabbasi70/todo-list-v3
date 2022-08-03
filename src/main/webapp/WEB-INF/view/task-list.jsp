<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tasks</title>
	
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
		
			
			<!-- button -->
			
			<input type="button" value="Add Task"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button"
				/>
	
			
				<!-- adding html table -->
			<table>
				<tr>
					<th>Task Name</th>		
					<th>Priority</th>
					<th>Description</th>
					<th>Initial Date</th>
			    	<th>Deadline</th> 
					<th>Action</th>
					<th>Status</th>
					
				</tr>
				
				<!-- loop over and print out tasks -->
				<c:forEach var="theTask" items="${tasks}">
					
					<c:url var="addToDoneLink" value="/doneTask/addToDone">
						<c:param name="taskId" value="${theTask.id}"/>
						<c:param name="taskName" value="${theTask.taskName}"/>
						<c:param name="taskDes" value="${theTask.description}"/>
					</c:url>
					
			  		<c:url var="updateLink" value="/task/showFormForUpdate">
						<c:param name="taskId" value="${theTask.id}" />
					</c:url>   
					
					<c:url var="deleteLink" value="/task/delete">
						<c:param name="taskId" value="${theTask.id}" />
					</c:url>   
					
					<tr>
						<td> ${theTask.taskName}</td>
						<td> ${theTask.priority}</td>
						<td> ${theTask.description}</td>
						<td> ${theTask.initDate}</td>
				    	<td> ${theTask.deadline}</td>  
						
						
					 	<td>
							<a href="${updateLink }">Update</a>
							|
							<a href="${deleteLink}"
								onclick="if (!(confirm('Are you sure you want to delete this customer?!'))) return false">Delete</a>
						</td>  
						
						<td>
							<a href="${addToDoneLink}">Add to Done</a>
						</td> 
					</tr>
				
				</c:forEach>
			
			</table>
			
			<hr>
			
			<a href="${pageContext.request.contextPath}/">Back to Home</a>
			
		</div>
		
	</div>
	

</body>
</html>