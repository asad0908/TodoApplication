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
            $("#title").val(response.title);
            $("#description").val(response.description);
            $("#status").val(response.status);

            $("#editTodoForm").submit(function(event) {
                event.preventDefault();

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
                    success: function(response) {
                        window.location.href = "http://localhost:8080/view/dashboard";
                    },
                    error: function(err) {
                        console.error("Error updating todo:", err);
                    }
                });
            });
        },
        error: function(err) {
            console.error("Error fetching todo data:", err);
        }
    });
});