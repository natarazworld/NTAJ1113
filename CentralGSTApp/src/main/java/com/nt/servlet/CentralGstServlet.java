package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/centralurl")
public class CentralGstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    PrintWriter pw=null;
	    float billAmt=0.0f;
		//get PrintWriter
	       pw=res.getWriter();
	       //set response content type
	       res.setContentType("text/html");
	       //read form data
	       billAmt=Float.parseFloat(req.getParameter("billAmt"));
	    // calculate central GST based on central slab
	        if(billAmt>50000)
	        	pw.println("<br>Central GST (8%) is::: "+(billAmt*.08));
	        else if(billAmt>30000)
	        	pw.println("<br>Central GST (6%)is::: "+(billAmt*.06));
	        else if(billAmt>15000)
	        	pw.println("<br>Central GST (2%)is::: "+(billAmt*.02));
	        else
	        	pw.println("<br>Central GST (1%)is::: "+(billAmt*.01));
	        
	        //add hyperlink
	        pw.println("<br><br>");
	        pw.println("<a href='input.html'>Try Again </a>");
	        //do not close stream
	        //pw.close()
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
