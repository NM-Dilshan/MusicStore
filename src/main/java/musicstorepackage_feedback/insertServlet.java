package musicstorepackage_feedback;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/insertServlet")



public class insertServlet extends baseServlet {
	private static final long serialVersionUID = 1L;
	
	private boolean isVAlidEmail(String email) {
		String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
		return email != null && email.matches(emailRegex);
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username= request.getParameter("username");
		String massage= request.getParameter("massage");
		String email= request.getParameter("email");
		
		//validation Email
		if (!isVAlidEmail(email)) {
            response.setContentType("text/html");
            response.getWriter().println("<script>alert('Invalid email address!');window.history.back();</script>");
            return;
            }
		
		//data insert alert
		boolean isTrue;
		isTrue = feedbackcontroller.insertdata(username,massage,email);
		
		if(isTrue == true) {
			sendAlert(response, "DAta insert successful","feedbackall");
		}else {
			forwardToPage(request,response,"feedbacks.jsp");
		}	
	}
}


	
		
		




