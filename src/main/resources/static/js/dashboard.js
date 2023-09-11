if (localStorage.getItem("authToken") == null) {
	window.location.href = "http://localhost:8080/view/login";
}

function getToken() {
	var authToken = localStorage.getItem("authToken");
	console.log(authToken);
	return authToken;
}

function getDataWithToken() {
	var authToken = getToken();

	if (!authToken) {
		console.error("Token not available.");
		return;
	}

	$.ajax({
		type: "GET",
		url: "http://localhost:8080/api/todo",
		headers: {
			"Authorization": "Bearer " + authToken
		},
		success: function(data) {
			console.log("Data received:", data);
			renderData(data);
		},
		error: function(err) {
			console.error("Error fetching data:", err);
		}
	});
}

function renderData(data) {
	var table = document.querySelector("table");

	for (var i = 0; i < data.length; i++) {
		var todo = data[i];

		var row = table.insertRow(-1);
		var cell1 = row.insertCell(0); // ID
		var cell2 = row.insertCell(1); // Title
		var cell3 = row.insertCell(2); // Description
		var cell4 = row.insertCell(3); // Status
		var cell5 = row.insertCell(4); // Edit Link
		var cell6 = row.insertCell(5); // Delete Link

		cell1.innerHTML = i+1;
		cell2.innerHTML = todo.title;
		cell3.innerHTML = todo.description;
		cell4.innerHTML = todo.status;
		cell5.innerHTML = "<a class=\"edit-btn\" href='/view/todo/edit?id=" + todo.id + "'>Edit</a>";

		// Use the todo.id directly within the JavaScript code
		cell6.innerHTML = "<button class=\"delete-btn\" data-id=\"" + todo.id + "\">Delete</button>";
	}
}





$(document).ready(function() {
    getDataWithToken();
    
    $(document).on("click", ".logout-btn", function(){
		localStorage.removeItem("authToken");
		window.location.href = "http://localhost:8080/view/login";
	})

    // Use event delegation for the click event
    $(document).on("click", ".delete-btn", function() {
        var todoId = $(this).data("id");
        var authToken = localStorage.getItem("authToken");

        if (!authToken) {
            console.error("Token not available.");
            return;
        }

        $.ajax({
            type: "DELETE",
            url: "/api/todo/" + todoId,
            headers: {
                "Authorization": "Bearer " + authToken
            },
            success: function() {
				window.location.href = "http://localhost:8080/view/dashboard";
            },
            error: function(err) {
                console.error("Error deleting todo:", err);
            }
        });
    });
});

