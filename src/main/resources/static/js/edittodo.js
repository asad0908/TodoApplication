if (localStorage.getItem("authToken") == null) {
	window.location.href = "http://localhost:8080/view/login";
}

$(document).ready(function() {
	var str = window.location.href;
	var id = str.substring(str.lastIndexOf("=") + 1);
	console.log(id);

	var authToken = localStorage.getItem("authToken");
	console.log(authToken);

	if (!authToken) {
		console.error("Token not available.");
		return;
	}

	$.ajax({
		type: "GET",
		url: "/api/todo/" + id,
		headers: {
			"Authorization": "Bearer " + authToken
		},
		success: function(response) {
			console.log(response)
			$("#title").val(response.title);
			$("#description").val(response.description);
			$("#status").val(response.status);

			$("#editTodoForm").submit(function(event) {
				event.preventDefault();

				if ($("#title").val().length < 3) {
					alert("Title should be minimum of length 3");
					return;
				}

				if ($("#description").val() < 3) {
					alert("Description should be minimum of length 3");
					return;
				}

				var formData = {
					title: $("#title").val(),
					description: $("#description").val(),
					status: $("#status").val()
				};

				$.ajax({
					type: "PUT",
					url: "/api/todo/" + id,
					data: JSON.stringify(formData),
					contentType: "application/json",
					headers: {
						"Authorization": "Bearer " + authToken
					},
					success: function() {
						window.location.href = "http://localhost:8080/view/dashboard";
					},
					error: function(err) {
						console.error("Error fetching todo data:", err);
						alert(err.responseJSON.message + "Login Again")
						//if (err.status == 401) {
						localStorage.removeItem("authToken");
						window.location.href = "http://localhost:8080/view/login";
						//}
						//console.error("Error updating todo:", err);
					}
				});
			});
		},
		error: function(err) {
			console.error("Error fetching todo data:", err);
			alert(err.responseJSON.message + "Login Again")
			//if (err.status == 401) {
			localStorage.removeItem("authToken");
			window.location.href = "http://localhost:8080/view/login";
			//}
		}
	});
});