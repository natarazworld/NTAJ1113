package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/surl")
public class SecondServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 PrintWriter pw=null;
		   String name=null,addrs=null,ms=null;
			//get PrintWriter 
		   pw=res.getWriter();
		   //set response content type
		   res.setContentType("text/html");
		   //read form1/req1 data
		   name=req.getParameter("pname");
		   addrs=req.getParameter("paddrs");
		   ms=req.getParameter("ms");
		   //read form2 /req2 data
		   String f2val1=req.getParameter("f2t1");
		   String f2val2=req.getParameter("f2t2");
		   //generate dynamic web page displaying form1/req1 and form2/req2 data
		   pw.println("<h1 style='color:red;text-align:center'> Two froms data </h1>");
		   pw.println("<br>form1/req1 data ::"+name+"...."+addrs+"...."+ms);
		   pw.println("<br>form2/req2 data ::"+f2val1+"...."+f2val2);
		   
		   //add hyperlink
		   pw.println("<br><br> <a href='details.html'>home</a>");
		   
		   //close steam 
		   pw.close();
		   
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}

}
