<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register to Artist</title>
<link rel="stylesheet" href="css/artist_register.css"> 
</head>
<body>

<form action="artist_insertServlet" method="post" onsubmit="return validateForm()">
    <h2>Enter Register Details</h2>
    <table>
        <tr>
            <td>Full Name:</td>
            <td><input type="text" name="fullName" required></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td>
                <input type="email" name="email" id="email" required pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$">
                <br>
                <span style="color:red;">
                    ${emailError != null ? emailError : ""}
                </span>
            </td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="password" required></td>
        </tr>
        <tr>
            <td>Artist Approval Code:</td>
            <td><input type="text" name="artistCode" required></td>
        </tr>
        <tr>
            <td>Phone:</td>
            <td>
                <input type="text" name="phone" id="phone" required pattern="^\d{10}$" title="Enter a 10-digit phone number">
            </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Submit"></td>
        </tr>
    </table>
</form>

<!-- Typing Effect -->
<div id="typingText" style="margin-top:20px; font-weight:bold;"></div>

<script>


  
  function validateForm() {
    const email = document.getElementById("email").value;
    const phone = document.getElementById("phone").value;

    const emailRegex = /^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$/;
    const phoneRegex = /^\d{10}$/;

    if (!emailRegex.test(email)) {
      alert("Please enter a valid email address.");
      return false;
    }

    if (!phoneRegex.test(phone)) {
      alert("Please enter a valid 10-digit phone number.");
      return false;
    }

    return true;
  }
</script>

</body>
</html>
