package com.emily.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 


import com.emily.domain.User;
import com.emily.service.UsersService;

/**
 * Servlet implementation class DelClServlet
 */
public class UserClServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		UsersService usersService=new UsersService();
		//get type value
		String type=request.getParameter("type");
		if("del".equals(type)){
			String id=request.getParameter("id");
			//invoke UsersService to complete deletion.
			if(usersService.delUser(id)){
				//forward ok
				request.setAttribute("info", "Delete successfully!");
				request.getRequestDispatcher("/ok").forward(request, response);
			}else{
				request.setAttribute("info", "Delet fails!");
				request.getRequestDispatcher("/Err").forward(request, response);
			}
		}else if("gotoUpdateView".equals(type)){
			//prepare to update
			//get id first
			String id=request.getParameter("id");
			//get a UserBean by id in UsersService
			User user=usersService.getUserByid(id);
			request.setAttribute("userinfo", user);
			//use request.getRequestDispatcher to guarantee all the servlets use the same request.
			request.getRequestDispatcher("/UpdateUserView").forward(request, response);
			
		}else if("update".equals(type)){
			//get user's update information
			String id =request.getParameter("id");
			String username=request.getParameter("username");
			String email=request.getParameter("email");
			String grade=request.getParameter("grade");
			String passwd=request.getParameter("passwd");
			
			//encapsulate the received message into a User object
			User user= new User(Integer.parseInt(id),username,email, Integer.parseInt(grade), passwd);
			
			//update user information
			if(usersService.updateUser(user)){
				request.setAttribute("info", "Update succeeds!");
				request.getRequestDispatcher("ok").forward(request, response);
			}else{
				request.setAttribute("info", "Update fails!");
				request.getRequestDispatcher("Err").forward(request, response);
			}
			
		}else if("gotoAddUser".equals(type)){
			//For the future extension to have this logic
			request.getRequestDispatcher("AddUserView").forward(request, response);
		}else if("add".equals(type)){
			//get user's added information
			String username=request.getParameter("username");
			String email=request.getParameter("email");
			String grade=request.getParameter("grade");
			String passwd=request.getParameter("passwd");
			//set the above message in User object.
			User user= new User();
			user.setName(username);
			user.setEmail(email);
			user.setGrade(Integer.parseInt(grade));
			user.setPwd(passwd);
			
			if(usersService.addUser(user)){
				request.setAttribute("info", "Adding succeeds!");
				request.getRequestDispatcher("ok").forward(request, response);
			}else{
				request.setAttribute("info", "Adding fails!");
				request.getRequestDispatcher("Err").forward(request, response);
			}
			
		}
 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
