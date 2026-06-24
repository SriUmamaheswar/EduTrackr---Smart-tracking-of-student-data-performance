package com.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.DAO.AttendanceDAO;
import com.Model.AttendanceModel;

@WebServlet("/MarksController")
public class MarksController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Batch = request.getParameter("Batch");
		String Marks = request.getParameter("Marks");
		String Date = request.getParameter("Date");
		AttendanceModel am = new AttendanceModel();
		am.setBatch(Batch);
		am.setDate(Date);
		am.setMarks(Marks);
		AttendanceDAO at = new AttendanceDAO();
		 at.GetMarksData(am);
			RequestDispatcher rd = request.getRequestDispatcher("Attendance.jsp");
			rd.forward(request, response);
		
	}

}
