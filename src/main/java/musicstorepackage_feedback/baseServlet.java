package musicstorepackage_feedback;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class baseServlet extends HttpServlet{
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
	

}
