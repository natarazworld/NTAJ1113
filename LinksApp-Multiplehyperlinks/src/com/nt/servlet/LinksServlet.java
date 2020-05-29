package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LinksServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("LinksServlet.doGet(-,-)");
		PrintWriter pw=null;
		String pval=null;
		Locale locales[]=null;
		//get PrintWriter 
		pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read addtional req param value (s1)
		pval=req.getParameter("s1");
		///get All available locales
		locales=Locale.getAvailableLocales();
		//differentiate logics for hyperlinks
		if(pval.equalsIgnoreCase("link1")) {  //for languages
			pw.println("<b> all languages </b><br>");
			for(Locale l:locales) {
				pw.println("<b>"+l.getDisplayLanguage()+", </b>");
			}
		}
		else if(pval.equalsIgnoreCase("link2")) {  //for countries
			pw.println("<b> all countries </b><br>");
			for(Locale l:locales) {
				pw.println("<b>"+l.getDisplayCountry()+", </b>");
			}
		}
		else { //for system proeprtioes
			pw.println("<h1> System Properties are </h1>");
			pw.println("<br>"+System.getProperties());
		}
	
		//add hyperlink
		pw.println("<br><a href='links.html'><img src='images/home.png' width='50' height='50'></a>");
		//close stream
		pw.close();
		
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    System.out.println("LinksServlet.doPost(-,-)");
	    doGet(req,res);
	}//doPost(-,-)

}//class
