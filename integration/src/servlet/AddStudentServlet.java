package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import business.Professor;
import business.Student;
import data.LoginDB;
import data.ProfessorDB;
import data.StudentDB;

public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Student newStudent = new Student();
		
		String studFname = request.getParameter("studFname");
		String studLname = request.getParameter("studLname");
		String studGender = request.getParameter("studGender");
		String studAge = request.getParameter("studAge");
		String studEmail = request.getParameter("studEmail");
		String pwd = request.getParameter("password");

		String url = "";
		String message = "";
		boolean bool = true;
	   		
		newStudent.setStudFname(studFname);
		newStudent.setStudLname(studLname);
		newStudent.setStudGender(studGender);
		newStudent.setStudAge(studAge);
		newStudent.setStudEmail(studEmail);
	    session.setAttribute("newStudent", newStudent);
	    
		bool = StudentDB.addStudent(newStudent);
		boolean bool2 = ProfessorDB.adddummyProfessor(newStudent);
		int nextid = ProfessorDB.getcount();
		int nextstdid = StudentDB.getcount();
		
		
		LoginDB newlogin = new LoginDB();
		boolean in = newlogin.insertlogininfostd(nextid,nextstdid,studEmail,pwd);
		
		
		 if (bool == false) {			
			message = "Error: Cannot add this student";			
           url = "/studentsignup.jsp";            
		} else {
			message = "You have signed up successfully.";
           url = "/index.jsp"; 
		}
		
        request.setAttribute("message", message);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
	}
}
