package bizlogic;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

public class LoginServlet extends HttpServlet {
   
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
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
		
		try {
			// Step 1 : Loading the driver
			
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		try {
			// Step 2 : Establishing the connectivity
			con =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bnk_web_app?characterEncoding=utf8", "root", "oracle");
			
			String searchquery = "select cname,cusername,cuserpwd from tblbankuser where cusername=? and cuserpwd=?";
			
			pstmt = con.prepareStatement(searchquery,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			pstmt.setString(1, un);
			pstmt.setString(2, up);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				//out.println("<center><font color=green size=4>Success</font></center>");
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
