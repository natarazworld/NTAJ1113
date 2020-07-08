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

//@WebServlet(value= {"/test1","/test2","/test3"})
   //@WebServlet(value={"/test1"})
//@WebServlet(value="/test1")
//@WebServlet("/test1")
//@WebServlet( {"/test1","/test2","/test3"})
//@WebServlet(urlPatterns={"/test1","/test2","/test3"})
//@WebServlet(urlPatterns = "/test1",name="test",loadOnStartup = 1)
@WebServlet( value="/test1",name="test",loadOnStartup = 1,
                              initParams = @WebInitParam(name="p1",value="val2222")
                            )
public class TestServlet extends HttpServlet {
	
	public TestServlet() {
	
	System.out.println("TestServlet:: 0-param constructor");	
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("TestServlet.init()");
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    System.out.println("TestServlet.doGet(-,-)");
		PrintWriter pw=null;
	    ServletContext sc=null;
	    ServletConfig cg=null;
		//get PrintWriter 
	    pw=res.getWriter();
	    //set response content type
	    res.setContentType("text/html");
	    //get access to SErvletContext object
	    sc=getServletContext();
	    //get access to SErvletConfig object
	    cg=getServletConfig();
	    pw.println("<br> the logical name of servlet comp ::  "+cg.getServletName());
	    pw.println("<br> the p1 init param value ::"+cg.getInitParameter("p1"));
	    //read form data
		/* pw.println("<br> db user context param value ::"+sc.getInitParameter("dbuser"));
		pw.println("<br> p1 init param vlaue ::"+cg.getInitParameter("p1"));
		pw.println("<br> p1 context param vlaue ::"+sc.getInitParameter("p1"));
		pw.println("<br> ServletContext obj class name::"+sc.getClass());
		pw.println("<br><b> Info  using ServletContext object </b>");
		pw.println("<br>  Server info ::"+sc.getServerInfo());
		pw.println("<br>  Servlet api version ::"+sc.getMajorVersion()+" ."+sc.getMinorVersion());
		pw.println("<br> Context path of web application ::"+sc.getContextPath());
		pw.println("<br> MIME of the search.html::"+sc.getMimeType("/search.html"));
		pw.println("<br> Path of search.html::"+sc.getRealPath("/search.html"));
		pw.println("<br> Path of web application::"+sc.getRealPath("/"));*/
	    
	    
	    
	    
	    
	    

	    //close stream
	    pw.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  doGet(req,res);
	}

}
