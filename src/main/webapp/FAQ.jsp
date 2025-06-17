<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        body {
            font-family: Arial, sans-serif;
            background: #f5f5f5;
            margin: 0;
            padding: 0;
        }


        nav a {
            margin: 0 15px;
            color: white;
            text-decoration: none;
        }

        .container {
            padding: 40px;
            max-width: 1000px;
            margin:center;
            margin-top: 10px;
            background-color: white;
            box-shadow: 0px 0px 10px rgba(0,0,0,0.1);
        }

        h2 {
            color: #333;
        }

        form input, form textarea {
            width: 100%;
            padding: 10px;
            margin-top: 8px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        form input[type="submit"] {
            background-color: #333;
            color: white;
            border: none;
            cursor: pointer;
            padding: 10px 20px;
        }

        form input[type="submit"]:hover {
            background-color: #555;
        }
    </style>
</head>
<body>



<div class="container">
    <section id="help">
        <h2>Help</h2>
        <p>If you’re facing issues with uploading songs, payments, or account access, please read our FAQ or contact us below.</p>
    </section>

    <section id="about">
        <h2>About Us</h2>
        <p>Online Music Store is a platform for artists and listeners. Artists can upload and sell their music, and fans can stream or purchase tracks easily. We support MP3, WAV, and other formats.</p>
    </section>

    <section id="query">
        <h2>Contact / Query</h2>
        <form action="SubmitQueryServlet" method="post">
            <label for="name">Your Name:</label>
            <input type="text" id="name" name="name" required>

            <label for="email">Your Email:</label>
            <input type="email" id="email" name="email" required>

            <label for="message">Your Message:</label>
            <textarea id="message" name="message" rows="5" required></textarea>

            <input type="submit" value="Send Message">
        </form>
    </section>
</div>



</body>
</html>