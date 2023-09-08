<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login - Todo Application</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" type="text/css" href="/css/login.css">
</head>
<body>
	<div class="card">
		<img src="logo.png" alt="Logo" class="logo">
		<div class="card-content">
			<h1>Login</h1>
			<form class="card-form" id="loginForm">
				<div class="form-group">
					<label for="email">Email:</label> <input type="text" id="email"
						name="email" required>
				</div>
				<div class="form-group">
					<label for="password">Password:</label> <input type="password"
						id="password" name="password" required>
				</div>
				<button type="submit" class="form-button">Login</button>
			</form>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="/js/login.js"></script>
</body>
</html>
