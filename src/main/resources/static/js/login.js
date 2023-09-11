/*
if (localStorage.getItem("authToken") != null) {
	window.location.href = "http://localhost:8080/view/dashboard";
}
*/

$(document).ready(function() {
	$("#loginForm").submit(function(event) {
		event.preventDefault();
		var formData = {
			email: $("#email").val(),
			password: $("#password").val()
		};

		$.ajax({
			type: "POST",
			url: "http://localhost:8080/api/user/login",
			data: JSON.stringify(formData),
			contentType: "application/json",
			success: function(response) {
				console.log("Login Successful:", response);
				var authToken = response.token;
				localStorage.setItem("authToken", authToken);
				console.log("Token: ", authToken);
				window.location.href = "http://localhost:8080/view/dashboard";
			},
			error: function(err) {
				console.error("Login error: my login faileed", err);
				alert(err.responseJSON.message)
			}
		});
	});
});