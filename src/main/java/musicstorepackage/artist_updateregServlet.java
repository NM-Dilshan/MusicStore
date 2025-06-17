package musicstorepackage;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/artist_updateregServlet")
public class artist_updateregServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public artist_updateregServlet() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String fullName = request.getParameter("fullName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String artistCode = request.getParameter("artistCode");
		String phone = request.getParameter("phone");
		
		boolean isTrue;
		isTrue=artist_regControl.update(id, fullName, email, password,artistCode,phone);
		
		
		if(isTrue==true) {
			List<artist_regModel> userreg=artist_regControl.getById(id);
			request.setAttribute("userreg", userreg);
			String alertMessage = "Data Update Succesfully";
			response.getWriter().println("<script> alert ('"+alertMessage+"'); window.location.href='artist_detailsgetCall'</script>");//true nm part ekt yana eka
		}
		else {
			
			

			RequestDispatcher dis2= request.getRequestDispatcher("wrong.jsp");
			dis2.forward(request,response);
		}
	}

}
