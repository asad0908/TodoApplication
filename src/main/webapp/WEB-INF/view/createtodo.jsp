<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Todo</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Poppins&display=swap"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/css/createtodo.css">
</head>
<body>
	<div class="createtodo">
	<header>
		<h1>Create Todo</h1>
	</header>
	<div class="container">
		<form action="/api/todo" method="post">
			<div class="form-group">
				<label for="title">Title:</label> <input type="text" id="title"
					name="title">
			</div>
			<div class="form-group">
				<label for="description">Description:</label> <input type="text"
					id="description" name="description">
			</div>
			<div class="form-group">
				<label for="status">Status:</label> <select id="status"
					name="status">
					<option value="Pending">Pending</option>
					<option value="In Progress">In Progress</option>
					<option value="Completed">Completed</option>
				</select>
			</div>
			<div class="createtodo__submit">
				<input type="submit" class="form-button" value="Save">
			</div>
		</form>
	</div>
	</div>

	<!-- Include any necessary JavaScript scripts here -->
</body>
</html>
