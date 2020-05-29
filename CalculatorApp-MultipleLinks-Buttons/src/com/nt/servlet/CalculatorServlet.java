package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculatorServlet extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   PrintWriter pw=null;
	   String pval=null;
	   float val1=0.0f,val2=0.0f;
	   Calendar calendar=null;
		//get PrintWriter
	   pw=res.getWriter();
	   //set response content type
	   res.setContentType("text/html");
	   //read addtional req param value (s1)
	   pval=req.getParameter("s1");
	   //read form data only when hyperlinks are not clicked
	   if(!pval.equalsIgnoreCase("link1") && !pval.equalsIgnoreCase("link2")) {
		   val1=Float.parseFloat(req.getParameter("t1"));
		   val2=Float.parseFloat(req.getParameter("t2"));
	   }
	   else {
		   calendar=Calendar.getInstance();
	   }
		//different logics
	   if(pval.equalsIgnoreCase("add")) {
		   pw.println("<h1 style='color:blue'> Addtion:: "+(val1+val2)+"</h1>");
	   }
	   else if(pval.equalsIgnoreCase("sub")) {
		   pw.println("<h1 style='color:blue'> Subtraction:: "+(val1-val2)+"</h1>");
	   }
	   else if(pval.equalsIgnoreCase("mul")) {
		   pw.println("<h1 style='color:blue'> Multiplication:: "+(val1*val2)+"</h1>");
	   }
	   else if(pval.equalsIgnoreCase("div")) {
		   pw.println("<h1 style='color:blue'> Division:: "+(val1/val2)+"</h1>");
	   }
	   else if(pval.equalsIgnoreCase("link1")) {
		   pw.println("<h1 style='color:red'>Current day in the year:::"+calendar.get(Calendar.DAY_OF_YEAR)+"</h1>");
	   }
	   else {
		   pw.println("<h1 style='color:red'>Current week number in the year:::"+calendar.get(Calendar.WEEK_OF_YEAR)+"</h1>");
	   }
	   
	   //add hyperlink
	     pw.println("<br> <a href='form.html'><img src='images/home.gif' width='100' height='80'/> </a> ");
	   //close the  stream
	     pw.close();
	}
	
	 @Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   doPost(req,res);
	}
	
	

}
