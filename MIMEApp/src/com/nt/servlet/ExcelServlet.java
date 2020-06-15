package com.nt.servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class  ExcelServlet extends HttpServlet
{
	static {
		System.out.println("ExcelServlet::static block ");
	}
	
	public ExcelServlet() {
		System.out.println("ExcelServlet:: 0-param consturctor");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("ExcelServlet::init(-) method");
	}
	
	public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException 
	{
		System.out.println("ExcelServlet.service()");
		PrintWriter pw=res.getWriter();
		res.setContentType("application/vnd.ms-excel");
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
