<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="Aheader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Songs</title>
<link rel="stylesheet" href="css/addSong_Details.css"> 
</head>
<body>
<h2>Song List</h2>
<input type="text" id="searchInput" placeholder="serch...">
<br>

<table>
	<tr>
		<th>Song ID</th>
		<th>Artist Full Name</th>
		<th>Email</th>
		<th>Description</th>
		<th>Upload Date</th>
		<th>Song Name</th>
		<th>Song</th>
		<th>Action</th>
	</tr>
	<c:forEach var="music" items="${allusers}">
	<tr>
	
		<td>${music.id}</td>
		<td>${music.artistName}</td>
		<td>${music.artistEmail}</td>
		<td>${music.description}</td>
		<td>${music.date}</td>
		<td>${music.songName}</td>
		
		
		<td>
			<audio controls>
			  <source src="${music.filePath}" type="audio/mpeg">
			  
			</audio>
		
		</td>
		
		<td>
			<form action="addSong_Update.jsp" method="post" style="display:inline;">
				<input type="hidden" name="id" value="${music.id}">
				<input type="hidden" name="artistName" value="${music.artistName}">
				<input type="hidden" name="artistEmail" value="${music.artistEmail}">
				<input type="hidden" name="date" value="${music.date}">
				<input type="hidden" name="songName" value="${music.songName}">
				<input type="hidden" name="description" value="${music.description}">
				<button type="submit" class="update">Update</button>
			</form>

			<form action="addSong_deleteServlet?" method="post" onsubmit="return confirmDelete();">
			<input type="hidden" name="id" value="${music.id}">
			<button type="submit" class="delete">Delete</button>
			</form>
		</td>
		
	</tr>
	
	
	
	</c:forEach>
		
</table>


	<script>
	function filterTable() {
	    var input = document.getElementById("searchInput");
	    var filter = input.value.toUpperCase();
	    var table = document.querySelector("table");
	    var tr = table.getElementsByTagName("tr");

	    for (var i = 1; i < tr.length; i++) {
	        var td = tr[i].getElementsByTagName("td");
	        var showRow = false;

	        for (var j = 0; j < td.length; j++) {
	            var txtValue = td[j].textContent || td[j].innerText;
	            if (txtValue.toUpperCase().indexOf(filter) > -1) {
	                showRow = true;
	                break;
	            }
	        }

	        tr[i].style.display = showRow ? "" : "none";
	    }
	}

	document.addEventListener("DOMContentLoaded", function() {
	    document.getElementById("searchInput").addEventListener("input", filterTable);
	});

	
	
	function confirmDelete() {
	    return confirm("Are you sure you want to delete this user?");
	}
	</script>

</body>
</html>