package com.emily.service;

import com.emily.domain.User;
import com.emily.util.SqlHelper;

import java.sql.*;
import java.util.ArrayList;

public class UsersService {
	//get pageCount
	public int getpageCount(int pageSize){
		
		String sql="select count(*) from users";
		int rowCount=0;
		
		ResultSet rs=SqlHelper.executeQuery(sql, null);
		try {
			rs.next();
			rowCount=rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			SqlHelper.close(rs, SqlHelper.getPs(), SqlHelper.getCt());
		}
		 
		return (rowCount-1)/pageSize+1;
		 
	}
	 
	//
	public ArrayList getUsersBypage(int pageNow, int pageSize){
		
		ArrayList<User> al=new ArrayList<User>();
		//query sql
		String sql="select * from users limit "+((pageSize*pageNow)-pageSize)+","+pageSize;
		
		ResultSet rs=SqlHelper.executeQuery(sql, null);
		//encapsulation
		try {
			while(rs.next()){
				User u=new User();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setGrade(rs.getInt(4));
				
				al.add(u);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			SqlHelper.close(rs, SqlHelper.getPs(), SqlHelper.getCt());
		}
		
		return al;
	}
	
	//get user's data, UserBean, by id
	public User getUserByid(String id){
		
		User user=new User();
		String sql="select * from users where id=?";
		String parameters[]={id};
		ResultSet rs=SqlHelper.executeQuery(sql, parameters);
		try {
			if(rs.next()){
				
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setGrade(rs.getInt(4));
				user.setPwd(rs.getString(5));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			SqlHelper.close(rs, SqlHelper.getPs(), SqlHelper.getCt());
		}
				
		return user;
	}
	
	
	//update users
	public boolean updateUser(User user){
		boolean b=true;
		String sql="update users set username=?, email=?, grade=?, passwd=? where id=?";
		String parameters[]={user.getName(),user.getEmail(),user.getGrade()+"",user.getPwd(),user.getId()+""};
		
		try{
			SqlHelper.executeUpdate(sql, parameters);
		}catch(Exception e){
			e.printStackTrace();
			b=false;
		}
		return b;
	}
	
	//add users
	
	public boolean addUser(User user){
		boolean b=true;
		String sql="insert into users (username, email, grade, passwd) values (?,?,?,?)";
		String parameters[]={user.getName(), user.getEmail(), user.getGrade()+"", user.getPwd()};
		
		try {
			SqlHelper.executeUpdate(sql, parameters);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			b=false;
		}
		return b;
	}
	
	//delete users
	public boolean delUser(String id){
		boolean b=true;
		String sql="delete from users where id=?";
		String parameters[]={id};
		
		try {
			SqlHelper.executeUpdate(sql, parameters);
		} catch (Exception e) {
			b=false;
		}
		return b;
	}
	
	//Write a method for validating the users id number and password.
	public boolean checkUser(User user)  {
		
		boolean b=false;
		
		//Use SqlHelper class
		String sql="select * from users where id=? and passwd=?";
		String parameters[]={user.getId()+"", user.getPwd()};
		ResultSet rs=SqlHelper.executeQuery(sql, parameters);
		
		//identify the user validity
		try {
			if(rs.next()){
				b=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			SqlHelper.close(rs, SqlHelper.getPs(), SqlHelper.getCt());
		}
		return b;
	}	 
}
