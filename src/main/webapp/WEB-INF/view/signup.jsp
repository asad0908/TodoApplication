<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up - Todo Application</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Poppins&display=swap"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/css/signup.css">
</head>
<body>
	<div class="loginpage__container">
		<div class="loginpage__card">
			<div class="loginpage__card--heading">
				<h1>Register</h1>
			</div>
			<div class="loginpage__card--body">
				<form id="signupForm" method="POST">
					<div class="loginpage__card--input">
						<div class="loginpage__card--input-icon">
							<img
								src="https://cdn-icons-png.flaticon.com/128/266/266134.png?ga=GA1.1.839564024.1694157272" />
						</div>
						<input name="name" id="name" required type="text"
							placeholder="Full Name" />
					</div>
					<div class="loginpage__card--input">
						<div class="loginpage__card--input-icon">
							<img
								src="https://cdn-icons-png.flaticon.com/128/542/542689.png?ga=GA1.1.839564024.1694157272" />
						</div>
						<input name="email" id="email" required type="email"
							placeholder="Email Address" />
					</div>
					<div class="loginpage__card--input">
						<div class="loginpage__card--input-icon">
							<img
								src="https://cdn-icons-png.flaticon.com/128/8300/8300080.png?ga=GA1.1.839564024.1694157272" />
						</div>
						<input name="mobile" id="mobile" required type="number"
							placeholder="Mobile Number" />
					</div>
					<div class="loginpage__card--input">
						<div class="loginpage__card--input-icon">
							<img
								src="https://cdn-icons-png.flaticon.com/128/2889/2889676.png?ga=GA1.1.839564024.1694157272" />
						</div>
						<input name="password" id="password" required type="password"
							placeholder="Password" />
					</div>
					<div class="loginpage__card--input">
						<div class="loginpage__card--input-icon">
							<img
								src="https://cdn-icons-png.flaticon.com/128/2889/2889676.png?ga=GA1.1.839564024.1694157272" />
						</div>
						<input name="confirm-password" id="confirm-password" required type="password"
							placeholder="Confirm Password" />
					</div>
					<div class="loginpage__card--loginbutton">
						<button type="submit">Register</button>
					</div>
				</form>
				<div class="loginpage__card--signup">
					<p>
						Already a member? <span><a href="/view/login">Login
								Now</a></span>
					</p>
				</div>
			</div>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="/js/signup.js"></script>
</body>
</html>


<!-- 
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

 -->
