/*
if (localStorage.getItem("authToken") != null) {
	window.location.href = "http://localhost:8080/view/dashboard";
}
*/

$(document).ready(function() {
    $("#signupForm").submit(function(event) {
        event.preventDefault();

        var password = $("#password").val();
        var confirmPassword = $("#confirm-password").val();

        if (password !== confirmPassword) {
            //alert("Password and Confirm Password do not match. Please enter the same password.");
             $('.msg').text("Password and Confirm Password do not match. Please enter the same password."); 
				  $('.alert').addClass("show");
				  $('.alert').removeClass("hide");
				  $('.alert').addClass("showAlert");
				  
				  setTimeout(function(){
				    $('.alert').removeClass("show");
				    $('.alert').addClass("hide");
				  }, 5000);
				  
				  $('.close-btn').click(function(){
				    $('.alert').removeClass("show");
				    $('.alert').addClass("hide");
				  });
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
				 console.log(err)
				  $('.msg').text(err.responseText); 
				  $('.alert').addClass("show");
				  $('.alert').removeClass("hide");
				  $('.alert').addClass("showAlert");
				  
				  setTimeout(function(){
				    $('.alert').removeClass("show");
				    $('.alert').addClass("hide");
				  }, 5000);
				  
				  $('.close-btn').click(function(){
				    $('.alert').removeClass("show");
				    $('.alert').addClass("hide");
				  });
}
                error: function(err) {
    				alert(err.responseJSON.message);
			  }

            });
        }
    });
});