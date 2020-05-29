package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateTest {

	public static void main(String[] args) {
		Scanner sc=null;
		int no=0;
		String newAddrs=null;
		float newAvg=0.0f;
		Connection con=null;
		Statement st=null;
		String query=null;
		int count=0;
		try {
			//read inputs
			sc=new Scanner(System.in);
			if(sc!=null) {
				System.out.println("enter existing student number::");
				no=sc.nextInt(); //gives 678
				System.out.println("Enter new addrs of the student::");
				       sc.nextLine();
				newAddrs=sc.nextLine(); //navi hyd
				System.out.println("Enter new Avg of the student");
				newAvg=sc.nextFloat(); //56.77
			}
			  //convert input value as required for SQL Query
			 newAddrs="'"+newAddrs+"'";
			//register JDBc driver s/w
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			 //establish the connection
			 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			 //create JDBC Statement object
			 if(con!=null)
				 st=con.createStatement();
			 //prepare SQL Query
			     //update student set sadd='navi hyd', avg=78.55 where sno=678
		   	  query="UPDATE STUDENT SET SADD="+newAddrs+", AVG="+newAvg+" WHERE SNO="+no;
		   	  System.out.println(query);
			 //send and execute SQL Query in Db s/w
		   	  if(st!=null)
		   		  count=st.executeUpdate(query);
		   	  //process the result
		   	  if(count==0)
		   		  System.out.println("Record not found for updation");
		   	  else
		   		System.out.println("Record  updated");
		}//try
		catch(SQLException se) {
			if(se.getErrorCode()==12899)
				System.out.println("Value is too Large for the column");
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
