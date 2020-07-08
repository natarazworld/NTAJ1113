package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nt.bo.EmployeeBO;

public class EmployeeDAOImpl implements EmployeeDAO {
	private static final String  INSERT_EMPLOYEE_QUERY="INSERT INTO LAYERED_EMPLOYEE VALUES(EMPNO_SEQ.NEXTVAL,?,?,?,?,?,?)";
	
	//helper methods
	private Connection  getPooledJdbcConnection()throws Exception{
		InitialContext ic=null;
		DataSource ds=null;
		Connection con=null;
		//create InitialContext object
		ic=new InitialContext();
		//get DataSource object
		ds=(DataSource)ic.lookup("java:/comp/env/DsJndi");
		//get Pooled JDBC con object
		con=ds.getConnection();
		return con;
		
	}//method
	

	@Override
	public int insert(EmployeeBO bo) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
	    //get Pooled jdbc con object
		con=getPooledJdbcConnection();
		//create PreparedStatement object
		ps=con.prepareStatement(INSERT_EMPLOYEE_QUERY);
		//set values to query params
		ps.setString(1,bo.getEname() );
		ps.setString(2,bo.getEadd());
		ps.setDate(3,bo.getDoj());
		ps.setFloat(4, bo.getBasicSalary());
		ps.setFloat(5,bo.getGrossSalary());
		ps.setFloat(6, bo.getNetSalary());
		//execute the SQL Query
		count=ps.executeUpdate();
		//close jdbc objs
		ps.close();
		con.close();
		return count;
	}

}
