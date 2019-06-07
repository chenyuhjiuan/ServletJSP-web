package com.emily.controller;

import java.io.*;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emily.domain.User;
 
import com.emily.service.UsersService;
import com.test.*;
 
public class LoginClServlet extends HttpServlet {
		//private static final long serialVersionUID = 1L;
	 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 		
	 	//to solve the character issue
	 	request.setCharacterEncoding("utf-8");	
	 	/*This controller servlet doesn't response to browser, there is no need to have the following code for response.
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter(); */

	 	//to receive the user name and password from the submission
	 	String id = request.getParameter("id");
		String password = request.getParameter("password");
		String val=request.getParameter("iskeepinfo");
		//if user want to save ID in this computer
		if(val!=null&&val.equals("keep")){
			
			//create cookie and save it into the user log-in computer
			Cookie cookie= new Cookie("id",id);
			cookie.setMaxAge(7*2*24*3600);//save cookie for two weeks
			response.addCookie(cookie);
			
		} else if(val!=null&&val.equals("nokeep")){
			//get cookie first and then delete it
			Cookie cookies[]=request.getCookies();
			for(Cookie cookie: cookies){
				//get the id cookie
				if(cookie.getName().equals("id")){
					//delete the id cookie
					cookie.setMaxAge(0);
					response.addCookie(cookie);//must add otherwise can't be deleted successfully
				}
				
			}
		}

		//Create a UsersService object to complete the validation in database.
		UsersService usersService = new UsersService();
		User user=new User();
		user.setId(Integer.parseInt(id));
		user.setPwd(password);
		
		//Process the forwarding according to the validation result.
		if(usersService.checkUser(user)){
			request.getRequestDispatcher("/MainFrame").forward(request, response);
		} else{
				request.setAttribute("err", "ID or password is invalid.");
				request.getRequestDispatcher("index.html").forward(request, response);
		}
		
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}

