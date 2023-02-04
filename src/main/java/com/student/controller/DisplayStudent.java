package com.student.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.dao.StudentDao;




@WebServlet("/DisplayStudent")
public class DisplayStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
   StudentDao dao;
   
    public DisplayStudent() {
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
		
		ResultSet rs=dao.displayStudent();
		
	    out.print("<table border : 2 >");
	    out.print("<th>ID</th>");
	    out.print("<th>Name</th>");
	    out.print("<th>Amount</th>");
	    out.print("<th>Delete</th>");
	    out.print("<th>Update</th>");
		try {
			while(rs.next()){
				out.print("<tr>");
				out.print("<h1><td>"+rs.getInt(1)+"</td></h1>");
				out.print("<h1><td>"+rs.getString(2) +"</td></h1>");
				out.print("<h1><td>"+rs.getDouble(3) +"</td></h1>");
				out.print("<h1><td><a href='DeleteStudent?id="+rs.getInt(1)+"'>"+"DELETE"+"</a></td></h1>");
				out.print("<h1><td><a href='UpdateForm?id="+rs.getInt(1)+"'>"+"Update"+"</a></td></h1>");
				out.print("</tr>");
			}
		} catch (SQLException e) {
			System.out.println(e);
			
		}out.print("</table>");
	}

}
