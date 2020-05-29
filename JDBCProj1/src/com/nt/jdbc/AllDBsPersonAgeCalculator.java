package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class AllDBsPersonAgeCalculator {
 private static final String GET_DOB_QUERY="SELECT dob FROM person_date_tab WHERE pid=?";
	public static void main(String[] args) {
		Scanner sc=null;
		int pid=0;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		java.util.Date udob=null,sysDate=null;
		float age=0.0f;
		try {
		 //read inputs
		 sc=new Scanner(System.in);
		 if(sc!=null) {
			 System.out.println("Enter Person Id::");
			 pid=sc.nextInt();
		 }
			/*  //register JDBC driver s/w
			  Class.forName("oracle.jdbc.driver.OracleDriver");
			  //establis the connection
			  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");*/
		 
			/* //register JDBC driver s/w
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 //establis the connection
			 con=DriverManager.getConnection("jdbc:mysql:///ntaj1113db1","root","root");
			*/
		 
		 //register JDBC driver s/w
		 Class.forName("org.postgresql.Driver");
		 //establis the connection
		 con=DriverManager.getConnection("jdbc:postgresql:NTAJ1113DB","postgres","root");
		 
		 
		 
		 
		  //create JDBC PreparedStatement object
		  if(con!=null)
			  ps=con.prepareStatement(GET_DOB_QUERY);
		  //set values to query parmas
		  if(ps!=null)
			  ps.setInt(1,pid);
		  //execute query
		  if(ps!=null)
			  rs=ps.executeQuery();
		  //get DOB and calculate age
		  if(rs!=null) {
			  if(rs.next()) {
				  udob=rs.getDate(1);
				  sysDate=new Date();
				 age=(sysDate.getTime()-udob.getTime())/(1000.0f*60.0f*60.0f*24.0f*365.0f);
				 System.out.println("Age::"+age);
			  }
			  else {
				  System.out.println("record not found");
			  }
		  }//if
		}//try
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//close jdbc objs
			try {
				if(rs!=null)
					rs.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			
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
			
		}//finally

	}//main
}//class
