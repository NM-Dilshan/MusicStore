<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login</title>
<link rel="stylesheet" href="css/artist_login.css"> 
</head>
<body>
<div class="typing-text" id="typingText"></div>

<form  action="adminServlet" method="post">
	<h2>Admin Login Now.</h2>
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