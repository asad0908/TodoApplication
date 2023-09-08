<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Todo Application</title>
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
    background-image: url('your-background-image.jpg');
    background-size: cover;
    background-repeat: no-repeat;
    border-radius: 4px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
    padding: 20px;
    text-align: center;
  }

  .card a {
    text-decoration: none;
    color: #2196F3;
    font-size: 18px;
    display: inline-block;
    margin: 10px;
    padding: 10px 20px;
    border-radius: 4px;
    border: 1px solid #2196F3;
    transition: background-color 0.3s ease, color 0.3s ease;
    position: relative;
    overflow: hidden;
  }

  .card a::after {
    content: '';
    position: absolute;
    top: 50%;
    left: 50%;
    width: 0;
    height: 0;
    background-color: rgba(33, 150, 243, 0.3);
    border-radius: 50%;
    transform: translate(-50%, -50%);
    transition: width 0.3s ease, height 0.3s ease;
  }

  .card a:hover::after {
    width: 120%;
    height: 120%;
  }

  .card a:hover {
    background-color: #1976D2;
    color: #fff;
  }

  h1 {
    color: #333;
    font-size: 28px;
    margin-bottom: 20px;
  }

  .logo {
    max-width: 150px;
    margin-bottom: 20px;
  }
</style>
</head>
<body>
<div class="card">
  <img src="\logo.png" alt="Logo" class="logo">
  <div class="card-content">
    <h1>Welcome to Todo Application</h1>
    <a href="/view/login"><i class="material-icons">account_circle</i> Login</a>
    <a href="/view/signup"><i class="material-icons">person_add</i> Sign Up</a>
  </div>
</div>
</body>
</html>
