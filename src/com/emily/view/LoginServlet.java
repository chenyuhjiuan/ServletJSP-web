package com.emily.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		//response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		String id="";
		//choose keep cookie from cookies
		Cookie cookies[]=request.getCookies();
		if(cookies!=null){
		for(Cookie cookie:cookies){
			if(cookie.getName().equals("id")){
				id=cookie.getValue();
			}
		}
		}
		out.println("<script src='js/script.js'></script>");
		//return a gui needed the html skills
		out.println("<body style='width:900px;margin:15px auto;'>");
		out.println("<img src='imgs/untitled.png' width='900' height='100'/>");
		out.println("<h1>User login</h1><br/>");
		out.println("<p>This is a servlet practice. After login, the functions of delete, insert, update, pagination and data validation can be tested.</p>");
		out.println("<p>(Hint: Try ID of 1 and Password of 123.)</p><br/>");
		//action's path format: /webapp/servlet url. If the action servlet is at the same layer directory with this servlet, then the action path is servlet url.
		out.println("<form name='myForm' action='LoginClServlet' onsubmit='return gotoLogin();' method='post'>");
		out.println("User ID: <input type='text' name='id' value='"+id+"'/><span id='error1' style='color:red;'></span><br/>");
		out.println("Passwor: <input type='password' name='password'/><span id='error2' style='color:red;'></span><br/>");
		out.println("<input type='checkbox' value='keep' name='iskeepinfo'/>Save your user ID in this computer.<br/>");
		out.println("<input type='checkbox' value='nokeep' name='iskeepinfo'/>Don't save your user ID in this computer.<br/>");
		out.println("<input type='submit' value='login'/><br/><br/>");
		out.println("</form>");
		String err=(String)request.getAttribute("err");
		if(err!=null){
		out.println("<font color='red'>"+err+"</font>"); 
		}
		out.println("<img src='imgs/images.jpg' width='900' height='80'/><img src='imgs/darkblue11.jpg' width=120px height=80px style='position:absolute;left:590px;'/>");
		out.println("</body>");
	}

 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
