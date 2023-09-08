<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up - Todo Application</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<style>
  body {
    font-family: 'Roboto', sans-serif;
    background-color: #f5f5f5;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    margin: 0;
  }

  .card {
    background-color: #fff;
    border-radius: 4px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
    padding: 20px;
    text-align: center;
  }

  .card-content {
    padding: 20px;
  }

  .card h1 {
    color: #333;
    font-size: 28px;
    margin-bottom: 20px;
  }

  .card-form {
    text-align: left;
  }

  .form-group {
    margin-bottom: 20px;
  }

  .form-group label {
    display: block;
    color: #666;
    font-size: 14px;
  }

  .form-group input[type="text"],
  .form-group input[type="tel"],
  .form-group input[type="email"],
  .form-group input[type="password"] {
    width: 100%;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 4px;
    font-size: 16px;
  }

  .form-group input[type="text"]:focus,
  .form-group input[type="tel"]:focus,
  .form-group input[type="email"]:focus,
  .form-group input[type="password"]:focus {
    outline: none;
    border-color: #2196F3;
  }

  .form-button {
    background-color: #2196F3;
    color: #fff;
    padding: 10px 20px;
    border: none;
    border-radius: 4px;
    font-size: 18px;
    cursor: pointer;
  }

  .form-button:hover {
    background-color: #1976D2;
  }

  .logo {
    max-width: 150px;
    margin-bottom: 20px;
  }
</style>
</head>
<body>
<div class="card">
  <img src="logo.png" alt="Logo" class="logo">
  <div class="card-content">
    <h1>Sign Up for Todo Application</h1>
    <form class="card-form" id="signupForm">

      <div class="form-group">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required>
      </div>

      <div class="form-group">
        <label for="mobile">Mobile:</label>
        <input type="tel" id="mobile" name="mobile" required>
      </div>

      <div class="form-group">
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>
      </div>

      <div class="form-group">
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>
      </div>

      <div class="form-group">
        <label for="confirm-password">Confirm Password:</label>
        <input type="password" id="confirm-password" name="confirm-password" required>
      </div>

      <button type="submit" class="form-button">Sign Up</button>

    </form>
  </div>
</div>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
  $(document).ready(function() {
    $("#signupForm").submit(function(event) {
      event.preventDefault();
      var formData = {
        name: $("#name").val(),
        mobile: $("#mobile").val(),
        email: $("#email").val(),
        password: $("#password").val(),
        confirm_password: $("#confirm-password").val()
      };

      $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/user",
        data: JSON.stringify(formData),
        contentType: "application/json",
        success: function(response) {
          console.log("Data posted successfully:", response);
          window.location.href = "http://localhost:8080/view/login";
        },
        error: function(err) {
          console.error("Error posting data:", err);
        }
      });
    });
  });
</script>
</body>
</html>
