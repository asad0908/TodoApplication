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
		alert("Title should be minimum of length 3");
		return;
	}
	
	if($("#description").val() < 3){
		alert("Description should be minimum of length 3");
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
			console.error("Error creating todo:", err);
		}
	});
});