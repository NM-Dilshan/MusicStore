<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/artist_updateuser.css"> 

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
</head>
<body>

<%



	String id=request.getParameter("id");
	String songName=request.getParameter("songName");
	String artistName=request.getParameter("artistName");
	String artistEmail=request.getParameter("artistEmail");
	String filePath=request.getParameter("filePath");
	String date=request.getParameter("date");
	String description=request.getParameter("description");


%>
	<form name="musicForm" action="addSong_UpdateServlet" method="post" enctype="multipart/form-data" onsubmit="return validateForm();">
	<h2>Update Music Details</h2>
		<table>
		
			<tr>
				<td>Song Id:</td>
				<td><input type="text" name="id" value="<%=id%>" readonly  required></td>
			</tr>
			<tr>
				<td>Song Title:</td>
				<td><input type="text" name="songName"   value="<%=songName%>" ></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="email" name="artistEmail" readonly value="<%=artistEmail%>" >
				        
	
				</td>
				
			</tr>
			<tr>
				<td>Artist Name:</td>
				<td><input type="text" name="artistName" readonly value="<%=artistName%>" ></td>
			</tr>
			
						
			<tr>
				<td>Select Music File:</td>
				<td><input type="file" name="musicFile" accept="audio/*"  required></td>
			</tr>
			
			<tr>
				<td>Upload Date:</td>
				<td><input type="text" name="date" readonly value="<%=date%>" ></td>
			</tr>


			
			<tr>
				<td>Description:</td>
				<td><input type="text" name="description" value="<%=description%>" ></td>
			</tr>
			

			
			<tr>
				<td colspan="2"><input type="submit" value="Update"></td>
			</tr>
		</table>
	</form>

</body>
</html>