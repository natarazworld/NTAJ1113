package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/showurl")
public class ShowCookiesServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    PrintWriter pw=null;
	    Cookie  cks[]=null;
	   //get PrintWriter
	    pw=res.getWriter();
	    //set response content  type
	    res.setContentType("text/html");
	    //read all cookies
	    cks=req.getCookies();
	    if(cks!=null) {
	    	pw.println("<table border='1' bgcolor='cyan'>");
	    	for(Cookie ck:cks) {
	    	    	pw.println("<tr><td>"+ck.getName()+"</td><td> "+ck.getValue()+"</td></tr>");
	    	}//for
	    	pw.println("</table>");
	    }//if
	    
	     //close stream 
	    pw.close();
	    
	}//doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    doGet(req,res);
	}//doPost(-,-)
}//class
