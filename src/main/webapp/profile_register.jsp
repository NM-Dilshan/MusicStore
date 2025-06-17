<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up</title>


<script>
document.addEventListener("DOMContentLoaded", function () {
    const text = "#Number 1 Music Listen Platform...";
    const typingElement = document.getElementById("typingText");
    let index = 0;

    function typeWriter() {
      if (index < text.length) {
        typingElement.innerHTML += text.charAt(index);
        index++;
        setTimeout(typeWriter, 250);
      } else {
        setTimeout(() => {
          typingElement.innerHTML = "";
          index = 0;
          typeWriter(); 
        }, 1500); 
      }
    }

    typeWriter();
  });



function validateForm() {
    var password = document.forms["regForm"]["password"].value;
    var confirmPassword = document.forms["regForm"]["confirmPassword"].value;
    var phone = document.forms["regForm"]["phone"].value;

    if (password !== confirmPassword) {
        alert("Passwords do not match!");
        return false;
    }

    // Validate phone num 10 digits
    var phoneRegex = /^\d{10}$/;
    if (!phoneRegex.test(phone)) {
        alert("Phone number must be exactly 10 digits and only numbers.");
        return false;
    }
    
 // Email validation
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(email)) {
        alert("Please enter a valid email address.");
        return false;
    }

    return true;
}
</script>
<link rel="stylesheet" href="css/profile_register.css">
</head>
<body>

	<div class="typing-text" id="typingText"></div>
	
	<form name="regForm" action="profile_insertServlet" method="post" onsubmit="return validateForm();">
		<h2>Enter Register Details</h2>
		<table>
			<tr>
				<td>First Name:</td>
				<td><input type="text" name="firstName" required></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><input type="text" name="lastName" required></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="email" name="email" required>
				        <br>
		        <span style="color:red;">
		            ${emailError != null ? emailError : ""}
		        </span>
				</td>
				
			</tr>
			<tr>
				<td>password:</td>
				<td><input type="password" name="password" required></td>
			</tr>
			<tr>
				<td>Confirm Password:</td>
				<td><input type="password" name="confirmPassword" required></td>
			</tr>
			<tr>
				<td>Phone Number:</td>
			<td><input type="text" name="phone"  required></td>			
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Sign Up"></td>
			</tr>
		</table>
		<a href="artist_login.jsp" class="link-style">Artist Log</a>  |    
		<a href="profile_login.jsp" class="link-style">Already have an account?</a>


	</form>



</body>


</html>