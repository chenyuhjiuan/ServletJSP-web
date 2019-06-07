package com.emily.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emily.domain.User;
import com.emily.service.UsersService;

/**
 * Servlet implementation class ManageUsers
 */
public class ManageUsers extends HttpServlet {
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script typy='text/javascript' language='javascript'> ");

		out.print("function gotoPageNow(){"
				+ "var pageNow=document.getElementById('pageNow').value; "
				+"if(isNaN(pageNow) || pageNow > pageCount() || !pageNow || pageNow <=0){"
				+" var text = 'Please input a number less than '+ pageCount()+', but not including 0 or negtive number.' ;"
				+ "document.getElementById('error').innerHTML =text;"
				+"}else { pageNow=document.getElementById('pageNow');"
				+"window.open('ManageUsers?pageNow='+pageNow.value,'_self');}}"
				
				+ "function confirmOper(){return window.confirm('Are you sure you want to delete it?');}");
		
		out.println("</script>");
		out.println("<link rel='stylesheet' href='css/style.css'>");
		out.println("<body style='width:900px;margin:15px auto;'  >");
		out.println("<img src='imgs/untitled.png' width='900' height='100'/>");
		out.println("<a href='MainFrame' id='rthome'/>Return back to home page.</a>");
		out.println("<a href='index.html' id='logout'/>Log out</a>");
		out.println("<h1>Manage User Account</h1>");
		 
 
		
		//define the needed amount of pagination
		int pageNow=1;//the current page
		int pageCount=0;
		//get user's pageNow
		String sPageNow=request.getParameter("pageNow");
		if(sPageNow!=null){
		pageNow=Integer.parseInt(sPageNow);
		}
		
		int pageSize=3;//defining 3 records per page
 
		
		try{
			 
			UsersService usersService=new UsersService();
			pageCount= usersService.getpageCount(pageSize);

			String spageCount = Integer.toString(pageCount);
			out.println("<script type='text/javascript' >");
			out.println("function pageCount(){ var pageCount = "+spageCount+";");
			out.println("return pageCount; }</script>");
			
			ArrayList<User> al=usersService.getUsersBypage(pageNow, pageSize);
			
			out.println("<table  border='1' bordercolor='#19A3FF' cellspacing='0' width=600px height=110px>");
			out.println("<tr><th>User ID</th><th>User Name</th><th>Email</th><th>Grade</th><th>Delete Users</th><th>Update Users</th></tr>");
			for(User u:al){
				
				out.println("<tr><td>"+u.getId()+
						"</td><td>"+u.getName()+
						"</td><td>"+u.getEmail()+
						"</td><td>"+u.getGrade()+
						"</td><td><a onclick='return confirmOper();' href='UserClServlet?type=del&id="+u.getId()+"'>delete </a></td>"
								+ "<td><a href='UserClServlet?type=gotoUpdateView&id="+u.getId()+"'>update</a></td></tr>");
			}
				out.println("</table><br/>");
			//display pre page
				if(pageNow!=1){
				out.println("<a href='ManageUsers?pageNow="+(pageNow-1)+"'>pre</a>&nbsp;&nbsp;");
				}
				
			//display current page
			for(int i=1;i<=pageCount;i++){
				out.println("<a href='ManageUsers?pageNow="+i+"'><"+i+"></a>");
			}
			
			//display next page
			if(pageNow!=pageCount){
				out.println("&nbsp;&nbsp;<a href='ManageUsers?pageNow="+(pageNow+1)+"'>next</a>");
			}
			
			//display the message of pagination
				out.println("&nbsp;&nbsp;&nbsp;current page <span class='pgnow'>"+pageNow+"</span>/"+pageCount+" total pages<br/><br/>" );
			//jump to input page
				out.println("Jump to page&nbsp;<input type='text' id='pageNow' name='pageNow' /> <input type='button' onClick='gotoPageNow()'  value='Submit' /> <br/>");
				out.println("<p id='error' style='color:red;'></p>");
		}catch (Exception e){
			
		} 
		out.println("<br/><img src='imgs/images.jpg' width='900' height='80'/><img src='imgs/darkblue11.jpg' width=120px height=80px style='position:absolute;left:590px;'/> ");
		out.println("</body>");
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
