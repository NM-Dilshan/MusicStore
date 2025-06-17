<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log In</title>
<link rel="stylesheet" href="css/profile_log.css"> 

</head>
<body>
<div class="typing-text" id="typingText"></div>

<form  action="profile_loginServlet" method="post">
	<h2>Login Now.</h2>
		<table>

			<tr>
				<td>Email:</td>
				<td><input type="email" name="email" required>
	
				</td>
				
			</tr>
			<tr>
				<td>password:</td>
				<td><input type="password" name="password" required></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Log in"></td>
			</tr>
		</table>
		<a href="artist_login.jsp" class="link-style">Artist Log.</a>  |    
		<a href="profile_register.jsp" class="link-style">Create New Account.</a>
	</form>

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
</script>




</body>
</html>