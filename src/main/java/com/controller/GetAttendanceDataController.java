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

@WebServlet("/GetAttendanceDataController")
public class GetAttendanceDataController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Batch = request.getParameter("Batch");
		String Date = request.getParameter("Date");
		AttendanceModel am = new AttendanceModel();
		am.setBatch(Batch);
		am.setDate(Date);
		AttendanceDAO at = new AttendanceDAO();
		List<AttendanceModel> a = at.GetAttendance(am);
		request.setAttribute("a", a);
			RequestDispatcher rdd = request.getRequestDispatcher("AttendanceData.jsp");
			rdd.forward(request, response);
	}

}
