<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User profile Update</title>
<link rel="stylesheet" href="css/profile_update.css">
<script>
	function validateForm() {    
	        var password = document.forms["updateform"]["password"].value;
	        var confirmPassword = document.forms["updateform"]["confirmPassword"].value;
	        var phone = document.forms["updateform"]["phone"].value;

	        if (password !== confirmPassword) {
	            alert("Passwords do not match!");
	            return false;
	        }

	        // Validate phone: must be 10 digits
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
</head>
<body>
<%

	String id=request.getParameter("id");
	String firstName=request.getParameter("firstName");
	String lastName=request.getParameter("lastName");
	String email=request.getParameter("email");
	String password=request.getParameter("password");
	String phone=request.getParameter("phone");
	

%>

 
	<form name="updateform" action="profile_updateServlet" method="post" onsubmit="return validateForm()">
	<h3>Profile Update.</h3>
		<table>
		<tr>
				<td>ID:</td>
				<td><input type="text" name="id" value="<%=id%>" readonly></td>
			</tr>

			<tr>
				<td>First Name:</td>
				<td><input type="text" name="firstName" value="<%=firstName%>" required></td>
			</tr>
		<tr>
				<td>Last Name:</td>
				<td><input type="text" name="lastName" value="<%=lastName%>" required></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="email" name="email" value="<%=email%>" required>
	
	
				</td>
				
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" value="<%=password%>" required></td>
			</tr>
			<tr>
				<td>Confirm Password:</td>
				<td><input type="password" value="<%=password%>" name="confirmPassword" required></td>
			</tr>
			<tr>
				<td>Phone:</td>
				<td><input type="text" name="phone" value="<%=phone%>" required></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Update"></td>
			</tr>
		</table>
	</form>
</body>
</html>