package addSong;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/addSong_allSongServlet")
public class addSong_allSongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String email = request.getParameter("email");
		
		List <addSong_Model>allusers = addSong_Control.getById(id,email);
		request.setAttribute("allusers", allusers);
		RequestDispatcher dispatcher = request.getRequestDispatcher("addSong_Details.jsp");
		dispatcher.forward(request, response);	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request,response);
	}
}


