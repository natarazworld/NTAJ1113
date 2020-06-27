package com.nt.servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class  HtmlServlet extends HttpServlet
{
	
	static {
		System.out.println("HtmlServlet::static block ");
	}
	
	public HtmlServlet() {
		System.out.println("HtmlServlet:: 0-param consturctor");
	}
	
	
	/*	@Override
		public void init() throws ServletException {
		 System.out.println("HtmlServlet.init() no parameter method");
		 ServletConfig cg=getServletConfig();
		 System.out.println(cg.getInitParameter("p1")+" from init() method");
		}*/
	
	//private ServletConfig cg;
	@Override
	public void init(ServletConfig cg) throws ServletException {
		//this.cg=cg;
		//super.init(cg);
		System.out.println("HtmlServlet::init(-) method");
		System.out.println("p1 init param value ::"+cg.getInitParameter("p1"));
	}
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException 
	{
		System.out.println("HtmlServlet::doPost(-,-)");
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		pw.println("<table align='center' border='1' bgcolor='cyan'>");
		pw.println("<tr><th>Country</th><th>President/Prime Minister</th></tr>");
		pw.println("<tr><td>India</td><td>President/Prime Minister</td></tr>");
		pw.println("<tr><td>Pakistan</td><td>Imran Khan</td></tr>");
		pw.println("<tr><td>USA</td><td>Trumph</td></tr>");
		pw.println("<tr><td>China</td><td>Xi-Xing Ping</td></tr>");
		pw.println("</table>");
		pw.close();
	}
}
