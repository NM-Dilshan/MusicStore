package usermusicstorepackage;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





@WebServlet("/profile_updateServlet")
public class profile_updateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String id = request.getParameter("id");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		
		
		boolean isTrue;
		isTrue=profile_usserControl.updateprofile(id, firstName, lastName, email, password, phone);
		
		
		if(isTrue==true) {
			List<profile_userModel> user=profile_usserControl.getById(id);
			request.setAttribute("user", user);
			String alertMessage = "Data Update Succesfully";
			response.getWriter().println("<script> alert ('"+alertMessage+"'); window.location.href='profile_login.jsp'</script>");//true nm part ekt yana eka
		}
		else {
			
			
			
			RequestDispatcher dis2= request.getRequestDispatcher("wrong.jsp");
			dis2.forward(request,response);
		}
	}
}


