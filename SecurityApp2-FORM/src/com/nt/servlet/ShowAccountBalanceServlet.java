package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/accounturl")
public class ShowAccountBalanceServlet extends HttpServlet {
		public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			 PrintWriter pw=null;
			//get PrintWriter 
			 pw=res.getWriter();
			 //set response content type
			 res.setContentType("text/html");
			 pw.println("<h1 style='color:green;text-align:center'> Account Balnace is :::"+new Random().nextInt(100000000)+"</h1>");
			 //add hyperlink
			 pw.println("<a href='index.html'>home</a>");
			 //close stream
			 pw.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
