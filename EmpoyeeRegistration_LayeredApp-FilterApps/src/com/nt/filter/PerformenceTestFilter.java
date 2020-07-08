package com.nt.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class PerformenceTestFilter extends HttpFilter {
	
	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		long start=0,end=0;
		start=System.currentTimeMillis();
		chain.doFilter(req, res);
		end=System.currentTimeMillis();
		System.out.println(req.getRequestURL()+" request has taken  "+(end-start)+"  ms  to process the request");
	}//doFilter(-,-)
	
}
