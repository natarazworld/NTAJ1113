//LcTestServlet.java
package com.nt.servlet;

  import javax.servlet.*;
  import javax.servlet.http.*;
  import java.io.*;

  public class  LcTestServlet extends  HttpServlet
  {
	  static{
		 System.out.println("LcTestServelt:: static block");
	  }
	   public  LcTestServlet(){
           System.out.println("LcTestServelt:: 0-param constructor11");
	   }
	   @Override
	    public void init(ServletConfig cg) throws ServletException {
			System.out.println("LcTestServelt:: 1-param init(-)");
			System.out.println("dbuser init param value ::"+cg.getInitParameter("dbuser"));
			System.out.println("dbpwd init param value ::"+cg.getInitParameter("dbpwd"));
		}
     @Override
		public   void service(ServletRequest req,ServletResponse res)throws ServletException,IOException{
          PrintWriter pw=null;
		 System.out.println("LcTestServlet :: serice(-,-) method");
		//get PrintWriter 
		  pw=res.getWriter();
		  //set response content type
		  res.setContentType("text/html");

		  //write output to response object
		  pw.println("<h1 style='color:red;text-align:center'> Date and time is ::"+new java.util.Date()+"</h1>");
		  //close stream
		   pw.close();
	}
@Override
	 public void destroy(){
        System.out.println("LcTestServlet:: destroy() method");
	 }

    public static void main(String[] args) {
		System.out.println("LcTestServlet.main()");
	}
		
  }