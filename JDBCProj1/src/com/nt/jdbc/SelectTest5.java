package com.nt.jdbc;

/* App to get Emp Details who is having highest salary
 * 
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SelectTest5 {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		String query=null;
		ResultSet rs=null;
		try {
			//Load jdbc driver class
		  Class.forName("oracle.jdbc.driver.OracleDriver");
		  //establish the connection
		  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "manager");
		  //create JDBC Statement object
		  if(con!=null)
			  st=con.createStatement();
		  //prepare SQL Query
		   query="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE SAL=(SELECT MAX(SAL) FROM EMP)";
		   //send and execute SQL Query in Db s/w
		   if(st!=null)
			   rs=st.executeQuery(query);
		   //process the ResultSet object
		   if(rs!=null) {
			   while(rs.next()) {
				 System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+"  "+rs.getFloat(4));  
			   }//while
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
