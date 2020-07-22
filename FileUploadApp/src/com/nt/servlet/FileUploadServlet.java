package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadFile;


@WebServlet("/uploadurl")
public class FileUploadServlet extends HttpServlet {
	private  static final String  EMP_INSERT_QUERY="INSERT INTO FILE_UPLOAD  VALUES(ENO_SEQ.NEXTVAL,?,?,?)";
 @Resource(name="DsJndi")
   private  DataSource ds;	


	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  PrintWriter  pw=null;
	  MultipartFormDataRequest nreq=null;
	  String name=null;
	  UploadBean uplBean=null;
	Hashtable  map=null;
	String fname1=null,fname2=null;
	Connection con=null;
	PreparedStatement ps=null;
	ServletContext sc=null;
	int count=0;
	Enumeration< UploadFile> e=null;
	
		// get PrintWriter
	  pw=res.getWriter();
	  //set response content type
	  res.setContentType("text/html");
	  try {
	  // Create Special Request object
	  nreq=new MultipartFormDataRequest(req);
	  //read text based form data..
	  name=nreq.getParameter("ename");
	  //create FileUploading settings
	  uplBean=new UploadBean();
	  uplBean.setFolderstore("c:/store");
	  uplBean.setOverwrite(false);
	  //To keep  restrictions
	  uplBean.setFilesizelimit(100*1024);
	  uplBean.setMaxfiles(20);
	  uplBean.setBlacklist("*.html");
	  //perform file uploading..
	  uplBean.store(nreq, "ephoto");
	  uplBean.store(nreq, "eresume");
	  //get the name of the uploaded file..
	     map= nreq.getFiles();
	   fname1=((UploadFile) map.get("ephoto")).getFileName();
	  fname2=((UploadFile)map.get("eresume")).getFileName();
	  //get ServletContext obj
	  sc=getServletContext();
	  //write jdbc code...
	      	  //get Pooled connection
	  con=ds.getConnection();
	  //create PreparedStement ohject having query
	  ps=con.prepareStatement(EMP_INSERT_QUERY);
	  //set values to query param
	   ps.setString(1,name);
	   ps.setString(2,sc.getInitParameter("UPLOAD_LOC")+fname1);
	   ps.setString(3,sc.getInitParameter("UPLOAD_LOC")+fname2);
	   //execute the query
	  count=ps.executeUpdate();
	  //process the result.... and display the names of the upload files..
	  if(count==0) {
		  pw.println("<h1 style='color:red;text-align:center'>Problem in file uploading </h1>");
	  }
	  else {
		  pw.println("<h1 style='color:red;text-align:center'>File uploading Successful </h1>");
		 e=map.elements();
		 while(e.hasMoreElements()) {
			 UploadFile file=e.nextElement();
			 pw.println("<br>"+file.getFileName()+"---->"+file.getFileSize()+" --->"+file.getContentType());
		 }//while
	  }//else
	 }//try
	  catch(SQLException se) {
		  se.printStackTrace();
	  }
	  catch(Exception ex) {
		  pw.println("<h1 style='color:red;text-align:center'>invalid size ,type , count</h1>");
		  ex.printStackTrace();
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
		  
		  //home huperlink
		  pw.println("<br> <a href='upload.html'> home </a>");
		  
		  try {
			  if(pw!=null)
				  pw.close();
		  }
		  catch(Exception ex) {
			  ex.printStackTrace();
		  }
	  }
	
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
