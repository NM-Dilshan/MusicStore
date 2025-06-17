<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Artist Details</title>
<link rel="stylesheet" href="css/artist_userDetail.css"> 
</head>
<body>
<h2>Artist List</h2>
<input type="text" id="searchInput" placeholder="serch...">
<br>

<table>
	<tr>
		<th>ID</th>
		<th>Full Name</th>
		<th>Email</th>
		<th>Password</th>
		<th>Artist Approval Code:</th>
		<th>phone</th>
		<th>Action</th>
	</tr>
	<c:forEach var="userregs" items="${allusers}">
	<tr>
	
		<td>${userregs.id}</td>
		<td>${userregs.fullName}</td>
		<td>${userregs.email}</td>
		<td>${userregs.password}</td>
		<td>${userregs.artistCode}</td>
		<td>${userregs.phone}</td>
		
		<td>
		
			<form action="artist_updateuser.jsp" method="post" style="display:inline;">
				<input type="hidden" name="id" value="${userregs.id}">
				<input type="hidden" name="fullName" value="${userregs.fullName}">
				<input type="hidden" name="email" value="${userregs.email}">
				<input type="hidden" name="password" value="${userregs.password}">
				<input type="hidden" name="artistCode" value="${userregs.artistCode}">
				<input type="hidden" name="phone" value="${userregs.phone}">
				<button type="submit" class="update">Update</button>
			</form>
		
		
			<form action="artist_regdeleteServlet" method="post" onsubmit="return confirmDelete();">
			<input type="hidden" name="id" value="${userregs.id}">
			<button type="submit" class="delete">Delete</button>
			</form>
		</td>
		
	</tr>
	
	
	
	</c:forEach>
		
</table>
	<a href="admin.jsp">
		<button class="none">Admin Dashboard</button>
	</a>

	<a href="artist_register.jsp">
		<button class="none">Add New Artist</button>
	</a>

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