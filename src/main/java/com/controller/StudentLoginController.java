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

@WebServlet("/StudentLoginController")
public class StudentLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int username = Integer.parseInt(request.getParameter("username"));
		Long password = Long.parseLong(request.getParameter("password"));
		String Batch = request.getParameter("Batch");
		Model sm = new Model();
		sm.setUsername(username);
		sm.setPassword(password);
		sm.setBatch(Batch);
		AttendanceDAO at = new AttendanceDAO();
		List<Model> mm = at.studentData(sm);
		request.setAttribute("mm", mm);
		RequestDispatcher rd = request.getRequestDispatcher("Marks.jsp");
		rd.forward(request, response);
	}

}
