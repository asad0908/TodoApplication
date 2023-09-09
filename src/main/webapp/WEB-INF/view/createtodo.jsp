<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Create Todo</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	<link rel="stylesheet" type="text/css" href="/css/createtodo.css">
</head>
<body>
    <header>
        <h1>Create Todo</h1>
    </header>
    <div class="container">
        <form id="createTodoForm" >
            <div class="form-group">
                <label for="title">Title:</label>
                <input type="text" id="title" name="title">
            </div>
            <div class="form-group">
                <label for="description">Description:</label>
                <input type="text" id="description" name="description">
            </div>
            <div class="form-group">
                <label for="status">Status:</label>
                <select id="status" name="status">
                    <option value="Pending">Pending</option>
                    <option value="In Progress">In Progress</option>
                    <option value="Completed">Completed</option>
                </select>
            </div>
            <div class="form-group">
                <input type="submit" class="form-button" value="Save">
            </div>
        </form>
    </div>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        // Function to get the token from local storage
        function getToken() {
            return localStorage.getItem("authToken");
        }

        // Function to handle form submission
        $("#createTodoForm").submit(function(event) {
            event.preventDefault(); // Prevent the default form submission

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
                success: function(response) {
                    console.log("Todo created successfully.");
                    window.location.href = "/view/dashboard"; // Change the URL as per your requirement
                },
                error: function(err) {
                    console.error("Error creating todo:", err);
                }
            });
        });
    </script>
