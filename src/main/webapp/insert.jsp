<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Feedback form</title>

<style>
	
	body{
	font-family: arial,sans-serif;
	background-color:yellow;
    margin: 0;
    padding: 0;
    display: flex;
    justify-content: CENTER;
    align-items: center;
    height: 100vh;
	}

    form{
        background-color: #fff;
        padding: 30px;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0,0,0,0.3);

    }

    label{
        padding: 10px;
        vertical-align: top;

    }
    
    input[type="text"]{
        width: 100%;
        padding:8px;
        border: 1px solid #ccc;
        border-radius: 5px;

    }
    
    textarea{
        width: 100%;
        padding:8px;
        border: 1px solid #ccc;
        border-radius: 5px;

    }
    
    input[type="email"]{
        width: 100%;
        padding:8px;
        border: 1px solid #ccc;
        border-radius: 5px;
        transition; border-color 0.3s ease;

    }
    
    input[type="email"]:focus{
    	border-color:#4caf50;
    	outline; none;
    }
    
    input[type="email"]:invalid{
    	border-color:red;
    }
    
    input[type="email"]:valid{
    	border-color:green;
    }

    input[type="submit"]{
        background-color: #4caf50;
        color:white;
        padding: 10px 15px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-weight: bold;

    }
    input[type="submit"]:hover{
        background-color: #45a049;

    }

    h2{
    	padding:10px;
        margin-bottom: 20px;
        color: #333;
        
    }
</style>

</head>
<body class="hbody">
<h2>Enter your feedback</h2><br>
	<form action="insertServlet" method="post" onsubmit="return validateForm()">
    <label for="username">Username:</label><br>
    <input type="text" id="username" name="username" required><br><br>

    <label for="massage">Message:</label><br>
    <textarea id="massage" name="massage" required></textarea><br><br>

    <label for="email">Email:</label><br>
    <input type="email" id="email" name="email" placeholder="example@domain.com" required><br><br>

    <input type="submit" value="Submit">
</form>
	
<script>
function validateForm() {
    var username = document.getElementById("username").value.trim();
    var email = document.getElementById("email").value.trim();
    
    
    var usernameRegex = /^[A-Za-z\s]{3,}$/;
    if (!usernameRegex.test(username)) {
        alert("Invalid username! Use at least 3 letters. No numbers or special characters.");
        return false;
    }
	
    var email = document.getElementById("email").value;
    var emailRegex = /^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$/;

    if (!emailRegex.test(email)) {
        alert("Invalid email format!");
        return false;
    }

    return true;
}
</script>

</body>
</html>