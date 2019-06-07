package com.emily.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emily.domain.User;

/**
 * Servlet implementation class UpdateUserView
 */
public class UpdateUserView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//get user object dispatched from the controller
		User user=(User) request.getAttribute("userinfo");
		/*out.println("<script typy='text/javascript' language='javascript'> ");

		out.print("function gotoError(){"
				 
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
		
		//display
		out.println("<script src='js/script.js' ></script>");
		out.println("<link rel='stylesheet' href='css/style.css'>");
		out.println("<body style='width:900px;margin:15px auto;'>");
		out.println("<img src='imgs/untitled.png' width='900' height='100'/>");
		out.println("<span><a href='MainFrame' id='rthome'/>Return back to home page</a>");
		//out.println("<a href='ManageUsers' id='rtUserMC'/>User Manager</a>");
		out.println("<a href='ManageUsers' id='rtUserMC'/>Return back to User Manager</a></span>");
		
		out.println("<h1>Update User Account</h1>");
		out.println("<form name='myForm' action='UserClServlet?type=update' onsubmit='return gotoError();' method='post'>");
		out.println("<table border=1px bordercolor='#19A3FF' cellspacing='0' width=300px  >");
		out.println("<tr><td>ID</td><td><input type='text' name='id' readonly value='"+user.getId()+"' ></td></tr>");
		out.println("<tr><td>User Name</td><td><input type='text' id='username' name='username' value='"+user.getName()+"'></td></tr>");
		out.println("<tr><td>Email</td><td><input type='text' id='email' name='email' value='"+user.getEmail()+"'></td> </tr>");
		out.println("<tr><td>Grade</td><td><input type='text' id='grade' name='grade' value='"+user.getGrade()+"'></td> </tr>");
		out.println("<tr><td>Password</td><td><input type='text' id='passwd' name='passwd' value='"+user.getPwd()+"'></td> </tr></table>");
		out.println("<br/><input type='submit'  value='Submit Update'>&nbsp;&nbsp;&nbsp;<input type='reset' value='Rewrite Input'>");	
		out.println("</form>");
		out.println("<p id='error1' style='color:red;'></p>");
		out.println("<p id='error2' style='color:red;'></p>");
		out.println("<p id='error3' style='color:red;'></p>");
		out.println("<p id='error4' style='color:red;'></p>");
		
		//out.println("<p>" +request.getAttribute("err").toString() +"</p><br/><br/>");
		out.println("<br/><img src='imgs/images.jpg' width='900' height='80'/><img src='imgs/darkblue11.jpg' width=120px height=80px style='position:absolute;left:590px;'/> ");
		out.println("</body>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
