package com.test;

import java.sql.*;
 

public class Jdbc {
	public static void main(String[] args){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection myConn=DriverManager.getConnection("jdbc:mysql://localhost:3306/usermanager", "root", "ilovejune1");
			
			System.out.println("MySQL database gets connection.");
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
