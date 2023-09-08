$(document).ready(function() {
	$("#signupForm").submit(function(event) {
		event.preventDefault();
		var formData = {
			name: $("#name").val(),
			mobile: $("#mobile").val(),
			email: $("#email").val(),
			password: $("#password").val(),
			confirm_password: $("#confirm-password").val()
		};

		$.ajax({
			type: "POST",
			url: "http://localhost:8080/api/user",
			data: JSON.stringify(formData),
			contentType: "application/json",
			success: function(response) {
				console.log("Data posted successfully:", response);
				window.location.href = "http://localhost:8080/view/login";
			},
			error: function(err) {
				console.error("Error posting data:", err);
			}
		});
	});
});