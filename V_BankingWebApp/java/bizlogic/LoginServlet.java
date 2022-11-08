package bizlogic;

import java.io.IOException;

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
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;

public class LoginServlet extends HttpServlet {
   
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	String drivername;
	String dblocation;
	String dbusername;
	String dbuserpwd;
	
	String sitelang;
	String sitecountry;
    public LoginServlet() {
        super();
    }

	
	public void init(ServletConfig config) throws ServletException {
		ServletContext ctx = config.getServletContext();
		drivername = ctx.getInitParameter("ddriver");
		//dblocation = ctx.getInitParameter("dbloc");
		dbusername = ctx.getInitParameter("dbuser");
		dbuserpwd = ctx.getInitParameter("dbpwd");
		
		sitelang = config.getInitParameter("reginitparam");
		sitecountry = config.getInitParameter("loginitparam");
		
		System.out.println("In Login : "+sitelang+" "+sitecountry);
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// MIME : Multipurpose Internet Mail Extension - Type of data to be exchanged between
		// browser and server
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		// Collecting form data submitted via logi.htm from client to server
		String un = request.getParameter("txtuname");
		String up = request.getParameter("txtpwd");
		
		try {
			// Step 1 : Loading the driver
			
			Class.forName(drivername);
			
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		try {
			// Step 2 : Establishing the connectivity
			con =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bnk_web_app?characterEncoding=utf8", dbusername, dbuserpwd);
			System.out.println("Connection Done");
			
			String searchquery = "select cname,cusername,cuserpwd from tblbankuser where cusername=? and cuserpwd=?";
			
			pstmt = con.prepareStatement(searchquery,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			pstmt.setString(1, un);
			pstmt.setString(2, up);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {

				// Session Management Begins
				
				// Starting session for authenticated user
				HttpSession sessionid = request.getSession();
				System.out.println("Generate Token Id "+sessionid);
				
				//Storing user specific value in session
				sessionid.setAttribute("unkey", un);
				sessionid.setAttribute("upkey", up);
				//Redirecting
				RequestDispatcher redirect = request.getRequestDispatcher("profileserv");
				redirect.forward(request, response);
			}
			else {
				
				
				out.println("<center><font color=red size=4>Username and/or Password Incorrect</font></center>");
				RequestDispatcher redirect = request.getRequestDispatcher("login.htm");
				redirect.include(request, response);
				
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}
}
