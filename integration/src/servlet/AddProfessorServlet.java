package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.LoginDB;
import data.ProfessorDB;
import data.StudentDB;
import business.Login;
import business.Professor;

public class AddProfessorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProfessorServlet() {
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
		Professor newProfessor = new Professor();
		
		String profName = request.getParameter("profName");
		String profEmail = request.getParameter("profEmail");
		String profPhone = request.getParameter("profPhone");
		String profSkill = request.getParameter("profSkill");
		String profCertificate = request.getParameter("profCertificate");
		String profProfession = request.getParameter("profProfession");
		String pwd = request.getParameter("password");

		String url = "";
		String message = "";
		boolean bool = true;
	   		
		newProfessor.setProfName(profName);
		newProfessor.setProfEmail(profEmail);
		newProfessor.setProfPhone(profPhone);
		newProfessor.setProfSkill(profSkill);
		newProfessor.setProfCertificate(profCertificate);
		newProfessor.setProfProfession(profProfession);
	    session.setAttribute("newProfessor", newProfessor);
	    
		bool = ProfessorDB.addProfessor(newProfessor);
		boolean bool2 = StudentDB.adddummyStudent(newProfessor);
		int nextid = ProfessorDB.getcount();
		int nextstdid = StudentDB.getcount();
		
		
		LoginDB newlogin = new LoginDB();
		boolean in = newlogin.insertlogininfo(nextid,nextstdid,profEmail,pwd);
		 if (bool == false) {			
			message = "Error: Cannot add this professor";			
           url = "/professorsignup.jsp";            
		} else {
			message = "You have signed up successfully.";
           url = "/index.jsp"; 
		}
		
        request.setAttribute("message", message);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
	}
}
