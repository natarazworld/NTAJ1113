package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteTest {

	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		Statement st=null;
		String city=null;
		ResultSet rs=null;
		String query=null;
		int count=0;
		try {
		 //read inputs
		  sc=new Scanner(System.in);
		  if(sc!=null) {
			  System.out.println("Enter city name::");
			  city=sc.next();
		  }
		  //convert input value as required for the SQL Query
		  city="'"+city+"'"; //gives 'hyd'`
		  
		  //register JDBC driver s/w
		  Class.forName("oracle.jdbc.driver.OracleDriver");
		
		  //establish the connection
		  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "manager");
		  
		  //create Statement object
		  if(con!=null)
			  st=con.createStatement();
		  //prepare SQL query
		      //DELETE FROM STUDENT WHERE SADD='hyd'
		     query="DELETE FROM STUDENT WHERE SADD="+city;
		     System.out.println(query);
		   //send and execute SQL Query in DB s/w
		     if(st!=null) 
		    	count=st.executeUpdate(query);
           //process the Result
		     if(count==0)
		    	 System.out.println("records not found to delete");
		     else
		    	 System.out.println(count+" no.of records are deleted");
			
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
