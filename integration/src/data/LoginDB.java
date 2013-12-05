package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import business.Login;

public class LoginDB {

	private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static String DB_URL = "jdbc:mysql://localhost:3306/edondem";
	// Database credentials
	private static String username = "root";
	private static String password = "root";
	private static Connection connection = null;
	
	
	public static Login getLogin(String userId, String pwd) {
		//ConnectionPool pool = ConnectionPool.getInstance();
		//Connection connection = pool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		Login login = null;

		try {
			Class.forName(JDBC_DRIVER);
			// STEP 3: Open a connection
			System.out.println("Connecting to database login...");
			connection = (Connection) DriverManager.getConnection(DB_URL, username, password);
			String loginSQL = "SELECT * "
					+ "FROM LOGIN "
					+ "WHERE USER_ID = '" + userId + "' AND PWD = '"
					+ pwd + "';";

			ps = connection.prepareStatement(loginSQL);
			rs = ps.executeQuery(loginSQL);

			if (rs.next()) {
				login = new Login();
				login.setStudentId(rs.getString("LOGIN_ID"));
				login.setUserId(rs.getString("USER_ID"));
				login.setPwd(rs.getString("PWD"));
				login.setStudentId(rs.getString("STUDENT_ID"));
				login.setProfId(rs.getString("PROF_ID"));
				
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}finally {
			//DBUtil.closeResultSet(rs);
			//DBUtil.closePreparedStatement(ps);
			//pool.freeConnection(connection);
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return login;
	}
	public boolean insertlogininfo(int nextid,int nextstdid, String profEmail, String pwd) {

		PreparedStatement ps = null;
		ResultSet rs = null;

		Login login = null;

		
			String requestSQL = "INSERT INTO login "
					+ "VALUES (LOGIN_ID, ?, ?, ?, ?)";
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				// STEP 3: Open a connection
				System.out.println("Connecting to database... logindb");
				connection = (Connection) DriverManager.getConnection(DB_URL, username, password);
				ps = connection.prepareStatement(requestSQL);
				//ps.setString(1, x);
				ps.setString(1, profEmail);
				ps.setString(2, pwd);
				ps.setInt(3, nextid);
				ps.setInt(4, nextid);
						
				ps.executeUpdate();
				return true;
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
		
			return false;
		}

	
	public boolean insertlogininfostd(int nextid,int nextstdid, String profEmail, String pwd) {

		PreparedStatement ps = null;
		ResultSet rs = null;

		Login login = null;

		
			String requestSQL = "INSERT INTO login "
					+ "VALUES (LOGIN_ID, ?, ?, ?, ?)";
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				// STEP 3: Open a connection
				System.out.println("Connecting to database... logindb");
				connection = (Connection) DriverManager.getConnection(DB_URL, username, password);
				ps = connection.prepareStatement(requestSQL);
				//ps.setString(1, x);
				ps.setString(1, profEmail);
				ps.setString(2, pwd);
				ps.setInt(3, nextid);
				ps.setInt(4, nextid);
						
				ps.executeUpdate();
				return true;
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
		
			return false;
		}

	
	}

