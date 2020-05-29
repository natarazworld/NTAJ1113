package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PsInsertTest {
  private static final String STUDENT_INSERT_QUERY="INSERT INTO STUDENT VALUES(?,?,?,?)";
  
	public static void main(String[] args) {
		Scanner sc=null;
		int count=0;
		Connection con=null;
		PreparedStatement ps=null;
		int sno=0;
		String sname=null,sadd=null;
		float avg=0.0f;
		int result=0;
		try {
		 //read inputs
		  sc=new Scanner(System.in);
		  if(sc!=null) {
			System.out.println("Enter Students Count::");
			count=sc.nextInt();
		  }
		  //register JDBC driver s/w
		  Class.forName("oracle.jdbc.driver.OracleDriver");
		  //establish the connection
		  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		  //create PreparedStatement object having pre-compiled SQL query
		  if(con!=null)
			 ps=con.prepareStatement(STUDENT_INSERT_QUERY);
		  //read inputs from enduser
		  if(sc!=null && ps!=null) {
			  for(int i=1;i<=count;i++) {
				  //read each student details
				  System.out.println("Enter "+i+" student details");
				  System.out.println("Enter student number::");
				  sno=sc.nextInt();
				  System.out.println("Enter student name::");
				  sname=sc.next();
				  System.out.println("Enter student address::");
				  sadd=sc.next();
				  System.out.println("Enter Student avg");
				  avg=sc.nextFloat();
				  //set each student details to query param values
				  ps.setInt(1,sno);
				  ps.setString(2,sname);
				  ps.setString(3,sadd);
				  ps.setFloat(4,avg);
				  //execute the Query
				  result=ps.executeUpdate();
				  //process the Result
				  if(result==0)
					  System.out.println(i+"student details not inserted");
				  else
					  System.out.println(i+" student details inserted");
			  }//for
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
