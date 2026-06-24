package com.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.DAO.AttendanceDAO;
import com.Model.Model;

@WebServlet("/InsertStudentController")
public class InsertStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public InsertStudentController() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Batch = request.getParameter("Batch");
		int roll_number = Integer.parseInt(request.getParameter("Roll_No"));
		String Student_naame = request.getParameter("Student_Name");
		int Avg_Marks = Integer.parseInt(request.getParameter("Avg_Marks"));
		long Phone = Integer.parseInt(request.getParameter("Phone"));
		String Email = request.getParameter("Email");
		Model m = new Model();
		m.setBatch(Batch);
		m.setRoll_No(roll_number);
		m.setStudent_Name(Student_naame);
		m.setAvg_Marks(Avg_Marks);
		m.setPhone(Phone);
		m.setEmail(Email);
		AttendanceDAO AM = new AttendanceDAO();
		if( AM.insertStudent(m)) {
			
			RequestDispatcher rd = request.getRequestDispatcher("Attendance.jsp");
			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("StaffLogin.jsp");
			rd.forward(request, response);
		
		doGet(request, response);
	}

}
}
