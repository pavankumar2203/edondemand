package controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AddReadCourse extends HttpServlet {
    
    public int create(String pID, String courseID, String cName, String com, Connection con)
       throws SQLException, Exception {
        
        PreparedStatement statement = null;

        try {
             statement = con.prepareStatement("Insert into Courses (COURSE_ID, COURSE_NAME, Comments, prof_ID)"  +
                                                "Values (?,?,?,?)"); 
             statement.setString(1,courseID);
             statement.setString(2,cName);
             statement.setString(3,com);            
             statement.setString(4,pID);             
             return statement.executeUpdate();
        }

        catch(SQLException e) {
             System.out.println("Caught exception in create" + e);
             throw new Exception(e);
        }

        finally {
             if(statement != null) {
                 statement.close();
             }
        }
    }

    public ArrayList<String> read(Connection con) throws SQLException {

         PreparedStatement statement = null;
         ArrayList<String> availCourses =  new ArrayList<String>();

         try {

             statement = con.prepareStatement("Select COURSE_NAME FROM courses");
             ResultSet result = statement.executeQuery();

             if(result.next()) {
                 availCourses.add(result.getString(1));
             }
             else {
                 System.out.println("Could not read a record");
             }
             System.out.println(availCourses.toString());
             return availCourses;
         }
         finally {
                 if(statement != null) {
                     statement.close();
             }
         }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {       
        Connection con;        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/edondem","root","root");        

            AddReadCourse perform = new AddReadCourse();
            ArrayList<String> result = perform.read(con);        
            System.out.println("Ran the operation");
            
            request.setAttribute("readResult", result);
            RequestDispatcher view = request.getRequestDispatcher("FacultyCourse.jsp");
            view.forward(request, response);
            con.close();
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(AddReadCourse.class.getName()).log(Level.SEVERE, null, ex);
        }                   
         catch (Exception ex) {
            Logger.getLogger(AddReadCourse.class.getName()).log(Level.SEVERE, null, ex);
                RequestDispatcher view = request.getRequestDispatcher("error.jsp");
                view.forward(request, response);            
        }         
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String profID1 = "1";
        boolean isCommit = true;
        String cID = request.getParameter("ID");          
        String cName = request.getParameter("name");  
        String com = request.getParameter("comments");         
        try {
        	   Class.forName("com.mysql.jdbc.Driver");
               Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/edondem","root","root"); 

            AddReadCourse perform = new AddReadCourse();
            perform.create(profID1, cID, cName,com, con);        
            System.out.println("Ran the operation");

            if(isCommit) {
                RequestDispatcher view = request.getRequestDispatcher("FacultyDashboard.jsp");
                view.forward(request, response);
            }
            else {
                RequestDispatcher view = request.getRequestDispatcher("error.jsp");
                view.forward(request, response);
            }             
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(AddReadCourse.class.getName()).log(Level.SEVERE, null, ex);
        }                   
         catch (Exception ex) {
            Logger.getLogger(AddReadCourse.class.getName()).log(Level.SEVERE, null, ex);
        }                 
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
