$(document).ready(function() {
	$("#editTodoForm").submit(function(event) {
		event.preventDefault();

		var authToken = localStorage.getItem("authToken");
		console.log(authToken);

		if (!authToken) {
			console.error("Token not available.");
			return;
		}

		var formData = {
			title: $("#title").val(),
			description: $("#description").val(),
			status: $("#status").val()
		};

		var str = window.location.href;
		var id = str.substring(str.lastIndexOf("=") + 1);
		console.log(id);

		$.ajax({
			type: "PUT",
			url: "/api/todo/" + id,
			data: JSON.stringify(formData),
			contentType: "application/json",
			headers: {
				"Authorization": "Bearer " + authToken
			},
			success: function(response) {
				window.location.href = "http://localhost:8080/view/dashboard";
			},
			error: function(err) {
				console.error("Error updating todo:", err);
			}
		});
	});
});