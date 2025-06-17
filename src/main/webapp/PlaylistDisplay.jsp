<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PlayList</title>
<link rel="stylesheet" href="PlaylistCSS/playlistDisplaystyle.css">

</head>
<body>

    <table>
        <caption>PlayList</caption>
        <thead>
        <input type="text" id="searchInput" placeholder="Search... ">
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Artist</th>
                <th>Category</th>
                <th>Description</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
      <c:forEach var ="playlist" items ="${allplaylists}">
            <tr>
                <td>${playlist.id}</td>
                <td>${playlist.title}</td>
                <td>${playlist.artist}</td>
                <td>${playlist.category}</td>
                <td>${playlist.description}</td>
           
         
          <td> 
         <a href="PlaylistUpdate.jsp?id=${playlist.id}&title=${playlist.title}&artist=${playlist.artist}&category=${playlist.category}&description=${playlist.description}">
         <button> Update </button>
          </a>
          
          <form action="PlaylistDeleteServlet" method ="post" onsubmit="return confirmDelete();">
          <input type="hidden" name="id" value="${playlist.id}" />
          <button> Delete </button>
          </form>
          
          </td>
          </tr>
        </tbody>
  </c:forEach>
  </table>
 <script>
function filterTable() {
    var input, filter, table, tr, td, i, textvalue;
    input = document.getElementById("searchInput");
    filter = input.value.toUpperCase();
    table = document.querySelector("table");
    tr = table.getElementsByTagName("tr");

    for (i = 1; i < tr.length; i++) { // skip header row if needed
        td = tr[i].getElementsByTagName("td");
        let rowMatch = false;
        for (var j = 0; j < td.length; j++) {
            if (td[j]) {
                textvalue = td[j].textContent || td[j].innerText;
                if (textvalue.toUpperCase().indexOf(filter) > -1) {
                    rowMatch = true;
                    break;
                }
            }
        }
        tr[i].style.display = rowMatch ? "" : "none";
    }
}

 document.getElementById("searchInput").addEventListener("input", filterTable);
 
	function confirmDelete() {
	    return confirm("Are you sure you want to delete this user?");
	}
 </script>
     
</body>
</html>