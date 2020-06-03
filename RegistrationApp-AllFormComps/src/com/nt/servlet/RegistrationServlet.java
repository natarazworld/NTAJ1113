package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	     PrintWriter pw=null;
	     String name=null,addrs=null,gender=null,ms=null,qlfy=null, crs[]=null,hb[]=null,fbUrl=null;
	    String dob=null,dobLocal=null,month=null,time=null,week=null,email=null,color=null,searchWords=null;
	     int age=0,favNo=0,pin=0,salaryRange=0;
	    long phone=0L;
	    
		//get PrintWrtier 
	     pw=res.getWriter();
	     //set response content type
	     res.setContentType("text/html");
	     //read form data
	     name=req.getParameter("name");
	     age=Integer.parseInt(req.getParameter("age"));
	     gender=req.getParameter("gender");
	     ms=req.getParameter("ms");
	     if(ms==null)
	    	 ms="single";
	     addrs=req.getParameter("addrs");
	     phone=Long.parseLong(req.getParameter("phone"));
	     crs=req.getParameterValues("crs");
	     if(crs==null)
	    	 crs=new String[] {"no courses"};
	     hb=req.getParameterValues("hb");
	     if(hb==null)
	    	 hb=new String[] {"no hobies"};
	     qlfy=req.getParameter("qlfy");
	     fbUrl=req.getParameter("fbUrl");
	     dob=req.getParameter("dob");
	     dobLocal=req.getParameter("dobLocal");
	     time=req.getParameter("time");
	     month=req.getParameter("month");
	     week=req.getParameter("week");
	     email=req.getParameter("email");
	     salaryRange=Integer.parseInt(req.getParameter("salary"));
	     favNo=Integer.parseInt(req.getParameter("favNo"));
	     color=req.getParameter("color");
	     searchWords=req.getParameter("searchwords");
	     pin=Integer.parseInt(req.getParameter("pin"));
	     //write b.logic
	     if(gender.equalsIgnoreCase("M")) {
	    	 if(age<=5)
	    		  pw.println("<h1 style='color:pink'>Master."+name +"   u  r  baby boy </h1>");
	    	 else if(age<=12)
	    		 pw.println("<h1 style='color:cyan'>Master."+name +"   u  r  small boy </h1>");
	    	 else if(age<=19)
	    		 pw.println("<h1 style='color:blue'>Mr."+name +"   u  r  teenage boy </h1>");
	    	 else if(age<=35)
	    		 pw.println("<h1 style='color:red'>Mr."+name +"   u  r  young man </h1>");
	    	 else if(age<=50)
	    		 pw.println("<h1 style='color:green'>Mr."+name +"   u  r  middle-aged man </h1>");
	    	 else
	    		 pw.println("<h1 style='color:maroon'>Mr."+name +"   u  r  Budda </h1>");
	     }
	     else {
	    	 if(age<=5)
	    		  pw.println("<h1 style='color:pink'>Master."+name +"   u  r  baby girl </h1>");
	    	 else if(age<=12)
	    		 pw.println("<h1 style='color:cyan'>Master."+name +"   u  r  small girl </h1>");
	    	 else if(age<=19) {
	    		if(ms.equalsIgnoreCase("married"))
	    		       pw.println("<h1 style='color:blue'>Mrs."+name +"   u  r  teenage girl </h1>");
	    	     else
	    	         pw.println("<h1 style='color:blue'>Miss."+name +"   u  r  teenage girl </h1>");
	    	     	 }
	    	 else if(age<=35) {
	    		 if(ms.equalsIgnoreCase("married"))
	    		       pw.println("<h1 style='color:red'>Mrs."+name +"   u  r  young woman </h1>");
	    	     else
	    	         pw.println("<h1 style='color:red'>Miss."+name +"   u  r  young woman  </h1>");
	    	 }
	    		 else if(age<=50) {
	    			 if(ms.equalsIgnoreCase("married"))
		    		       pw.println("<h1 style='color:green'>Mrs."+name +"   u  r  middle-aged woman </h1>");
		    	     else
		    	         pw.println("<h1 style='color:green'>Miss."+name +"   u  r  middle-aged woman </h1>");
	    		 }
	    		 else {
	    			 if(ms.equalsIgnoreCase("married"))
		    		       pw.println("<h1 style='color:maroon'>Mrs."+name +"   u  r  old woman </h1>");
		    	     else
		    	         pw.println("<h1 style='color:maroon'>Miss."+name +"   u  r  old woman </h1>");
	    		 }
	     }
	     
	     pw.println("<br><br> <h1> displaying form data </h1>");
	      pw.println("<br><b> name :::"+name+"</b>");
	      pw.println("<br><b> age :::"+age+"</b>");
	      pw.println("<br><b> address :::"+addrs+"</b>");
	      pw.println("<br><b> gender :::"+gender+"</b>"); 
	      pw.println("<br><b> phone :::"+phone+"</b>");
	      pw.println("<br><b> marital status :::"+ms+"</b>");
	      pw.println("<br><b> Qualification :::"+qlfy+"</b>");
	      pw.println("<br><b> Courses :::"+Arrays.toString(crs)+"</b>"); 
	      pw.println("<br><b> hobies :::"+Arrays.toString(hb)+"</b>");
	      pw.println("<br><b> Favorite color :::"+color+"</b>");
	      pw.println("<br><b> Favourite number :::"+favNo+"</b>");
	      pw.println("<br><b> dob :::"+dob+"</b>"); 
	      pw.println("<br><b> dob-local :::"+dobLocal+"</b>");
	      pw.println("<br><b> DOB time :::"+time+"</b>");
	      pw.println("<br><b> week :::"+week+"</b>");
	      pw.println("<br><b> month :::"+month+"</b>"); 
	      pw.println("<br><b> PIN :::"+pin+"</b>");
	      pw.println("<br><b> email :::"+email+"</b>");
	      pw.println("<br><b> salary :::"+salaryRange+"</b>");
	      pw.println("<br><b> Search String :::"+searchWords+"</b>");
	      pw.println("<br><b> fbUrl :::"+fbUrl+"</b>");
	      // add hyperlink
	      pw.println("<br><br> <a href='register.html'>home </a>");
	     
	     //close stream
	      pw.close();
		
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   doGet(req,res);
	}//doGet(-,-)

}//class
