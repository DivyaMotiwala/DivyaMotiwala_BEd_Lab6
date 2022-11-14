<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Save Student</title>
</head>

<body>

	<div class="container">

		<h3>Student Directory</h3>
		<hr>

		<p class="h4 mb-4">Enter Student</p>

		<form action="/StudentManagement/students/save" method="POST">

			<!-- Add hidden form field to handle update -->
			<input type="hidden" name="studentId" value="${Students.studentId}" />

			<div class="form-inline">
				<input type="text" name="firstname" value="${Students.firstName}"
					class="form-control mb-4 col-4" placeholder="FirstName">



			</div>

			<div class="form-inline">

				<input type="text" name="lastname" value="${Students.lastName}"
					class="form-control mb-4 col-4" placeholder="LastName">



			</div>

			<div class="form-inline">

				<input type="text" name="course" value="${Students.course}"
					class="form-control mb-4 col-4" placeholder="Course">



			</div>
			<div class="form-inline">

				<input type="text" name="country" value="${Students.country}"
					class="form-control mb-4 col-4" placeholder="Country">



			</div>

			<button type="submit" class="btn btn-info col-2">Save</button>

		</form>

		<hr>
		<a href="/StudentManagement/students/list">Back to Students List</a>

	</div>
</body>

</html>









