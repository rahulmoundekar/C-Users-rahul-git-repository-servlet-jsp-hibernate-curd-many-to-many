<!DOCTYPE html>
<%@page import="com.app.entity.Course"%>
<%@page import="com.app.entity.Student"%>
<%@page import="java.util.List"%>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<form class="form-horizontal" action="register" method="post">
			<%
				Student stud = (Student) request.getAttribute("stud");
				if (stud != null) {
			%>
			<fieldset>
				<!-- Form Name -->
				<legend>Form Name</legend>
				<input type="hidden" name="id" value="<%=stud.getId()%>">
				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="name">Enter Name</label>
					<div class="col-md-4">
						<input id="name" name="name" value="<%=stud.getName()%>"
							type="text" placeholder="Enter Name"
							class="form-control input-md" required="">

					</div>
				</div>

				<!-- Multiple Checkboxes (inline) -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="courses">Course</label>
					<div class="col-md-4">
						<%
							List<Course> c=stud.getCourses();
							List<Course> courses = (List<Course>) request.getAttribute("courses");
								for (Course course : courses) {
									if(c.retainAll(courses)){
						%>
								
								
						<label class="checkbox-inline" for="courses-0"> <input
							type="checkbox" checked="checked" name="courses" id="courses-0"
							value="<%=course.getId()%>"> <%=course.getName()%><br/> 
							
							<%}else{%>
							<label class="checkbox-inline" for="courses-0"> <input
							type="checkbox" name="courses" id="courses-0"
							value="<%=course.getId()%>"> <%=course.getName()%><br/> 
						
					 	<%}}
					 %>
					</div>
				</div>
				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label" for=""></label>
					<div class="col-md-4">
						<button type="submit" class="btn btn-primary">Update</button>
					</div>
				</div>
			</fieldset>




			<%
				} else {
			%>
			<fieldset>
				<!-- Form Name -->
				<legend>Form Name</legend>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="name">Enter Name</label>
					<div class="col-md-4">
						<input id="name" name="name" type="text" placeholder="Enter Name"
							class="form-control input-md" required="">

					</div>
				</div>

				<!-- Multiple Checkboxes (inline) -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="courses">Course</label>
					<div class="col-md-4">
						<%
							List<Course> courses = (List<Course>) request.getAttribute("courses");
								for (Course course : courses) {
						%>

						<label class="checkbox-inline" for="courses-0"> <input
							type="checkbox" name="courses" id="courses-0"
							value="<%=course.getId()%>"> <%=course.getName()%> <%
 	}
 %>
					</div>
				</div>
				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label" for=""></label>
					<div class="col-md-4">
						<button type="submit" class="btn btn-primary">Save</button>
					</div>
				</div>
			</fieldset>
			<%
				}
			%>





		</form>

		<h1>
			<font color="orange">Welcome to Concept Learning Centre</font>
		</h1>
		<table class="table table-condensed">
			<thead>
				<tr>
					<th>ID</th>
					<th>NAME</th>
					<th>COURSES</th>
					<th>ACTIONS</th>
				</tr>
			</thead>
			<tbody>
				<%
					List<Student> students = (List<Student>) request.getAttribute("students");
					if (!students.isEmpty()) {
						for (Student student : students) {
				%>
				<tr>
					<td><%=student.getId()%></td>
					<td><%=student.getName()%></td>
					<td>
						<%
							List<Course> coursesList = student.getCourses();
									for (Course course : coursesList) {
						%> <%=course.getName()%> <%
 	}
 %>
					</td>
					<td><a href="edit?id=<%=student.getId()%>">Edit</a> | <a
						href="delete?id=<%=student.getId()%>">Delete</a></td>
				</tr>
				<%
					}
					} else {
				%>
				<%
					out.write("Records Not found..!!!");
				%>
				<%
					}
				%>

			</tbody>
		</table>
	</div>

</body>
</html>
