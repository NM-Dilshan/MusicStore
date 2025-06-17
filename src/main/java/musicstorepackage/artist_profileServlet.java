package musicstorepackage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/artist_profileServlet")
public class artist_profileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		processRequest(request,response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		artist_regModel user = (artist_regModel) request.getSession().getAttribute("user");
		
		if(user !=null) {
			//forwar data 
			request.setAttribute("user", user);
			request.getRequestDispatcher("artist_profile.jsp").forward(request, response);
			
		}else {
			response.sendRedirect("artist_profile.jsp");
		}
	}

}
