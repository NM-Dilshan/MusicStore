<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register to Artist</title>
</head>
<link rel="stylesheet" href="css/addSong_insert.css"> 
<script>
    function validateForm() {
        const songName = document.forms["musicForm"]["songName"].value.trim();
        const description = document.forms["musicForm"]["description"].value.trim();
        const musicFile = document.forms["musicForm"]["musicFile"].value;

        // Validate Song Title
        if (songName === "") {
            alert("Song Title is required.");
            return false;
        }

        // Validate Description
        if (description === "") {
            alert("Description is required.");
            return false;
        }
        if (description.length < 10 || description.length > 150) {
            alert("Description must be between 10 and 150 characters short.");
            return false;
        } 

        // Validate music file selected
        if (musicFile === "") {
            alert("Please select a music file.");
            return false;
        }

        return true;
    }
</script>
<body>

<%
	String fullName=request.getParameter("fullName");
	String email=request.getParameter("email");

%>
	<form name="musicForm" action="addSong_insertServlet" method="post" enctype="multipart/form-data" onsubmit="return validateForm();">
	<h2>Enter Music Details</h2>
		<table>
			<tr>
				<td>Song Title:</td>
				<td><input type="text" name="songName"  ></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="email" name="artistEmail" readonly value="<%=email%>" >
				        
	
				</td>
				
			</tr>
			<tr>
				<td>Artist Name:</td>
				<td><input type="text" name="artistName" readonly value="<%=fullName%>" ></td>
			</tr>
			
			<tr>
				<td>Select Music File:</td>
				<td><input type="file" name="musicFile" accept="audio/*" required></td>
			</tr>
			
			<tr>
				<td>Description:</td>
				<td><input type="text" name="description" ></td>
			</tr>
			

			
			<tr>
				<td colspan="2"><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>
	
	
		



</body>
</html>