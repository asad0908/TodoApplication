<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>

	<form id="loginForm">
		<table>
			<tr>
				<td>Email:</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Login"></td>
			</tr>
		</table>
	</form>
	<script>
	$(document).ready(function(){
		$('#loginForm').submit(function(event){
			event.preventDefault();
			
			var formData = {
					email: $("input[name='email']").val(),
					password: $("input[name='password']").val()
			};
			
			$.ajax({
				type: "POST",
				url: "http://localhost:8080/api/user/login",
				data: JSON.stringify(formData),
				contentType: "application/json",
				success: function(response){
					console.log("Login Sucessful:", response);
					var authToken = response;
					localStorage.setItem("authToken",authToken);
					console.log("Token: ", authToken);
					window.location.href = "http://localhost:8080/view/dashboard";
				},
				error: function(err){
					console.error("Login error",err);
				}
			});
		});
	});
	
	</script>
	
	
	
	
</body>
</html>