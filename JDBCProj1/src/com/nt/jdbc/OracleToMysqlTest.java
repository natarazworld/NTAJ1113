package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleToMysqlTest {
  private static final String MYSQL_STUDENT_INSERT_QUERY="INSERT INTO STUDENT VALUES(?,?,?,?)";
  private static final String  ORACLE_STUDENT_SELECT_QUERY="SELECT SNO,SNAME,SADD,AVG FROM STUDENT";
		  
	public static void main(String[] args) {
		Connection oraCon=null,mysqlCon=null;
		Statement st=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int no=0;
		String name=null;
		String addrs=null;
		float avg=0.0f;
		int count=0;
		boolean flag=false;
		try {
			//Load jdbc driver classes to register with DriverManager Service
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 //Establish the connections
			 oraCon=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "manager");
			 mysqlCon=DriverManager.getConnection("jdbc:mysql:///NTAJ1113DB1","root","root");
			 //create JDBC Statement objects
			 if(oraCon!=null)
				 st=oraCon.createStatement();
			 if(mysqlCon!=null)
				 ps=mysqlCon.prepareStatement(MYSQL_STUDENT_INSERT_QUERY);
			 //execute Select Query on Oracle
			 if(st!=null)
				rs=st.executeQuery(ORACLE_STUDENT_SELECT_QUERY);
			 //process the ResultSet obj and insert records to mysql Db table
			 if(rs!=null && ps!=null) {
				 while(rs.next()) {
					 flag=true;
					 //get Each record from ResultSet obj
					 no=rs.getInt(1);
					 name=rs.getString(2);
					 addrs=rs.getString(3);
					 avg=rs.getFloat(4);
					 //set the above values to INSERT Query param values (mysql)
					 ps.setInt(1,no);
					 ps.setString(2, name);
					 ps.setString(3,addrs);
					 ps.setFloat(4,avg);
					 //execute the Query
					 ps.executeUpdate();
				 }//while
			 }//if
			 if(flag==true)
				 System.out.println("Records copied from Oracle Db table to mysql Db table ");
			 else
				 System.out.println("Records not copied from Oracle Db table to mysql Db table ");
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
				 if(ps!=null)
					 ps.close();
				}
				catch(SQLException se) {
					se.printStackTrace();
				}
			try {
				 if(oraCon!=null)
					 oraCon.close();
				}
				catch(SQLException se) {
					se.printStackTrace();
				}
			try {
				 if(mysqlCon!=null)
					 mysqlCon.close();
				}
				catch(SQLException se) {
					se.printStackTrace();
				}
		}//finally
	}//main
}//class
