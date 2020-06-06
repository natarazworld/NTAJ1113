package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WelcomeServlet extends HttpServlet {
	
	@Override
	public  void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   System.out.println("WelcomeServlet.service(-,-)");
		PrintWriter pw=null;
		//get PrintWriter
	    pw=res.getWriter();
	    //set response content type
	    res.setContentType("text/html");
	    //show welcome messages
	    pw.println("<marquee><h1 style='color:blue'>Welcome to Naresh IT </h1></marquee>");
	    //close stream
	    pw.close();
	    
	}

}
