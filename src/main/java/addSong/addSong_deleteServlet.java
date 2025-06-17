package addSong;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/addSong_deleteServlet")
public class addSong_deleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id =request.getParameter("id");
		boolean isTrue;
		isTrue = addSong_Control.deletedata(id);
		

		if(isTrue==true) {
			List<addSong_Model> regdetails=addSong_Control.getById1(id);
			request.setAttribute("regdetails", regdetails);
			
			String alertMessage = "Data Delete Successfull";
		 	response.getWriter().println("<script>alert('"+alertMessage+"');"+"window.location.href='artist_profileServlet'</script>");
			
		}
		else {

			
			RequestDispatcher dis2= request.getRequestDispatcher("wrong.jsp");
			dis2.forward(request,response);
		}
	}

}
