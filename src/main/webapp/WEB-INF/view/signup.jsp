
<!DOCTYPE html>

<html>

<head>

    <meta charset="ISO-8859-1">

    <title>Sign Up</title>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>

<body>

 

    <form id="signupForm">

        <table>

            <tr>

                <td>Name:</td>

                <td><input type="text" name="name"></td>

            </tr>

            <tr>

                <td>Mobile:</td>

                <td><input type="tel" name="mobile"></td>

            </tr>

            <tr>

                <td>Email:</td>

                <td><input type="email" name="email"></td>

            </tr>

            <tr>

                <td>Password:</td>

                <td><input type="password" name="password"></td>

            </tr>

            <tr>

                <td>Confirm Password:</td>

                <td><input type="text" name="confirm-password"></td>

            </tr>

            <tr>

                <td></td>

                <td><input type="submit" value="Sign Up"></td>

            </tr>

        </table>

    </form>

 

    <script>

        $(document).ready(function() {

            $("#signupForm").submit(function(event) {

                event.preventDefault(); 


                var formData = {

                    name: $("input[name='name']").val(),

                    mobile: $("input[name='mobile']").val(),

                    email: $("input[name='email']").val(),

                    password: $("input[name='password']").val(),

                    confirm_password: $("input[name='confirm-password']").val()

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