package com.nt.listeners;

import java.time.LocalDateTime;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class WebAppMonitoringListener implements ServletContextListener {
	 private long start ,end;
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext sc=null;
	    start=System.currentTimeMillis();
	    //get Servletcontext ob
	    sc=sce.getServletContext();
	    sc.log(sc.getContextPath()+" is deployed/reloaded/restarted at::"+ LocalDateTime.now());
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ServletContext sc=null;
	   end=System.currentTimeMillis();
	    //get Servletcontext ob
	    sc=sce.getServletContext();
	    sc.log(sc.getContextPath()+" is undeployed/stopped/reloaded at::"+ LocalDateTime.now()+" duration::"+(end-start)+" ms");
	   
	}

}
