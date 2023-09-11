<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Todo</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" type="text/css" href="/css/edittodo.css">
</head>
<body>
	<header>
		<h1>Edit Todo</h1>
	</header>
	<div class="container">
		<form id="editTodoForm">
			<input type="hidden" id="id" name="id" value="${id}">
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
			<div class="form-group">
				<input type="submit" class="form-button" value="Save">
			</div>
		</form>
	</div>

	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="/js/edittodo.js"></script>
</body>
</html>
