package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/s2url")
public class Servlet2 extends HttpServlet {

	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        RequestDispatcher rd=null;
        PrintWriter pw=null;
		
        //read and display req attribute values
        pw=res.getWriter();
        //set response content type
        res.setContentType("text/html");
        //read and display req attrtibue values
        pw.println("<b>(Servlet1) req attribute(attr1) value ::"+req.getAttribute("attr1")+"</b>");
        
		//forward the request
		 rd=req.getRequestDispatcher("/s3url");
		 rd.forward(req,res);
		
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
