package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import business.Request;

public class RequestDB {

	private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static String DB_URL = "jdbc:mysql://localhost:3306/edondem";
	// Database credentials
	private static String username = "root";
	private static String password = "root";
	private static Connection connection = null;
	
	public static boolean addRequest(Request request) {
		//ConnectionPool pool = ConnectionPool.getInstance();
		//Connection connection = pool.getConnection();
		System.out.println(request.getRequestId());
		System.out.println(request.getStudentId());
		System.out.println(request.getCourseName());
		System.out.println(request.getCredit());
		System.out.println(request.getCategory());
		
		PreparedStatement ps = null;
		boolean returnvalue = false;
		String requestSQL = "INSERT INTO request "
				+ "VALUES (REQUEST_ID, ?, ?, ?, ?)";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			connection = (Connection) DriverManager.getConnection(DB_URL, username, password);
			ps = connection.prepareStatement(requestSQL);
			//ps.setString(1, x);
			ps.setString(1, request.getStudentId());
			ps.setString(2, request.getCourseName());
			ps.setString(3, request.getCredit());
			ps.setString(4, request.getCategory());
											
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			//DBUtil.closePreparedStatement(ps);
			//pool.freeConnection(connection);
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			returnvalue = (ps.executeUpdate() == 1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return returnvalue;
	}
}
