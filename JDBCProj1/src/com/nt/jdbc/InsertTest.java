package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertTest {

	public static void main(String[] args) {
		Scanner sc=null;
		int no=0;
		String name=null;
		String addrs=null;
		float avg=0.0f;
		Connection con=null;
		Statement st=null;
		String query=null;
		int count=0;
		try {
		 //read inputs
			sc=new Scanner(System.in);
		  if(sc!=null) {
			System.out.println("Enter student number::");
			no=sc.nextInt(); //gives 8901
			System.out.println("Enter student name::");
			name=sc.next(); //gives raja
			System.out.println("Enter student address::");
			addrs=sc.next(); //gives hyd
			System.out.println("Enter Student avg::");
			avg=sc.nextFloat(); //gives 89.55
		  }
		  //convert input values as required for the SQL Query
		  name="'"+name+"'"; //gives 'raja'
		  addrs="'"+addrs+"'"; //gives 'hyd'
		  
		   //Load jdbc driver class 
		  Class.forName("oracle.jdbc.driver.OracleDriver");
		  //establish the connection
		  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		  //create JDBC Statement object
		   if(con!=null)
			   st=con.createStatement();
		   //prepare SQL query
		   //insert into student values(8901,'ramesh','vizag',67.87)
             query="INSERT INTO STUDENT VALUES("+no+","+name+","+addrs+","+avg+")";
             System.out.println(query);
             //send and execute SQL Query
             if(st!=null)
            	count=st.executeUpdate(query);
             //process the Result
             if(count==1)
            	 System.out.println("Record inserted");
		}//try
		catch(SQLException se) {
			System.out.println("Record not inserted");
			if(se.getErrorCode()==1)
				System.out.println("student having this student number is already registered");
			else if(se.getErrorCode()==12899)
				System.out.println("Value too large for the column");
			else
				System.out.println("unknown db problem");
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
				if(st!=null)
					st.close();
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
