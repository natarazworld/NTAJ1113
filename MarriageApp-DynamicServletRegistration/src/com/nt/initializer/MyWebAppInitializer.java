package com.nt.initializer;

import java.util.Set;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import com.nt.servlet.MarriageServlet;

public class MyWebAppInitializer implements ServletContainerInitializer {
	
	static {
		System.out.println("MyWebAppInitializer.static block");
	}
	
	public MyWebAppInitializer() {
		System.out.println("MyWebAppInitializer:: 0-param constructor");
	}

	@Override
	public void onStartup(Set<Class<?>> set, ServletContext sc) throws ServletException {
		MarriageServlet servlet=null;
		ServletRegistration.Dynamic dyna=null;
		System.out.println("MyWebAppInitializer.onStartup(-,-)");
		 //create our servlt class object
		servlet=new MarriageServlet();
		//register Servlet comp
		dyna=sc.addServlet("ms",servlet);
		// map with url /url pattern
		dyna.addMapping("/marriageurl");
		//enable load-on-servlet
		dyna.setLoadOnStartup(1);
	}

}
