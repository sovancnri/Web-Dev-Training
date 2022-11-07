package bizlogic;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {

	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	String drivername;
	String dblocation;
	String dbusername;
	String dbuserpwd;
	
	String sitelang;
	String sitecountry;

	public RegisterServlet() {
		super();

	}

	public void init(ServletConfig config) throws ServletException {
		
		ServletContext ctx = config.getServletContext();
		drivername = ctx.getInitParameter("ddriver");
		dblocation = ctx.getInitParameter("dbloc");
		dbusername = ctx.getInitParameter("dbuser");
		dbuserpwd = ctx.getInitParameter("dbpwd");
		
		sitelang = config.getInitParameter("reginitparam");
		sitecountry = config.getInitParameter("loginitparam");
		
		System.out.println("In registration : "+sitelang+" "+sitecountry);
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Collecting the form data from incoming request hai\ving
		// data of register.htm

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		int status;
		String name = request.getParameter("txtname");
		String age = request.getParameter("txtage");
		String gender = request.getParameter("gender");
		String address = request.getParameter("txtaddress");
		String email = request.getParameter("txtemail");
		String username = request.getParameter("txtuname");
		String password = request.getParameter("txtpwd");

		try {
			// Step 1 : Loading the driver
			Class.forName(drivername);
			
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		try {
		// Step 2 : Establishing the connectivity
		con = DriverManager.getConnection(dblocation, dbusername, dbuserpwd);
		
		String s = "INSERT INTO tblbankuser VALUES (?,?,?,?,?,?)";
		
		pstmt = con.prepareStatement(s,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		// Placing Runtime text box value into the sql query wild card before sending the query
		pstmt.setString(1,name);
		pstmt.setInt(2, Integer.parseInt(age));
		pstmt.setString(3,gender);
		pstmt.setString(4,address);
		pstmt.setString(5,email);
		pstmt.setString(6, username);
		pstmt.setString(7, password);
		
		status = pstmt.executeUpdate();
		if(status > 0) {
			out.println("<center><font color=green>Registration Done.Please Login</font></center>");
			RequestDispatcher redirect = request.getRequestDispatcher("login.htm");
			redirect.include(request, response);
		}else {
			out.println("<center><font color=green>Something Went Wrong </font></center>");
			RequestDispatcher redirect = request.getRequestDispatcher("register.htm");
			redirect.include(request, response);
		}

		// We will backend app server with back end database server

		}catch(SQLException e) {
			out.println("<center><font color=red>Something Went Wrong </font></center>");
			RequestDispatcher redirect = request.getRequestDispatcher("register.htm");
			redirect.include(request, response);
			throw new RuntimeException(e);
		}
		
		
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
