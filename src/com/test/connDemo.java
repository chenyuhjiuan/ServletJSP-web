package com.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

		import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class connDemo
 */
public class connDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		 
			 
				
				Connection myConn = null;
				
				try{
					
					Properties props = new Properties();
					props.load(getServletContext().getResourceAsStream("/WEB-INF/dbinfo.properties"));
					props.load(new FileInputStream("dbinfo.properties"));
					
					String driver=props.getProperty("driver");
					String url=props.getProperty("url");
					String username=props.getProperty("username");
					String password=props.getProperty("password");
					
					myConn=DriverManager.getConnection(url, username, password);
					
					System.out.println("MySQL database connection is successful.");
				} catch(Exception e){
					e.printStackTrace();
				}
				
			
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	 

}
