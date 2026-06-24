package com.controller;

import java.io.IOException;
import java.util.List;
import com.DAO.AttendanceDAO;
import com.Model.AttendanceModel;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AttendanceController")
public class AttendanceController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String Batch = request.getParameter("Batch");
		String Roll_No = request.getParameter("Roll_No");
		String Date = request.getParameter("Date");
		AttendanceModel am = new AttendanceModel();
		am.setBatch(Batch);
		am.setDate(Date);
		am.setRoll_No(Roll_No);
		AttendanceDAO at = new AttendanceDAO();
		List<AttendanceModel> al = at.Attendance(am);
		request.setAttribute("al", al);
			RequestDispatcher rd = request.getRequestDispatcher("Attendance.jsp");
			rd.forward(request, response);
		
			

	}
}
