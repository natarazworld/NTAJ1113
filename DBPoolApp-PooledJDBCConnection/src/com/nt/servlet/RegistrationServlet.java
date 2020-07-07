package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/regurl")
public class RegistrationServlet extends HttpServlet {
	private static final String  EMPLOYEE_REGISTRATION="INSERT INTO SERVLET_EMPLOYEE VALUES(ENO_SEQ.NEXTVAL,?,?,?,?)";


	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	     PrintWriter pw=null;
	     String name=null,desg=null, addrs=null;
	     float salary=0.0f;
	     Connection con=null;
	     PreparedStatement ps=null;
	     int count=0;
		//get PrintWriter
	     pw=res.getWriter();
	     //set response content  type
	     res.setContentType("text/html");
	     //read form data
	     name=req.getParameter("ename");
	     desg=req.getParameter("edesg");
	     addrs=req.getParameter("eaddrs");
	     salary=Float.parseFloat(req.getParameter("esalary"));
	     try {
	     //get Pooled jdbc con object
	    	 con=getPooledConnection();
	    	//create Jdbc PreparedStatement object 
	    	 ps=con.prepareStatement(EMPLOYEE_REGISTRATION);
	    	 //set values to query param
	    	 ps.setString(1,name);
	    	 ps.setString(2,addrs);
	    	 ps.setString(3,desg);
	    	 ps.setFloat(4,salary);
	    	 //execute the SQL Query
	    	 count=ps.executeUpdate();
	    	 //process the result
	    	 if(count==0)
	    		 pw.println("<h1 style='color:red;text-align:center'>Employee Registration failed </h1>");
	    	 else
	    		 pw.println("<h1 style='color:green;text-align:center'>Employee Registration Succeded </h1>");
	     }//try
	     catch(SQLException se) {
	    	 pw.println("<h1 style='color:red'>Internal DB problem  </h1>");
	    	 se.printStackTrace();
	     }
	     catch(Exception e) {
	    	 pw.println("<h1 style='color:red'>Unknown  Internal problem  </h1>");
	    	 e.printStackTrace();
	     }
	     finally {
	    	 //close jdbc objs
	    	 try {
	    		 if(ps!=null)
	    			 ps.close();
	    	 }
	    	 catch(SQLException se) {
	    		 se.printStackTrace();
	    	 }
	    	 
	    	 try {
	    		 if(con!=null)
	    			 con.close();
	    	 }
	    	 catch(SQLException se) {
	    		 se.printStackTrace();
	    	 }
	    	 
	     }//finally
	    	 
	    	 // add hyperlink
	     pw.println("<br> <a href='employee_register.html'>home </a>");
	     //close stream
	     pw.close();
		
	}//doGet(-,-)

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//doPost(-,-)
	
	//private method --- which is helper method
	private Connection getPooledConnection()throws Exception{
		InitialContext ic=null;
		DataSource ds=null;
		Connection con=null;
		 //create InitialContext object
		ic=new InitialContext();
		//get DataSource object ref from Jndi registry
		ds=(DataSource) ic.lookup("DsJndi");
		//get Pooled jdbc con  object
		con=ds.getConnection();
		return con;
	}//method

}//class
