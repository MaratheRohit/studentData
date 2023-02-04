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

@WebServlet("/DeleteStudent")
public class DeleteStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
    StudentDao dao;
    public DeleteStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		dao = new StudentDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int id =Integer.parseInt(request.getParameter("id"));
		Student s1=new Student(id);
		int del=dao.deleteStudent(s1);
		if(del>=1) {
			
			out.print("<br> <h1>Delete Succefully</h1>"
					+ "<input type='button'> ");
			RequestDispatcher rd=request.getRequestDispatcher("/DisplayStudent");
			rd.forward(request, response);
		}else {
			out.print("Not Delete");
		}
		
		
	
		
	}

}
