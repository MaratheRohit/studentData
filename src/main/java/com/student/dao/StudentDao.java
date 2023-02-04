package com.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.student.model.Student;
import com.student.util.DBUtility;

public class StudentDao {
  //Insert Block==================================================================
	public  int insertStudent(Student s1)  {
		int val=0;
	try {
		
	Connection con = DBUtility.getDBConnection();
	String sql="insert into  StudentServlet values(?,?,?)";
	PreparedStatement ps=con.prepareStatement(sql);
	ps.setInt(1, s1.getId());
	ps.setString(2, s1.getName());
	ps.setDouble(3, s1.getAmount());
	 val = ps.executeUpdate();
	
	
	}catch(SQLException e) {
		System.out.println(e);
	}
	return val;
	}
	
   //Delete Block Start=================================================================

	public int deleteStudent(Student s1) {
        int del=0;
		try {
			Connection con=DBUtility.getDBConnection();
			String sql = "delete from StudentServlet where id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, s1.getId());
			del =ps.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println(e);
		}
		return del;
	}
	public ResultSet displayStudent() {
		ResultSet rs=null;
		try {
			Connection con=DBUtility.getDBConnection();
			String sql="select * from StudentServlet";
			PreparedStatement ps=con.prepareStatement(sql);
			 rs = ps.executeQuery();
			
			
		}catch(SQLException e) {
			System.out.println(e);
		}
		
		return rs;
	}
	public int updateStudent(Student s1) {
		int val=0;
		try {
		Connection con=DBUtility.getDBConnection();
		String sql="update StudentServlet set name=?,amount=? where id=?";
		
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1, s1.getName());
			ps.setDouble(2, s1.getAmount());
			ps.setInt(3, s1.getId());
			val = ps.executeUpdate();			
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		return val;
		
	}
	public Student display(int id) {
		Connection con = DBUtility.getDBConnection();
		String sql = "select * from StudentServlet where id=?";
		Student s1=null; 
		try {
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				
				int id1 = rs.getInt(1);
				String name= rs.getString(2);
				double amount = rs.getDouble(3);
				s1=new Student(id1,name,amount);
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return s1;
	}

		
	}
	

	
	

