package com.controller;

import java.io.IOException;
import java.util.List;

import com.DAO.AttendanceDAO;
import com.Model.Model;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DataController")
public class DataController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	boolean Status = false;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String Batch = request.getParameter("Batch");
		AttendanceDAO at = new AttendanceDAO();
		Model m = new Model();
		m.setBatch(Batch);
		List<Model> mm = at.Students_Data(m);
		request.setAttribute("mm", mm);
		Status = true;
		if (Status) {
			RequestDispatcher rd = request.getRequestDispatcher("Students_Data.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("Attendance.jsp");
			rd.forward(request, response);
		}
	}

}
