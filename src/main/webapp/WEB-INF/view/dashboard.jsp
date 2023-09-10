
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Dashboard</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/css/dashboard.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
    <header>
        <h1>Todo Dashboard</h1>
        <div class="logoutbutton">
        	<button class="logout-btn">Logout</button>
        </div>
    </header>
    <div class="createTodo"><a class="create-btn" href="/view/todo/new">Create New Todo</a></div>
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

    <script src="/js/dashboard.js"></script>
</body>
</html>
