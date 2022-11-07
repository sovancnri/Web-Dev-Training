package bizlogic;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {

	public RegisterServlet() {
		super();

	}

	public void init(ServletConfig config) throws ServletException {

	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Collecting the form data from incoming request hai\ving
		// data of register.htm

		String name = request.getParameter("txtname");
		String age = request.getParameter("txtage");
		String gender = request.getParameter("gender");
		String address = request.getParameter("txtaddress");
		String email = request.getParameter("txtemail");
		String username = request.getParameter("txtuname");
		String password = request.getParameter("txtpwd");

		
		  System.out.println(name+" "+age+" "+gender+" "+address);
		  System.out.println(email+" "+password);
		 

		// We will backend app server with back end database server

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		service(request, response);
	}

}
