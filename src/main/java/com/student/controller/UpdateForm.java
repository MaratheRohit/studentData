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


@WebServlet("/UpdateForm")
public class UpdateForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
  StudentDao dao;
    public UpdateForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		   dao = new StudentDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("id"));
		    
		 Student s1=dao.display(id);
		
		out.print("<form action='StudentUpdate' method='get'>"
				+ "<h1>Update Form</h1>"
				+ "<input type='text' name='id' value='"+s1.getId()+"'readonly><br>"
				+"<input type='text' name='fname'  value='"+s1.getName()+"'><br>"
				+"<input type='text' name='amount' value='"+s1.getAmount()+"'>"
				+ "<input type= 'submit' value='submit'></form>");


	}
}
