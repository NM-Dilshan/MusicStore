package musicstorepackage;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/artist_detailsgetCall")
public class artist_detailsgetCall extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List <artist_regModel>allusers = artist_regControl.getAllUserdetails();
		request.setAttribute("allusers", allusers);
		RequestDispatcher dispatcher = request.getRequestDispatcher("artist_userDetails.jsp");
		dispatcher.forward(request, response);
				
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request,response);
	}
}


 