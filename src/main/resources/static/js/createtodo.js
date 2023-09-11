if (localStorage.getItem("authToken") == null) {
	window.location.href = "http://localhost:8080/view/login";
}

// Function to get the token from local storage
function getToken() {
	return localStorage.getItem("authToken");
}

// Function to handle form submission
$("#createTodoForm").submit(function(event) {
	event.preventDefault(); // Prevent the default form submission
	if($("#title").val().length < 3){
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
	
	if($("#description").val() < 3){
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

	var authToken = getToken();

	if (!authToken) {
		console.error("Token not available.");
		return;
	}

	var formData = {
		title: $("#title").val(),
		description: $("#description").val(),
		status: $("#status").val()
	};

	$.ajax({
		type: "POST",
		url: "http://localhost:8080/api/todo",
		data: JSON.stringify(formData), // Convert form data to JSON
		contentType: "application/json",
		headers: {
			"Authorization": "Bearer " + authToken
		},
		success: function() {
			console.log("Todo created successfully.");
			window.location.href = "/view/dashboard"; // Change the URL as per your requirement
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