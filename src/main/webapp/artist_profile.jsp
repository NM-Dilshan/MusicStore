<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="Aheader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>
<link rel="stylesheet" href="css/artist_profile.css"> 
</head>
<body>
<div class="body">

	<h2>Welcome ${user.fullName}</h2>
	<img src="photo/reg5.jpg" alt="profilepic">
	
	<h2>Email<br>  ${user.email}</h2>
	<h2>Artist Number<br>  ${user.artistCode}</h2>
	<h2>Phone<br>  ${user.phone}</h2>
	
	<form action="addSong_insert.jsp" method="post" style="display:inline;">
		<input type="hidden" name="fullName" value="${user.fullName}">
		<input type="hidden" name="email" value="${user.email}">

		<button type="submit">Add a song</button>
		
		
	</form>
	
	<form action="addSong_allSongServlet" method="post" style="display:inline;">
		<input type="hidden" name="id" value="${user.id}">
		<input type="hidden" name="email" value="${user.email}">

		<button type="submit">My Songs</button>
		
		
	</form>
	
</div>

</body>
</html>
