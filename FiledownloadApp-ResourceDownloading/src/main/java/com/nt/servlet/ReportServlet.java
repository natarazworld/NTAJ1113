package com.nt.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.imageio.stream.FileImageInputStream;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.commons.io.IOUtils;


@WebServlet("/reporturl")
public class ReportServlet extends HttpServlet {
	private static final String  GET_ALL_EMPS_QUERY="SELECT EMPNO,ENAME,EPHOTO,ERESUME FROM FILE_UPLOAD";
	@Resource(name="DsJndi")
	private  DataSource ds;
	
       

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
      String  param=null;
      Connection con=null;
      PreparedStatement ps=null;
      ResultSet rs=null;
      ServletOutputStream sos=null;
      File file=null;
      String filePath=null;
      String mimeType=null;
      InputStream is=null;
      //general settings
      sos=res.getOutputStream();
      res.setContentType("text/html");
      //read additional req param value
      param=req.getParameter("type");
      if(param.equalsIgnoreCase("report")) {
    	    try {
    	    	//get Pooled jdbc con object
    	    	con=ds.getConnection();
    	    	//create PreparedStatment object
    	    	ps=con.prepareStatement(GET_ALL_EMPS_QUERY);
    	    	//execute query 
    	    	rs=ps.executeQuery();
    	    	//process the ResultSEt obj and display report as html table
    	    	sos.println("<table border='1' bgcolor='cyan'>");
    	    	sos.println("<tr><th>EMPNO</th><th>ENAME</th> <th>EMPPHOTO</th> <th>EMPRESUME</th> </tr> ");
    	    	while(rs.next()) {
    	    		sos.println("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td><a href='reporturl?type=download&path="+rs.getString(3)+"'>download </a></td><td><a href='reporturl?type=download&path="+rs.getString(4)+"'>download</a></td></tr>");
    	    	}
    	    	sos.println("</table>");
    	       }//try
    	      catch(SQLException se) {
    	    	  se.printStackTrace();
    	    	  sos.println("<h1> internal problem try again </h1>");
    	      }
    	    catch(Exception e) {
    	    	e.printStackTrace();
    	  	  sos.println("<h1> internal problem try again </h1>");
    	    }
    	    finally {
    	    	//close jdbc objs
    	    	try {
    	    		if(rs!=null)
    	    			rs.close();
    	    	}
    	    	catch(SQLException se) {
    	    		se.printStackTrace();
    	    		sos.println("<h1> internal problem try again </h1>");
    	    }
    	    	
    	    	try {
    	    		if(ps!=null)
    	    			ps.close();
    	    	}
    	    	catch(SQLException se) {
    	    		se.printStackTrace();
    	    		sos.println("<h1> internal problem try again </h1>");
    	    }
    	    	
    	    	try {
    	    		if(con!=null)
    	    			con.close();
    	    	}
    	    	catch(SQLException se) {
    	    		se.printStackTrace();
    	    		sos.println("<h1> internal problem try again </h1>");
    	    	}
    	    }//finally
      }//if
      else {   //downloading
    	  //get File location from hyperlink as addtional req param value\
    	  filePath=req.getParameter("path");
    	  //create java.io.File class object
    	  file=new File(filePath);
    	  //get the length of the file and make it response length
    	  res.setContentLengthLong(file.length());
    	  //get MIME of the file and make it as  response content type
    	  mimeType=getServletContext().getMimeType(filePath);
    	  res.setContentType(mimeType!=null?mimeType:"application/octet-stream");
    	  //create InputSteam pointing to the file
    	  is=new FileInputStream(file);
    	  // set value to Content-Disposition response header
    	  res.addHeader("Content-Disposition","attachment;filename="+file.getName());
    	  // copy File content to response object
    	  IOUtils.copy(is,sos);
    	  //close streams
    	  is.close();
    	  sos.close();
      }
		
	}//doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
