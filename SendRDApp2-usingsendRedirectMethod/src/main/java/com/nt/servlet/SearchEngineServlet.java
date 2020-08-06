package com.nt.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/searchurl")
public class SearchEngineServlet extends HttpServlet {

       


	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   String ss=null;
	   String engine=null;
	   String url=null;
		 //read form data
	   ss=req.getParameter("ss");
	   engine=req.getParameter("engine");
	    //prepare url
	   if(engine.equalsIgnoreCase("google"))
		    url="https://www.google.com/search?q="+ss;
	   else if(engine.equalsIgnoreCase("bing"))
		   url="https://www.bing.com/search?q="+ss;
	   else if(engine.equalsIgnoreCase("yahoo"))
		     url="https://in.search.yahoo.com/search?p="+ss;
	   else
		   url="https://duckduckgo.com/?q="+ss;
		 //perform sendRedirection
	   res.sendRedirect(url);
	   RequestDispatcher rd=req.getRequestDispatcher("/hello.html");
	   rd.include(req,res);
		
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}

}
