package com.nt.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class RequestDurationFinderListener implements ServletRequestListener {
    private long start,end;
	  @Override
	public void requestInitialized(ServletRequestEvent sre) {
		  //start time
		    start=System.currentTimeMillis();
	}
	  
	  @Override
	public void requestDestroyed(ServletRequestEvent sre) {
		  HttpServletRequest hreq=null;
		  ServletContext sc=null;
		 //get HttpServletRequst object
		  hreq=(HttpServletRequest) sre.getServletRequest();
		  //end time
		  end=System.currentTimeMillis();
		  //get Servletcontext obj
		  sc=hreq.getServletContext();
		  sc.log(hreq.getRequestURI()+"  based web comp has taken  "+(end-start)+"   ms to process the request");
		  	 
	}
	
}
