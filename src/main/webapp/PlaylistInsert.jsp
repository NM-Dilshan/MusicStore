<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PlayList</title>
<link rel="stylesheet" href="PlaylistCSS/insert.css"> 

<script>
    function validateForm() {
        let title = document.getElementById("title").value.trim();
        let artist = document.getElementById("artist").value.trim();
        let category = document.getElementById("category").value.trim();
        let description = document.getElementById("description").value.trim();

        // Title validation
        if (title === "") {
            alert("Title is required.");
            return false;
        }

        // Artist validation
        if (artist === "") {
            alert("Artist is required.");
            return false;
        }

        // Category validation
        if (category === "") {
            alert("Category is required.");
            return false;
        }

        // Description validation
        if (description === "") {
            alert("Description is required.");
            return false;
        }

        // Check minimum character length
        if (description.length < 10) {
            alert("Description must be at least 10 characters long.");
            return false;
        }

        return true;
    }
</script>
</head>
<body>


    <form action="PlaylistInsertServlet" method="Post" onsubmit="return validateForm();">
    
    	<h1>Add Song For Playlist </h1>
    	
        <label for="title">Title:</label><br>
        <input type="text" id="title" name="title" ><br><br>

        <label for="artist">Artist:</label><br>
        <input type="text" id="artist" name="artist" ><br><br>

        <label for="category">Category:</label><br>
        <input type="text" id="category" name="category" ><br><br>

        <label for="description">Description:</label><br>
        <textarea id="description" name="description" rows="4" cols="50" ></textarea><br><br>

        <input type="submit" value="Add Playlist">
    </form>

</body>
</html>