<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Dashboard</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <style>
        body {
            font-family: 'Roboto', sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
        }

        header {
            background-color: #2196F3;
            color: #fff;
            text-align: center;
            padding: 20px 0;
        }

        h1 {
            font-size: 36px;
        }

        .container {
            max-width: 1200px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 4px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        table, th, td {
            border: 1px solid #ddd;
        }

        th, td {
            padding: 15px;
            text-align: left;
        }

        th {
            background-color: #2196F3;
            color: #fff;
        }

        .delete-btn {
            background-color: #f44336;
            color: #fff;
            border: none;
            padding: 8px 16px;
            cursor: pointer;
            border-radius: 4px;
        }

        .delete-btn:hover {
            background-color: #d32f2f;
        }
    </style>
</head>
<body>
    <header>
        <h1>Todo Dashboard</h1>
    </header>
    <div class="container">
        <table>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Description</th>
                <th>Status</th>
                <th colspan="2">Action</th>
            </tr>
        </table>
    </div>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
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

                cell1.innerHTML = todo.id;
                cell2.innerHTML = todo.title;
                cell3.innerHTML = todo.description;
                cell4.innerHTML = todo.status;
                cell5.innerHTML = "<a href='/view/todo/edit?id=" + todo.id + "'>Edit</a>";

                // Use the todo.id directly within the JavaScript code
                cell6.innerHTML = "<button class=\"delete-btn\" data-id=\"" + todo.id + "\">Delete</button>";
            }
        }

        getDataWithToken();
    </script>

    <script>
        $(document).ready(function() {
            $(".delete-btn").click(function() {
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
                    success: function(response) {
                        console.log("Todo deleted successfully.");
                    },
                    error: function(err) {
                        console.error("Error deleting todo:", err);
                    }
                });
            });
        });
    </script>
</body>
</html>
