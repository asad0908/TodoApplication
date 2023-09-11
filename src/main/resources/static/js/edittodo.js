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
					$('.msg').text("Description should be minimum of length 3");
					$('.alert').addClass("show");
					$('.alert').removeClass("hide");
					$('.alert').addClass("showAlert");
		
					setTimeout(function() {
						$('.alert').removeClass("show");
						$('.alert').addClass("hide");
					}, 5000);
		
					$('.close-btn').click(function() {
						$('.alert').removeClass("show");
						$('.alert').addClass("hide");
					});
					return;
				}

				if ($("#description").val() < 3) {
					$('.msg').text("Description should be minimum of length 3");
					$('.alert').addClass("show");
					$('.alert').removeClass("hide");
					$('.alert').addClass("showAlert");
		
					setTimeout(function() {
						$('.alert').removeClass("show");
						$('.alert').addClass("hide");
					}, 5000);
		
					$('.close-btn').click(function() {
						$('.alert').removeClass("show");
						$('.alert').addClass("hide");
					});
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
						$('.msg').text(err.responseJSON.message);
						$('.alert').addClass("show");
						$('.alert').removeClass("hide");
						$('.alert').addClass("showAlert");
			
						setTimeout(function() {
							$('.alert').removeClass("show");
							$('.alert').addClass("hide");
						}, 5000);
			
						$('.close-btn').click(function() {
							$('.alert').removeClass("show");
							$('.alert').addClass("hide");
						});
					}
				});
			});
		},
		error: function(err) {
			//if (err.status == 401) {
			localStorage.removeItem("authToken");
			window.location.href = "http://localhost:8080/view/login";
			//}
		}
	});
});