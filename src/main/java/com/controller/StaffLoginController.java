package com.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/StaffLoginController")
public class StaffLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StaffLoginController() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (username.equalsIgnoreCase("vcubejava") && password.equals("Java@5")) {
			RequestDispatcher rd = request.getRequestDispatcher("Attendance.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("StaffLogin.jsp");
			rd.forward(request, response);
		}
		doPost(request, response);
	}

}
