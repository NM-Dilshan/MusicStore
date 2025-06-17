<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Profile</title>
<link rel="stylesheet" href="css/profile_myprofile.css">

</head>
<body>
	<div class="body">
	
		<h2>Welcome ${user.firstName} ${user.lastName}</h2>
		<img class="img1"src="photo/reg5.jpg" alt="profilepic">
		
		<h2>Email<br>  ${user.email}</h2>
		<h2>Phone<br>  ${user.phone}</h2>
	
	<form action="profile_updateuser.jsp" method="post" style="display:inline;">
	
				<input type="hidden" name="id" value="${user.id}">
				<input type="hidden" name="firstName" value="${user.firstName}">
				<input type="hidden" name="lastName" value="${user.lastName}">
				<input type="hidden" name="email" value="${user.email}">
				<input type="hidden" name="password" value="${user.password}">
				<input type="hidden" name="phone" value="${user.phone}">
				
				<button type="submit">Update</button>
		
	
	</form>
	<form action="profile_deleteServlet" method="post" onsubmit="return confirmDelete();">
		<input type="hidden" name="id" value="${user.id}">
		<button type="submit">Delete</button>
		
	</form>
	

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
	</div>
</body>
</html>