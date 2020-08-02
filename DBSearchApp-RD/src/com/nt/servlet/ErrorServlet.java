package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(value="/errorurl",name="err")
public class ErrorServlet extends HttpServlet {
	
	
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  System.out.println("ErrorServlet.doGet(-,-)");
		PrintWriter pw=null;
	    ServletContext sc=null;
	    ServletConfig cg=null;
		//get PrintWriter 
	    pw=res.getWriter();
	    //set response content type
	    res.setContentType("text/html");
	    
	    //write error message
	    pw.println("<h1 style='color:red;text-align:center'>Internal Problem --Try again</h1>");
	   
	    pw.println("<br><a href='search.html'>home</a>");
	 
	    //close stream
	   // pw.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  doGet(req,res);
	}

}
