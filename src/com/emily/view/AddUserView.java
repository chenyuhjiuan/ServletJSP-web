package com.emily.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddUserView
 */
public class AddUserView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
	/*	out.println("<script typy='text/javascript' language='javascript'> ");

		out.print("function gotoAddUser(){"
				 
				+ "var username=document.forms['myForm']['username'].value; "
				+"if(username==null || username==''){"
				+" var text1 = 'Please input the User Name.' ;"
				+ "document.getElementById('error1').innerHTML =text1;"
				+"return false;} "
				
				+ "var email=document.forms['myForm']['email'].value; "
				+"if(email==null || email==''){"
				+" var text2 = 'Please input the Email.' ;"
				+ "document.getElementById('error2').innerHTML =text2;"
				+" return false;} "
				 
				+ "var grade=document.forms['myForm']['grade'].value; "
				+"if(isNaN(grade) || grade > 5 || !grade || grade <=0){"
				+" var text3 = 'Please input a number less than 5, but not including 0 or negtive number.' ;"
				+ "document.getElementById('error3').innerHTML =text3;"
				+"return false;} "				
				 
				+ "var passwd=document.forms['myForm']['passwd'].value; "
				+"if(passwd==null || passwd==''){"
				+" var text4 = 'Please input the Password.' ;"
				+ "document.getElementById('error4').innerHTML =text4;"
				+"return false;} "
				+"return true;}");
		
		out.println("</script>");*/
		out.println("<script src='js/script.js'></script>");
		out.println("<link rel='stylesheet' href='css/style.css'>");
		out.println("<body style='width:900px;margin:15px auto;'>");
		out.println("<span><img src='imgs/untitled.png' width='900' height='100'/> <a href='MainFrame' id='rtlogin'/>Return back to home page.</a></span>");
		out.println("<h1>Add Users</h1>");
		out.println("<form name='myForm' action='UserClServlet?type=add' onsubmit='return gotoError();' method='post'>");
		out.println("<table border=1px bordercolor='#19A3FF' cellspacing='0' width=300px  >");
 		out.println("<tr><td>User Name</td><td><input type='text' id='username' name='username'></td></tr>");
		out.println("<tr><td>Email</td><td><input type='text' id='email' name='email'></td></tr>");
		out.println("<tr><td>Grade</td><td><input type='text' id='grade' name='grade'></td></tr>");
		out.println("<tr><td>Password</td><td><input type='text' id='passwd' name='passwd'></td></tr></table>");
		out.println("<br/><input type='submit' value='Submit Adding'>&nbsp;&nbsp;&nbsp;<input type='reset' value='Rewrite Input'>");
		out.println("</form>");
		out.println("<p id='error1' style='color:red;'></p>");
		out.println("<p id='error2' style='color:red;'></p>");
		out.println("<p id='error3' style='color:red;'></p>");
		out.println("<p id='error4' style='color:red;'></p>");
		
		out.println("<br/><img src='imgs/images.jpg' width='900' height='80'/><img src='imgs/darkblue11.jpg' width=120px height=80px style='position:absolute;left:590px;'/>");
		out.println("</body>");
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
