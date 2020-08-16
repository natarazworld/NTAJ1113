package com.nt.listeners;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionDurationAnalyzerListener implements HttpSessionListener {
    private  long start,end;
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		ServletContext sc=null;
		//get ServletContext obj
	    sc=se.getSession().getServletContext();	
	   //write log message
	    sc.log("session started at::"+new Date());
	    //start time
	     start=System.currentTimeMillis();
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		ServletContext sc=null;
		//get ServletContext obj
	    sc=se.getSession().getServletContext();	
	    //end ime
	    end=System.currentTimeMillis();
	    //write log message
	    sc.log("session ended at::"+new Date());
	    sc.log("Session duration is::"+(end-start)+" ms");
	}

}
