package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateTest1 {

	public static void main(String[] args) {
		Scanner sc=null;
		String city1=null,city2=null;
		Connection con=null;
		Statement st=null;
		String query=null;
		int count=0;
		try {
		 //read inputs
			sc=new Scanner(System.in);
		  if(sc!=null) {
			  System.out.println("enter city1:");
			  city1=sc.next(); //vizag
			  System.out.println("Enter city2:");
			  city2=sc.next(); //delhi
		  }
		  //convert input values as required for the SQL Query
		  city1="'"+city1+"'"; //gives 'vizag'
		  city2="'"+city2+"'"; //gives 'delhi'
		  
		  //establish the connection
		  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		  //create JDBC STatement object
		  if(con!=null)
			  st=con.createStatement();
		  //prepare SQL Query
		  //update student set avg=avg+(avg*0.1) where sadd in('hyd','vizag')
		    query="UPDATE STUDENT SET AVG=AVG+(AVG*0.1) WHERE SADD IN("+city1+","+city2+")";
		     System.out.println(query);
          //send and execute SQL Query
		     if(st!=null)
		    	count=st.executeUpdate(query);
           //process the reuslt
		     if(count==0)
		    	 System.out.println("records not found for updation");
		     else
		    	 System.out.println(count+" no.of records are updated");
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
