package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import business.Professor;
import business.Student;

public class ProfessorDB {
	
	private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static String DB_URL = "jdbc:mysql://localhost:3306/edondem";
	private static String username = "root";
	private static String password = "root";
	private static Connection connection = null;
	
	public static int getcount()
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
		int returnvalue = 0;
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("Connecting to database... get count");
			connection = (Connection) DriverManager.getConnection(DB_URL, username, password);
			//String query = "select count(*) from PROFESSOR";
			String query = "SELECT max(PROF_ID) FROM PROFESSOR";
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery(query);
			
			if(rs.next())
			{
				returnvalue = rs.getInt(1);
				//returnvalue++;
				
			}
		}
		 catch (SQLException e) {
				e.printStackTrace();
				return 0;
			} catch (Exception e) {
				// Handle errors for Class.forName
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return returnvalue;
		
		
	}
	public static boolean addProfessor(Professor professor) {
		PreparedStatement ps = null;
		boolean returnvalue = false;
		
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("Connecting to database...");
			connection = (Connection) DriverManager.getConnection(DB_URL, username, password);
			String query = "INSERT INTO PROFESSOR (PROF_NAME, EMAIL, PHONE,SCORE, SKILL, CERTIFICATE, PROFESSION) "
					+ "VALUES ( ?, ?, ?, ?, ?, ?, ?)";
			ps = connection.prepareStatement(query);
			ps.setString(1, professor.getProfName());
			ps.setString(2, professor.getProfEmail());
			ps.setString(3, professor.getProfPhone());
			ps.setString(4, "0");
			ps.setString(5, professor.getProfSkill());
			ps.setString(6, professor.getProfCertificate());
			ps.setString(7, professor.getProfProfession());

			returnvalue = (ps.executeUpdate() == 1); 
											
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return returnvalue;
	}
	public static boolean adddummyProfessor(Student newStudent) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		boolean returnvalue = false;
		
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("Connecting to database...");
			connection = (Connection) DriverManager.getConnection(DB_URL, username, password);
			String query = "INSERT INTO PROFESSOR (PROF_NAME, EMAIL, PHONE,SCORE, SKILL, CERTIFICATE, PROFESSION) "
					+ "VALUES ( ?, ?, ?, ?, ?, ?, ?)";
			ps = connection.prepareStatement(query);
			ps.setString(1, newStudent.getStudFname());
			ps.setString(2, newStudent.getStudEmail());
			ps.setString(3,"null");
			ps.setString(4, "0");
			ps.setString(5, "null");
			ps.setString(6, "null");
			ps.setString(7, "null");

			returnvalue = (ps.executeUpdate() == 1); 
											
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return returnvalue;
	}
}
