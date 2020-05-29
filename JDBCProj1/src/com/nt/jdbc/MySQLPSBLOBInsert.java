package com.nt.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class MySQLPSBLOBInsert {
  private static final String INSERT_BLOB_QUERY="INSERT INTO CINEMA_ARTIST VALUES(?,?,?,?)";
	public static void main(String[] args) {
		Scanner sc=null;
		int arstId=0;
		String arstName=null,arstAddrs=null,photoPath=null;
		Connection con=null;
		PreparedStatement ps=null;
		File file=null;
		long length=0;
		InputStream is=null;
		int count=0;
		
		try {
		 //read inputs
			sc=new Scanner(System.in);
			if(sc!=null) {
				System.out.println("Enter Artist ID:");
				arstId=sc.nextInt();
				System.out.println("Enter ArtistName::");
				arstName=sc.next();
				System.out.println("Enter Artis Addrs");
				arstAddrs=sc.next();
				System.out.println("Enter Photo Path");
				photoPath=sc.next();
			}
			
			// Locate the file
			file=new File(photoPath);
			//get the length of the file
			if(file!=null)
				length=file.length();
			//create InputStream pointing to Photo file
			if(file!=null)
				is=new FileInputStream(file);
				
			
			
			//register JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//establish the connection
			con=DriverManager.getConnection("jdbc:mysql:///NTAJ1113DB1", "root", "root");
			
			//create Jdbc PreparedStatement object
			if(con!=null)
				ps=con.prepareStatement(INSERT_BLOB_QUERY);
			//set values to query params
			if(ps!=null && is!=null) {
				ps.setInt(1,arstId);
				ps.setString(2,arstName);
				ps.setString(3,arstAddrs);
				//ps.setBinaryStream(4,is,length);
				ps.setBinaryStream(4,is);
			}
			//execute the query
			if(ps!=null)
				count=ps.executeUpdate();
			
			//process the result
			if(count==0)
				System.out.println("Record not inserted");
			else
				System.out.println("Record inserted");
				
			
		}//try
		catch(ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
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
			try {
				if(sc!=null)
					sc.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			try {
				if(is!=null)
					is.close();
			}
			catch(IOException ioe) {
				ioe.printStackTrace();
			}
		}//finally

	}//main
}//class
