package usermusicstorepackage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/profile_profileServlet")
public class profile_profileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
		
		
	}
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		profile_userModel user = (profile_userModel) request.getSession().getAttribute("user");
		
		if(user !=null) {
			//forwar data 
			request.setAttribute("user", user);
			request.getRequestDispatcher("profile_profile.jsp").forward(request, response);
			
		}else {
			response.sendRedirect("profile_profile.jsp");
		}
	}

}
