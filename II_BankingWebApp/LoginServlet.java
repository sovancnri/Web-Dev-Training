package bizlogic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
   
    public LoginServlet() {
        super();
    }

	
	public void init(ServletConfig config) throws ServletException {
		
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// MIME : Multipurpose Internet Mail Extension - Type of data to be exchanged between
		// browser and server
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		// Collecting form data submitted via logi.htm from client to server
		String un = request.getParameter("txtuname");
		String up = request.getParameter("txtpwd");
		
		//Login Validation follows at server
		//System.out.println(un+" "+up);
		
		if(un.equals("mack") && up.equals("mack")) {
			//out.println("<center><font color=green size=4>Success</font></center>");
			RequestDispatcher redirect = request.getRequestDispatcher("service.htm");
			redirect.forward(request, response);
		}else {
			/*out.println("<center><font color=red size=4>Username and/or Password Incorrect</font></center>");
			RequestDispatcher redirect = request.getRequestDispatcher("login.htm");
			redirect.include(request, response);*/
			response.sendRedirect("http://www.google.com");
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}
}
