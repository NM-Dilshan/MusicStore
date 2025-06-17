package musicstorepackage_feedback;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/updateServlet")
public class updateServlet extends baseServlet {
	private static final long serialVersionUID = 1L;

    protected void sendAlert(HttpServletResponse response, String message, String redirectURL) throws IOException {
        response.getWriter().println("<script>alert('" + message + "');window.location.href='" + redirectURL + "'</script>");
    }

    protected void forwardToPage(HttpServletRequest request, HttpServletResponse response, String page) throws IOException {
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher(page);
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String feedbackID= request.getParameter("feedbackID");
		String username= request.getParameter("username");
		String massage= request.getParameter("massage");
		String email= request.getParameter("email");
		
		boolean isTrue;
		isTrue = feedbackcontroller.updatedata(feedbackID,username,massage,email);
		
		
		if(isTrue == true) {
			sendAlert(response, "DAta Update Successful","feedbackall");
		}
		
		else {
			forwardToPage(request,response,"feedbacks.jsp");
		}
	}

}
