package admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/adminServlet")
public class adminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		try {
			List<adminModel> userlogin = adminControl.loginValidate(email, password);
			
			if(userlogin != null && !userlogin.isEmpty()) {
				
				//session part
				HttpSession session = request.getSession();
				session.setAttribute("user", userlogin.get(0));
				
				request.getSession().setAttribute("user", userlogin.get(0));
				response.sendRedirect("admin.jsp");
			
				
			}else {
				String alertMessage = "Invalid email or password";
				response.getWriter().println("<script>alert('"+alertMessage+"');window.location.href='adminLogin.jsp'</script>");
				
			}
			
			request.setAttribute("userlogin", userlogin);
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		

	}
}


