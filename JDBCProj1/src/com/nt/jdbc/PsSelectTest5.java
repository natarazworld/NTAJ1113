package com.nt.jdbc;

/* App to get Emp Details who is having highest salary
 * 
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PsSelectTest5 {
  private static final String EMP_SELECT_QUERY="SELECT EMPNO,ENAME,JOB,SAL FROM EMP";
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement ps=null;
		String query=null;
		ResultSet rs=null;
		try {
			//Load jdbc driver class
		  Class.forName("oracle.jdbc.driver.OracleDriver");
		  //establish the connection
		  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "manager");
		  //create JDBC Statement object
		  if(con!=null)
			  ps=con.prepareStatement(EMP_SELECT_QUERY);
		  //set query param values
			/* if(ps!=null) {
			  ps.setString(1,"SELECT");
			  ps.setString(2, "EMP");
			 }
			 */
		   //send and execute SQL Query in Db s/w
		   if(ps!=null)
			   rs=ps.executeQuery();
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
		}//finally
	}//main
}//class
