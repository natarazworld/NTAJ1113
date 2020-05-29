package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableTest {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		String query=null;
		int count=0;
		try {
			//registrr JDBCDriver s/w
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			//create Statement object
			if(con!=null)
			 st=con.createStatement();
			//prepare SQL Query
			query="create table temp2(col1 number(5))";
			//send and execute SQL query
			 if(st!=null)
				 count=st.executeUpdate(query);
			 //process the result
			 if(count==0)
				 System.out.println("DB table is created");
		}//try
		catch(SQLException se) {
			System.out.println("Db table is not created");
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
		}//finally
	}//main
}//class
