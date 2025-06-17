package musicstorepackage;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/artist_regdeleteServlet")
public class artist_regdeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       



	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id =request.getParameter("id");
		boolean isTrue;
		isTrue = artist_regControl.deletedata(id);
		

		if(isTrue==true) {
			List<artist_regModel> regdetails=artist_regControl.getById(id);
			request.setAttribute("regdetails", regdetails);
			
			String alertMessage = "Data Delete Successfull";
		 	response.getWriter().println("<script>alert('"+alertMessage+"');"+"window.location.href='artist_detailsgetCall'</script>");
			
		}
		else {

			
			RequestDispatcher dis2= request.getRequestDispatcher("wrong.jsp");
			dis2.forward(request,response);
		}
	}

}
