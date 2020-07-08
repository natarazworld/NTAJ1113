package com.nt.filter;

import java.io.IOException;
import java.util.Random;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter({"/employee_register.jsp","/controller"})
public class DoublePostingPreventionFilter extends HttpFilter {
	
	@Override
	public void doFilter(HttpServletRequest req,HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpSession ses=null;
		String method=null;
		int clientToken=0,serverToken=0;
		RequestDispatcher rd=null;
		//get Session
		ses=req.getSession();
		//get request method
		method=req.getMethod();
		if(method.equalsIgnoreCase("GET")) {
			//generate Sessiontoken and make it serverSide token , also make client side token in the form page
			ses.setAttribute("sToken", new Random().nextInt(1000));
			chain.doFilter(req,res);
		}
		else {
			// read server Token ,client Token values..
			clientToken=Integer.parseInt(req.getParameter("cToken"));
			serverToken=(int) ses.getAttribute("sToken");
			System.out.println(clientToken+"      "+serverToken);
			//compare both ServerToken ,clientToken values
			if(clientToken==serverToken) { //if matching
				ses.setAttribute("sToken",new Random().nextInt(10000));
				chain.doFilter(req, res);
			}
			else {  //if not maching
				rd=req.getRequestDispatcher("/error.html");
				rd.forward(req, res);
			}
		}
		
		
	}

}
