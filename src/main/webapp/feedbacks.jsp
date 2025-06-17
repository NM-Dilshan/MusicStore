<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FeedBack</title>
<style>
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

body {
    font-family: 'Arial', sans-serif;
    background-color: yellow;
    color: #333;
    line-height: 1.6;
}


     h2{
     	padding-top: 20px;
        text-align: center;
        margin-bottom: 20px;
        color: #333;

    }

    
    table{
        width: 70%;
        margin: 20px auto;
        border-collapse:collapse;
        background-color: #fff;
        box-shadow: 0 2px 5px rgba(0,0,0,0.1);
    }

    th,td{
        padding: 7px 10px;
        border: 1px solid #ddd;
        text-align: center;

    }

    th{
        background-color: #d2c622;
        color: white;
    }

    

    tr:hover{
        background-color: #f1f1f1;

    }
    button{
        padding: 6px 12px;
        margin: 2px;
        border: none;
        background-color: #2196f3;
        color: white;
        cursor: pointer;
        border-radius: 4px;
    }
    .button {
    padding: 10px 6px 12px;
    margin: 2px;
    border: none;
    background-color: #2196f3;
    color: white;
    cursor: pointer;
    border-radius: 4px;
    display: inline-block; 
}

.button-container {
    text-align: center; 
    margin-top: 20px; 
}
    .delete{
    background-color: red;
    }
    button:hover{
        background-color: #0b7dda;

    }
    form{
        display: inline;
    }
</style>
<%@include file="header.jsp" %>
</head>
<body>
<h2>User Feedback Messages</h2>
<table>
	<tr>
		<th>ID</th>
		<th>User name</th>
		<th>Message</th>
		<th>Email</th>
		<th>Action</th>
	</tr>
	
	<c:forEach var="feedbacks" items="${allfeedback}">
	<tr>
		<td>${feedbacks.feedbackID}</td>
		<td>${feedbacks.username}</td>
		<td>${feedbacks.massage}</td>
		<td>${feedbacks.email}</td>	
		<td>
			<a href ="update.jsp?feedbackID=${feedbacks.feedbackID}&username=${feedbacks.username}&massage=${feedbacks.massage}&email=${feedbacks.email}">
			<button>Update</button>
			</a><br>
			<form action="deleteServlet" method="post">
			<input type="hidden" name="feedbackID" value="${feedbacks.feedbackID}">
				<button class="delete">Delete</button>
			</form>
			</br>
			
		
		
	</tr>
	</c:forEach>
</table>
<a href="insert.jsp" class="button">Enter feedback</a>
</body>
</html>