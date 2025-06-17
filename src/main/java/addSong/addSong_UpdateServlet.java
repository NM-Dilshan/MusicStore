package addSong;

import java.io.File;
import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;






@WebServlet("/addSong_UpdateServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1,  // 1MB
maxFileSize = 1024 * 1024 * 50,       // 50MB
maxRequestSize = 1024 * 1024 * 60)    // 60MB

public class addSong_UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Id = request.getParameter("id");
		String songName = request.getParameter("songName");
		String artistEmail = request.getParameter("artistEmail");
		String description = request.getParameter("description");
		String date = request.getParameter("date");
		String artistName = request.getParameter("artistName");
		
		// File upload part
		Part filePart = request.getPart("musicFile"); // "musicFile" is the name attribute in your form
		String fileName = getFileName(filePart);
		
		
		String uploadPath = getServletContext().getRealPath("") + File.separator + "upload";  
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) uploadDir.mkdir();

		String fullPath = uploadPath + File.separator + fileName;
		filePart.write(fullPath);
		
		// Save relative path to DB
		String filePath = "upload/" + fileName;

 

		// Call insert method
		boolean isTrue = addSong_Control.update(Id,songName, artistEmail, filePath, date, description,artistName);
		
		
		if (isTrue) {
			
			String alertMessage = "Data Inserted Successfully";
			response.getWriter().println("<script> alert('" + alertMessage + "'); window.location.href='artist_profileServlet'</script>");
		} else {
			RequestDispatcher dis2 = request.getRequestDispatcher("addSong_Update.jsp");
			dis2.forward(request, response);
		}
	}

	// Get original file name
	private String getFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		for (String token : contentDisp.split(";")) {
			if (token.trim().startsWith("filename")) {
				return token.substring(token.indexOf('=') + 2, token.length() - 1);
			}
		}
		return "";
	}

}
