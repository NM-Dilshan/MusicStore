package musicstorepackage_feedback;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/deleteServlet")
public class deleteServlet extends baseServlet {
	private static final long serialVersionUID = 1L;
       

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String feedbackID = request.getParameter("feedbackID");
		
		boolean isTrue;
		isTrue = feedbackcontroller.deletedata(feedbackID);
		
		if(isTrue == true) {
			sendAlert(response, "DAta Delet successful","feedbackall");
		}
		else {
			List<feedbackmodel> feedbackdetails = feedbackcontroller.getById(feedbackID);
			request.setAttribute("feedbackdetails", feedbackdetails);
			
			forwardToPage(request,response,"feedbacks.jsp");
		}
	}
	

}
