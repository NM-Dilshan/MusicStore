package usermusicstorepackage;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/profile_deleteServlet")
public class profile_deleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id =request.getParameter("id");
		boolean isTrue;
		isTrue = profile_usserControl.deleteProfile(id);
		

		if(isTrue==true) {
			List<profile_userModel> regdetails=profile_usserControl.getById(id);
			request.setAttribute("regdetails", regdetails);
			
			String alertMessage = "Data Delete Successfull";
		 	response.getWriter().println("<script>alert('"+alertMessage+"');"+"window.location.href='profile_login.jsp'</script>");
			
		}
		else {

			
			RequestDispatcher dis2= request.getRequestDispatcher("wrong.jsp");
			dis2.forward(request,response);
		}
		
	}

}
