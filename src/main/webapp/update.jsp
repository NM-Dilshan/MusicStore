<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	
	body{
	font-family: arial,sans-serif;
	background-color:yellow;
    margin: 0;
    padding: 0;
    display: flex;
    justify-content: CENTER;
    align-items: center;
    height: 100vh;
	}

    form{
        background-color: #fff;
        padding: 30px;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0,0,0,0.1);

    }
    table{
        width: 100%;
    }

    td{
        padding: 10px;
        vertical-align: top;

    }
    
    input[type="text"]{
        width: 100%;
        padding:8px;
        border: 1px solid #ccc;
        border-radius: 5px;

    }
    
    input[type="email"]{
        width: 100%;
        padding:8px;
        border: 1px solid #ccc;
        border-radius: 5px;
        transition; border-color 0.3s ease;

    }
    
    input[type="email"]:focus{
    	border-color:#4caf50;
    	outline; none;
    }
    
    input[type="email"]:invalid{
    	border-color:red;
    }
    
    input[type="email"]:valid{
    	border-color:green;
    }

    input[type="submit"]{
        background-color: #4caf50;
        color:white;
        padding: 10px 15px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-weight: bold;

    }
    input[type="submit"]:hover{
        background-color: #45a049;

    }

    h2{
    	font-size: 32px;
        text-align: top;
        margin-bottom: 20px;
        padding:10px;
        color: #333;
        
    }
</style>
</head>
<body>
	<%
		String feedbackID= request.getParameter("feedbackID");
		String username= request.getParameter("username");
		String massage= request.getParameter("massage");
		String email= request.getParameter("email");
	%>
	<h2>feedback Update</h2>
	
	<form action="updateServlet" method="post">
		<table>
			<tr>
				<td>FeedbackID:</td>
				<td><input type="text" name="feedbackID" value="<%=feedbackID%>" readonly></td>
			</tr>
			<tr>
				<td>username:</td>
				<td><input type="text" name="username" value="<%=username%>" required></td>
			</tr>
			<tr>
				<td>Massage:</td>
				<td><input type="text" name="massage" value="<%=massage%>" required></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="text" name="email" value="<%=email%>" required></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value ="Update" name="submit" required></td>
			</tr>
			
		</table>
	</form>
</body>
</html>