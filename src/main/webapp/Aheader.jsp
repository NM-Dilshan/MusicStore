<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>VIBE music</title>
    <style>
    
     * {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

body {
    font-family: 'Arial', sans-serif;
    background-color: #fffbe6;
    color: #333;
    line-height: 1.6;
}
.header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    background: linear-gradient(rgba(255, 255, 153, 0.7), #f9d71c);
    padding: 10px 20px;
    height: 10vh;
}

.header img {
	padding:10px;
	margin-top:5px;
    width: 100px;
    height: auto;
}

.header h1 {
    font-size: 32px;
    flex: 1;
    text-align: center;
    color: #333;
}

.sign a {
    text-decoration: none;
    color: #333;
    font-weight: bold;
    font-size: 16px;
}

.sign a:hover {
    background-color: #fffbe6;
    padding: 6px 12px;
    border-radius: 8px;
}

/* Navigation */
.sub_header {
    background-color: #f9d71c;
    display: flex;
    justify-content: center;
    align-items: center;
    padding: 10px 0;
}

.sub_header ul {
    display: flex;
    gap: 20px;
    list-style: none;
}

.sub_header a {
    color: #333;
    text-decoration: none;
    padding: 10px 15px;
    font-weight: bold;
}

.sub_header a:hover {
    background-color: #fffbe6;
    border-radius: 8px;
}
    </style>
    
</head>
<body class="h_body">
    <div class="header">
        <div class="logo">
            <img src="images/vibe.jpg" alt="LOGO">
        </div>
        
        <h1> VIBE MUSIC</h1>
        
        <div class="sign">
            <a href="profile_login.jsp" onclick="return confirm('Are you sure do you want to sign out?')">Signout </a>
        </div>
    </div>
    <div class="sub_header">
        <ul>
            <li> <a href="Ahome.jsp" > HOME </a> </li>
            <li> <a href="feedbackall"> FEEDBACK </a> </li>
            <li> <a href="artist_profileServlet"> ARTIST</a> </li>
            <li> <a href="AFAQ.jsp"> FAQ's </a> </li>
          
        

            
            
        </ul>
    </div>
</body>
</html>