package bizlogic;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;

public class ProfileServlet extends HttpServlet {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	String drivername;
	String dblocation;
	String dbusername;
	String dbuserpwd;
	
       
    public ProfileServlet() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		ServletContext ctx = config.getServletContext();
		drivername = ctx.getInitParameter("ddriver");
		dblocation = ctx.getInitParameter("dbloc");
		dbusername = ctx.getInitParameter("dbuser");
		dbuserpwd = ctx.getInitParameter("dbpwd");
		
		
	}

	public ServletConfig getServletConfig() {
		return null;
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		// Retrieving value passed by LoginAuthentication servlet, by storing it into the session
		HttpSession sid = request.getSession(false);
		
		if(sid != null) {
		
		String username = (String) sid.getAttribute("unkey");
		String userpwd = (String) sid.getAttribute("upkey");
		
		out.println("<center><font color=green></font></center>");
		out.println("<a href=logout.html>Logout</a>");
		out.println("<a href=logout>Logout</a>");
		
		out.println("<center><font color=green>Welcome to Your Profile Dear"+username+"</font></center>");
		
		//use jdbc code to build the profile page
		
		}else {
			out.println("<center><font color=red>Protected Resource ...Session Id Required</font></center>");
			RequestDispatcher redirect = request.getRequestDispatcher("login.htm");
			redirect.include(request,response);
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

}
