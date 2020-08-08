package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/stateurl")
public class StateGstServlet extends HttpServlet {

	public  void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       PrintWriter pw=null;
       float billAmt=0.0f;
       ServletContext sc=null;
       ServletContext  fc=null;
       RequestDispatcher rd=null;
       
		//get PrintWriter
       pw=res.getWriter();
       //set response content type
       res.setContentType("text/html");
       //read form data
       billAmt=Float.parseFloat(req.getParameter("billAmt"));
       // calculate State GST based on state slab
        if(billAmt>50000)
        	pw.println("<br>State GST (10%) is::: "+(billAmt*.1));
        else if(billAmt>30000)
        	pw.println("<br>State GST (8%)is::: "+(billAmt*.08));
        else if(billAmt>15000)
        	pw.println("<br>State GST (6%)is::: "+(billAmt*.06));
        else
        	pw.println("<br>State GST (3%)is::: "+(billAmt*.03));
        
        //include the response from CentralGstServlet comp
              //get ServletContext obj of current web application
                sc=getServletContext();
                //get ServletContext obj of CentralGSTApp  (foreign context)
                fc=sc.getContext("/CentralGSTApp");
                //create RequestDispatcher object pointing to Dest Servlet (CentralGstServlet)
                rd=fc.getRequestDispatcher("/centralurl");
                //include the response
                rd.include(req,res);
                
                //close stream
                pw.close();
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
