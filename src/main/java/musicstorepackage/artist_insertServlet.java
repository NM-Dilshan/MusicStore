package musicstorepackage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/artist_insertServlet")
public class artist_insertServlet extends HttpServlet { 
	private static final long serialVersionUID = 1L;
       



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fulltName = request.getParameter("fullName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String artistCode = request.getParameter("artistCode");
		String phone = request.getParameter("phone");
		
		boolean isTrue;
		isTrue = artist_regControl.insertdata(fulltName,email,password,artistCode,phone);
		
		if(isTrue==true) {
			String alertMessage = "Data Insert Succesfully";
			response.getWriter().println("<script> alert ('"+alertMessage+"'); window.location.href='artist_detailsgetCall'</script>");//true nm part ekt yana eka
		}
		else {
			
			
			request.setAttribute("emailError", "Email already exists");//email exist
			RequestDispatcher dis2= request.getRequestDispatcher("artist_register.jsp");
			dis2.forward(request,response);
		}
		

	}

}
