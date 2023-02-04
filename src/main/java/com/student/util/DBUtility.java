package com.student.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtility {
	 static Connection con;
	public static Connection getDBConnection() {
		 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","root");
			
		}catch(SQLException e) {
			System.out.println(e);
		}catch(ClassNotFoundException d) {
			System.out.println(d);
		}
		return con;	 
	}
	
}
