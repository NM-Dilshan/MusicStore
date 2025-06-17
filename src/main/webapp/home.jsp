<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="header.jsp" %>

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

	.main{
	    display: flex;
	    align-items: center;
	    justify-content: center;
	    height: 60%;
	    background-color:rgb(229, 225, 234);
	}
	
	.main .slidebody{
	    position: relative;
	    display: block;
	    padding: 25px;
	    left: 40px;
	    overflow: hidden;
	    width: 40%;
	    height: 40%;
	    
	}
	.main .slidebody .slideimg{
	    display: grid;
	    grid-template-columns: repeat(3,100%);
	    animation: slideanim 20s ease-in-out infinite alternate;
	}
	
	@keyframes slideanim {
	    0%{
	        transform: translateX(0%);
	    }
	    5%{
	        transform: translateX(0%);
	    }
	    25%{
	        transform: translateX(-100%);
	    }
	    30%{
	        transform: translateX(-100%);
	    }
	    50%{
	        transform: translateX(-200%);
	    }
	    55%{
	        transform: translateX(-200%);
	    }
	    75%{
	        transform: translateX(-100%);
	    }
	    80%{
	        transform: translateX(-100%);
	    }
	    100%{
	        transform: translateX(0%);
	    }
	}
	

	
	.main .slidenav a{
	    background-color:rgb(5, 6, 5);
	    width: 15px;
	    height: 15px;
	    margin-left: 8px;
	    border-radius: 100%;
	}
	
	.main .slidenav{
	    position: relative;
	    display: flex;
	    right: 25%;
	    bottom: -150px;
	}
	
	.main .slidebody .slideimg img {
    width: 100%;
    height: 300px;
    object-fit: cover;
}
	h5 {
	    font-size: 20px;
	    font-weight: bold;
	    text-align: center;
	    color: #333; 
	    margin-top: 20px;
	    font-family: Arial, sans-serif;
	}
	    </style>

</head>

<body>
  
  <h5>online music store</h5>
        <div class="main">
            <div class="slidebody">
                <div class="slideimg">
                    <img id="img1" src="images/pic.jpeg" alt="show">
                    <img id="img2" src="images/pic1.jpeg" alt="show1">
                    <img id="img3" src="images/pic2.jpeg" alt="show2">
                </div>
            </div>
            <div class="slidenav">
                <a href="#img1"></a>
                <a href="#img2"></a>
                <a href="#img3"></a>
            </div>
        </div>
    


    
</body>
</html>
<%@ include file= "footer.jsp" %>

