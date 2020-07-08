package com.nt.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class TimeCheckFilter extends HttpFilter {
	
	static {
		System.out.println("TimeCheckFilter:: static block");
	}
	public TimeCheckFilter() {
		System.out.println("TimeCheckFilter:: 0-param constructor");
	}
	
	@Override
	public void init(FilterConfig config) throws ServletException {
	  System.out.println("TimeCheckFilter.init()");
	}
	
	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		Calendar calendar=null;
		int hour=0;
		PrintWriter pw=null;
		//get PrintWriter
		pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		System.out.println("TimeCheckFilter.doFilter()");
		//get System  date
	     calendar=Calendar.getInstance();
	     //get current hour of the day
	     hour=calendar.get(Calendar.HOUR_OF_DAY);
	     if(hour<9 || hour>17) {
	    	 pw.println("<h1 style='color:red;text-align:center'> Request must not be given before 9am and after 5pm</h1> ");
	    	 return;
	     }
	     else {
	    	 System.out.println("TimeCheckFilter.doFilter() (before)");
	    	 chain.doFilter(req, res);
	    	 System.out.println("TimeCheckFilter.doFilter() (after)");
	     }
	     
	}//doFilter(-,-)
	
	@Override
	public void destroy() {
	  System.out.println("TimeCheckFilter.destroy()");
	}

}
