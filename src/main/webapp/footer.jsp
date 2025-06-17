<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
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

.footer {
    background-color: #f9d71c;
    padding: 30px;
    text-align: center;
    color: #333;
}

.footer .line1 {
    display: flex;
    justify-content: space-around;
    flex-wrap: wrap;
    margin-bottom: 10px;
}

.footer .power a,
.footer .contacts a {
    text-decoration: none;
    color: #333;
    font-weight: bold;
    margin: 0 10px;
}

.footer .power a:hover,
.footer .contacts a:hover {
    color: black;
}

.footer .bar {
    height: 2px;
    background-color: #000;
    margin: 20px 0;
}

.footer .power_by h3 {
    font-size: 14px;
}
    </style>
    
</head>
<body>
<div class="footer">
        <div class="line1">
            <div class="power">
                
                <a href="home.php"> Home</a> 
                <a href="events.php"> Events</a> 
                <a href="display_experience.php"> Experince</a>
                <a href="about.php"> About us</a>
                <a href="login.php"> Sign out</a>
                
            </div>

            <div class="contacts"> 
                
                <a href="contactus.php">Contact Us</a>
                
                
            </div>
        </div>

        <div class="line2">
            <div class="bar"></div>
        </div>
        
        <div class="power_by">
            <h3>
                Copyright (c) programming team <br>
                All rights reserved.
            </h3>
        </div>
    </div>

</body>
</html>