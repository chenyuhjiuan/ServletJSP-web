package com.emily.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Err
 */
public class Err extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<link rel='stylesheet' href='css/style.css'>");
		out.println("<body style='width:900px;margin:15px auto;'>");
		out.println("<img src='imgs/untitled.png' width='900' height='100'/>");
		out.println("<a href='ManageUsers' id='rthome'>Return back to Manage User Account.</a> ");
		out.println("<br/><br/><h2>We are sorry for that "+request.getAttribute("info").toString()+"</h2><br/><br/>");
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
