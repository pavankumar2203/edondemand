package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import business.Professor;
import business.Student;

public class StudentDB {
	private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static String DB_URL = "jdbc:mysql://localhost:3306/edondem";
	// Database credentials
	private static String username = "root";
	private static String password = "root";
	private static Connection connection = null;
	
	
	public static boolean addStudent(Student student) {
		  PreparedStatement ps = null;
		  boolean returnvalue = false;
		  
		  try {
		   Class.forName(JDBC_DRIVER);
		   System.out.println("Connecting to database...");
		   connection = (Connection) DriverManager.getConnection(DB_URL, username, password);
		   String query = "INSERT INTO STUDENTS (STUD_FNAME, STUD_LNAME, STUD_GENDER, STUD_AGE, STUD_EMAIL) "
		     + "VALUES ( ?, ?, ?, ?, ?)";
		   ps = connection.prepareStatement(query);
		   ps.setString(1, student.getStudFname());
		   ps.setString(2, student.getStudLname());
		   ps.setString(3, student.getStudGender());
		   ps.setString(4, student.getStudAge());
		   ps.setString(5, student.getStudEmail());
		   returnvalue = (ps.executeUpdate() == 1); 
		           
		  } catch (SQLException e) {
		   e.printStackTrace();
		   return false;
		  } catch (Exception e) {
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

	
	public static Student getStudent(String studentId) {
		//ConnectionPool pool = ConnectionPool.getInstance();
		//Connection connection = pool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Student student = null;

		try {
			Class.forName(JDBC_DRIVER);
			// STEP 3: Open a connection
			System.out.println("Connecting to database student...");
			connection = (Connection) DriverManager.getConnection(DB_URL, username, password);
			String studentSQL = "SELECT * FROM STUDENTS "
					+ "WHERE STUDENT_ID = " + studentId + ";";
			ps = connection.prepareStatement(studentSQL);
			rs = ps.executeQuery(studentSQL);

			if (rs.next()) {
				student = new Student();
				student.setStudentId(rs.getString("STUDENT_ID"));
				student.setStudFname(rs.getString("STUD_FNAME"));
				student.setStudLname(rs.getString("STUD_LNAME"));
				student.setStudGender(rs.getString("STUD_GENDER"));
				student.setStudAge(rs.getString("STUD_AGE"));
				student.setStudEmail(rs.getString("STUD_EMAIL"));
				student.setStudScore(rs.getString("STUD_SCORE"));

				
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
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
		return student;
	}


	public static int getcount() {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		ResultSet rs = null;
		int returnvalue = 0;
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("Connecting to database... get count");
			connection = (Connection) DriverManager.getConnection(DB_URL, username, password);
			String query = "SELECT max(STUDENT_ID) FROM students";
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


	public static boolean adddummyStudent(Professor newProfessor) {
		  PreparedStatement ps = null;
		  boolean returnvalue = false;
		  
		  try {
		   Class.forName(JDBC_DRIVER);
		   System.out.println("Connecting to database...");
		   connection = (Connection) DriverManager.getConnection(DB_URL, username, password);
		   String query = "INSERT INTO STUDENTS (STUD_FNAME, STUD_LNAME, STUD_GENDER, STUD_AGE, STUD_EMAIL) "
		     + "VALUES ( ?, ?, ?, ?, ?)";
		   ps = connection.prepareStatement(query);
		   ps.setString(1, newProfessor.getProfName());
		   ps.setString(2, newProfessor.getProfName());
		   ps.setString(3, "M");
		   ps.setString(4, "null");
		   ps.setString(5, newProfessor.getProfEmail());
		   returnvalue = (ps.executeUpdate() == 1); 
		           
		  } catch (SQLException e) {
		   e.printStackTrace();
		   return false;
		  } catch (Exception e) {
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
