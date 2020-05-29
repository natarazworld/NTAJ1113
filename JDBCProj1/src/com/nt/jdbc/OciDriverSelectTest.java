package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OciDriverSelectTest {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		String query=null;
		ResultSet rs=null;
		boolean flag=false;
		try {
		  //Load jdbc driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
		  //establis the connection
			//con=DriverManager.getConnection("jdbc:oracle:oci8:@xe","system","manager");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			System.out.println("con obj class name::"+con.getClass());
			//create JDBC Statement object
			if(con!=null)
				st=con.createStatement();
			//prepare SQL Query
			query="SELECT SNO,SNAME,SADD,AVG FROM STUDENT";
			//send and execute SQL Query in Db s/w
			if(st!=null)
				rs=st.executeQuery(query);
			//process the ResultSet object
			if(rs!=null) {
				while(rs.next()) {
					flag=true;
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
				}//while
				if(flag==false)
					System.out.println("records not found");
				else
					System.out.println("records found and displayed");
			}//if
		}//try
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(ClassNotFoundException cnf){
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
		}//finally

	}//main
}//class
