<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Todo</title>
</head>
<body>
	<form action="/api/todo" method="post">
		<table>
			<tr>
				<td>Title:</td>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<td>Description:</td>
				<td><input type="text" name="description"></td>
			</tr>
			<tr>
				<td>Status:</td>
				<td><select name="status">
						<option value="Pending">Pending</option>
						<option value="In Progress">In Progress</option>
						<option value="Completed">Completed</option>
				</select></td>
			</tr>
			
			<tr>
				<td></td>
				<td><input type="submit" value="Save"></td>
			</tr>
		</table>
	</form>

</body>
</html>