package Playlist;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/PlaylistInsertServlet")
public class PlaylistInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			

			String title =request.getParameter("title");
			String artist =request.getParameter("artist");
			String category =request.getParameter("category");
			String description =request.getParameter("description");
			
			boolean isTrue;
			
			isTrue = PlaylistController.insertdata(title, artist, category, description);
			
			if(isTrue ==true) { 
				String alertMessage ="Data Insert Succesfull";
				response.getWriter().println("<script> alert ('"+alertMessage+"');window.location.href ='PlaylistGetAllServlet' </script>");
			}
			else {
				RequestDispatcher dis2=request.getRequestDispatcher("wrong.jsp");
				
				dis2.forward(request,response);
			}
			
	   
	 }
}
