package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DropTableTest {

	public static void main(String[] args) {
		Scanner sc=null;
		String tabName=null;
		Connection con=null;
		Statement st=null;
		int count=0;
		try {
		  //read inputs
			sc=new Scanner(System.in);
			System.out.println("Enter table name::");
			tabName=sc.next();
          //register JDBC driver s/w
			Class.forName("oracle.jdbc.driver.OracleDriver");
		  //establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		  //create STatement object
			if(con!=null)
				st=con.createStatement();
		  //send and execute SQL Query in Db s/w
			if(st!=null)
				count=st.executeUpdate("DROP TABLE "+tabName);
			//process the Result
			if(count==0)
				System.out.println("DB table is dropped");
				
		}//try
		catch(SQLException se) {
			System.out.println("DB table not found");
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
