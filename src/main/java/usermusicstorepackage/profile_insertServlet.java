package usermusicstorepackage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/profile_insertServlet")
public class profile_insertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		
		boolean isTrue;
		isTrue = profile_usserControl.insertdata(firstName,lastName,email,password,phone);
		
		if(isTrue==true) {
			String alertMessage = "Register Succesfully";
			response.getWriter().println("<script> alert ('"+alertMessage+"'); window.location.href='profile_login.jsp'</script>");//true nm part ekt yana eka
		}
		else {
			
			
			request.setAttribute("emailError", "Email already exists");//email exist
			RequestDispatcher dis2= request.getRequestDispatcher("profile_register.jsp");
			dis2.forward(request,response);
		}
		
		
	}

}
