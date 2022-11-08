package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;

import model.Feedback;

public class DbOps {

	Connection con;
	PreparedStatement pstmt;

	public String driver, dbloc, dbpwd;
	Feedback fobj;

	public DbOps(String driver, String dbloc, String dbuser, String dbpwd, Feedback fobj) {

		this.driver = driver;
		this.dbloc = dbloc;
		this.dbpwd = dbpwd;
		this.fobj = fobj;

		try {
			Class.forName(this.driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con = (Connection) DriverManager.getConnection(dbloc, dbuser, dbpwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int insertrcr(Feedback fobj) {
		this.fobj = fobj;

		int status = 0;
		int fid = this.fobj.getFeedid();
		String fname = this.fobj.getFeedname();
		String fmsg = this.fobj.getFeedmessage();

		String insertquery = "INSERT INTO tblfeedback (feedid,feedname,feedmsg) values (?,?,?)";
		try {
			pstmt = con.prepareStatement(insertquery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

			pstmt.setInt(1, fid);
			pstmt.setString(2, fname);
			pstmt.setString(3, fmsg);

			status = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
}
