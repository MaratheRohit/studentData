package com.student.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.dao.StudentDao;
import com.student.model.Student;

@WebServlet("/StudentUpdate")
public class StudentUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 StudentDao dao;
    public StudentUpdate() {
        super();
       
    }

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		       dao = new StudentDao();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
        response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("fname");
		double amount = Double.parseDouble(request.getParameter("amount"));
		
		Student s1 = new Student(id,name,amount);
		int val = dao.updateStudent(s1);
		if(val>=1) {
			System.out.println("update zala");
			RequestDispatcher rd=request.getRequestDispatcher("/DisplayStudent");
			rd.forward(request, response);
		}else {
			System.out.println("Not Update");
		}
	}

}
