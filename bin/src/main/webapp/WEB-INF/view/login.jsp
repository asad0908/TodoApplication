<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login - Todo Application</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Poppins&display=swap"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/css/login.css">
</head>
<body>
	<div class="loginpage__container">
		<div class="loginpage__card">
			<div class="loginpage__card--heading">
				<h1>Login</h1>
			</div>
			<div class="loginpage__card--body">
				<form id="loginForm" method="POST">
					<div class="loginpage__card--input">
						<div class="loginpage__card--input-icon">
							<img
								src="https://cdn-icons-png.flaticon.com/128/266/266134.png?ga=GA1.1.839564024.1694157272" />
						</div>
						<input name="email" id="email" required type="email"
							placeholder="Email Address" />
					</div>
					<div class="loginpage__card--input">
						<div class="loginpage__card--input-icon">
							<img
								src="https://cdn-icons-png.flaticon.com/128/2889/2889676.png?ga=GA1.1.839564024.1694157272" />
						</div>
						<input name="password" id="password" required type="password"
							placeholder="Password" />
					</div>
					<div class="loginpage__card--forgotpass">
						<p>Forgot Password?</p>
					</div>
					<div class="loginpage__card--loginbutton">
						<button type="submit">Login</button>
					</div>
				</form>
				<div class="loginpage__card--signup">
					<p>
						Not a member? <span><a href="/view/signup">Signup Now</a></span>
					</p>
				</div>
			</div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="/js/login.js"></script>
</body>
</html>
