package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/*CREATE TABLE "SYSTEM"."PERSON_DATE_TAB" 
(	"PID" interger NOT NULL ENABLE, 
	"PNAME" charactervarying ,
	"DOB" DATE, 
	"DOJ" DATE, 
	"DOM" DATE, 
	 CONSTRAINT "PERSON_DATE_TAB_PK" PRIMARY KEY ("PID"))
*/
public class PGDateInsertTest {
 private static final String INSERT_DATE_QUERY="INSERT INTO person_date_tab VALUES(?,?,?,?,?)"; 
 
	public static void main(String[] args) {
		Scanner sc=null;
		int no=0;
		String name=null;
		String dob=null,dom=null,doj=null;
		SimpleDateFormat sdf1=null,sdf2=null;
		java.util.Date udob=null,udoj=null;
		java.sql.Date sqdob=null,sqdom=null,sqdoj=null;
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		try {
			//read inputs
			sc=new Scanner(System.in);
			if(sc!=null) {
				System.out.println("enter person id::");
				no=sc.nextInt();
				System.out.println("Enter person name::");
				name=sc.next();
				System.out.println("Enter DOB(dd-MM-yyyy)::");
				dob=sc.next();
				System.out.println("Enter DOJ(MM-dd-yyyy)");
				doj=sc.next();
				System.out.println("Enter DOM(yyyy-MM-dd)");
				dom=sc.next();
			}//if
			//convert Data values to java.sql.Date class objects
			 //for DOB
			   sdf1=new SimpleDateFormat("dd-MM-yyyy");
			   udob=sdf1.parse(dob);
			   sqdob=new java.sql.Date(udob.getTime());
			 //for DOJ
			   sdf2=new SimpleDateFormat("MM-dd-yyyy");
			   udoj=sdf2.parse(doj);
			   sqdoj=new java.sql.Date(udoj.getTime());
			  //for DOM
			   sqdom=java.sql.Date.valueOf(dom);
			//Load jdbc driver
			   Class.forName("org.postgresql.Driver");
			 //establish the connection
			   con=DriverManager.getConnection("jdbc:postgresql:NTAJ1113DB","postgres","root");
			  //create PReparedStatement object
			   if(con!=null)
				   ps=con.prepareStatement(INSERT_DATE_QUERY);
			   //set query param values
			   if(ps!=null) {
				   ps.setInt(1,no);
				   ps.setString(2,name);
				   ps.setDate(3, sqdob);
				   ps.setDate(4,sqdoj);
				   ps.setDate(5,sqdom);
			   }
			   //execute the SQL query
			   if(ps!=null)
				   count=ps.executeUpdate();
			   
			   //process the results
			    if(count==0)
			    	System.out.println("Record not inserted");
			    else
			    	System.out.println("Record inserted");
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
