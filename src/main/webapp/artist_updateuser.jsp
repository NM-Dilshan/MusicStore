<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update Artist</title>
<link rel="stylesheet" href="css/artist_updateuser.css"> 
</head>
<body>
<%
	String id=request.getParameter("id");
	String fullName=request.getParameter("fullName");
	String email=request.getParameter("email");
	String password=request.getParameter("password");
	String artistCode=request.getParameter("artistCode");
	String phone=request.getParameter("phone");
%>
	<h2>Update Artist Details</h2>

	<form action="artist_updateregServlet" method="post">
		<table>
			<tr>
				<td>ID</td>
				<td><input type="text" name="id" readonly value="<%=id%>"></td>
			
			
			</tr>
			<tr>
				<td>Full Name:</td>
				<td><input type="text" name="fullName" value="<%=fullName%>" required></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="email" name="email" value="<%=email%>" required>
	
				</td>
				
			</tr>
			<tr>
				<td>password:</td>
				<td><input type="text" name="password" value="<%=password%>" required></td>
			</tr>
			<tr>
				<td>Artist Approval Code:</td>
				<td><input type="text" name="artistCode" value="<%=artistCode%>" required></td>
			</tr>
			<tr>
				<td>Phone:</td>
				<td><input type="text" name="phone" value="<%=phone%>" required></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>

</body>
</html>