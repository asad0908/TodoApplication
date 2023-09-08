<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Delete Todo</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
    <h1>Delete Todo</h1>
    
    <%-- Get the todo ID from the request parameters --%>
    <%
        String todoId = request.getParameter("id");
    %>
    
    <script>
        $(document).ready(function() {
            // Fetch the token from local storage
            var authToken = localStorage.getItem("authToken");

            if (!authToken) {
                console.error("Token not available.");
                return;
            }

            // Perform the DELETE request with the token
            $.ajax({
                type: "DELETE",
                url: "/api/todo/<%= todoId %>",
                headers: {
                    "Authorization": "Bearer " + authToken // Include the token in the request headers
                },
                success: function(response) {
                    // Refresh the page on successful deletion
                    window.location.reload();
                },
                error: function(err) {
                    // Handle error
                    console.error("Error deleting todo:", err);
                }
            });
        });
    </script>
</body>
</html>