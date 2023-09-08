<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Edit Todo</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
    <form id="editTodoForm">
        <input type="hidden" id="id" name="id" value="${id}">
        <table>
            <tr>
                <td>Title:</td>
                <td><input type="text" id="title" name="title"></td>
            </tr>
            <tr>
                <td>Description:</td>
                <td><input type="text" id="description" name="description"></td>
            </tr>
            <tr>
                <td>Status:</td>
                <td>
                    <select id="status" name="status">
                        <option value="Pending">Pending</option>
                        <option value="In Progress">In Progress</option>
                        <option value="Completed">Completed</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form>

    <script>
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
                    //id: $("#id").val(),
                    title: $("#title").val(),
                    description: $("#description").val(),
                    status: $("#status").val()
                };
                str=window.location.href;
                var id = str.substring(str.lastIndexOf("=")+1);
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
    </script>
</body>
</html>