package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/createurl")
public class CreateCookiesServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    PrintWriter pw=null; 
	    Cookie ck1=null,ck2=null,ck3=null,ck4=null;;	    
		//get PrintWriter
	    pw=res.getWriter();
	    //set response content  type
	    res.setContentType("text/html");
	    //create InMemory cookies
	    ck1=new Cookie("TS","hyd");
	    ck2=new Cookie("mh","mumbai");
	    res.addCookie(ck1); res.addCookie(ck2);
	  //create PEsistent cookies
	    ck3=new Cookie("Ladak","leh");
	    ck4=new Cookie("up","luknow");
	    ck3.setMaxAge(120); ck4.setMaxAge(60);
	    res.addCookie(ck3); res.addCookie(ck4);
	    pw.println("<h1 style='color:red;text-align:center'>Cookies are created </h1>");
	    //close stream 
	    pw.close();
	    
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    doGet(req,res);
	}

}
