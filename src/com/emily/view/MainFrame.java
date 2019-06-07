package com.emily.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emily.domain.User;
import com.test.MyData;

/**
 * Servlet implementation class MainFrame
 */
public class MainFrame extends HttpServlet {
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<link rel='stylesheet' href='css/style.css'>");
		out.println("<body style='width:900px;margin:15px auto;'>");
		out.println("<span><img src='imgs/untitled.png' width='900' height='100'/> <a href='index.html' id='rtlogin'/>Return back to login.</a></span>");
		//get cookie first
				//Assume the last login cookie was established on 2011-11-11 12:12:12
				
				Cookie []cookies=request.getCookies();
				Boolean b=false;

				if(cookies!=null){
				for(Cookie cookie: cookies){
					//get cookie's name
					String name=cookie.getName();
					if("lasttime".equals(name)){
						//display time for the last login cookie
						out.println("<h3>Your last login was on "+cookie.getValue()+".</h3>");
						//update time otherwise it will always be the first time
						//save cookie in current time
						SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						String nowTime=simpleDateFormat.format(new java.util.Date());
						cookie.setValue(nowTime);
						cookie.setMaxAge(7*3600*24);
						response.addCookie(cookie);
						b=true;//means there is a lasttime cookie
						break;
					}
				}
			}
				//if b=false that means there is no lasttime cookie
				if(!b){
					out.println("<h3>Welcome!</h3>");
					//save the current time in cookie
					SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String nowTime=simpleDateFormat.format(new java.util.Date());
					Cookie cookie=new Cookie("lasttime", nowTime);
					cookie.setMaxAge(7*3600*24);//save cookie for one week
					response.addCookie(cookie);
				}
		out.println("<h3>Please choose the task you want to operate.</h3>");
		out.println("<a href='ManageUsers'>Manage User Account</a><br/>");
		out.println("<a href='UserClServlet?type=gotoAddUser'>Add Users </a><br/>");
		//out.println("<a href='#'>Query in User Account</a><br/>");
		out.println("<a href='index.html'>Logout System</a><br/>");
		out.println("<br/><img src='imgs/images.jpg' width='900' height='80'/><img src='imgs/darkblue11.jpg' width=120px height=80px style='position:absolute;left:590px;'/>");
		out.println("</body>");
	}

	 
 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}

