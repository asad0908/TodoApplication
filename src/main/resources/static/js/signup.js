$(document).ready(function() {
    $("#signupForm").submit(function(event) {
        event.preventDefault();

        var password = $("#password").val();
        var confirmPassword = $("#confirm-password").val();

        if (password !== confirmPassword) {
            alert("Password and Confirm Password do not match. Please enter the same password.");
        } else {
            var formData = {
                name: $("#name").val(),
                mobile: $("#mobile").val(),
                email: $("#email").val(),
                password: password, 
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
    				alert(err.responseText)
			  }
            });
        }
    });
});