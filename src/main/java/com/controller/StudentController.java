package com.controller;

import java.io.IOException;

import com.DAO.AttendanceDAO;
import com.Model.Model;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        int rollNo = Integer.parseInt(request.getParameter("rollNo"));
        AttendanceDAO dao = new AttendanceDAO();

        if ("update".equals(action)) {
            String name = request.getParameter("name");
            int marks = Integer.parseInt(request.getParameter("marks"));
            long phone = Long.parseLong(request.getParameter("phone"));
            String email = request.getParameter("email");

            Model m = new Model();
            m.setRoll_No(rollNo);
            m.setStudent_Name(name);
            m.setAvg_Marks(marks);
            m.setPhone(phone);
            m.setEmail(email);

            if(dao.updateStudent(m)) {
            	RequestDispatcher rd = request.getRequestDispatcher("Attendance.jsp");
    			rd.forward(request, response);
            }
        } else if ("delete".equals(action)) {
            Model m = new Model();
            m.setRoll_No(rollNo);
            if(dao.deleteStudent(m)){
            	RequestDispatcher rd = request.getRequestDispatcher("Attendance.jsp");
    			rd.forward(request, response);
            }
        }

    }

}
