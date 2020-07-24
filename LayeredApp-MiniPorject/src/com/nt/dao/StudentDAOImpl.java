package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nt.bo.StudentBO;

public class StudentDAOImpl implements StudentDAO {
	private static final String  DS_JNDI_NAME="java:/comp/env/DsJndi";
	private static final String  INSERT_QUERY="INSERT INTO11 LAYERED_STUDENT VALUES(SNO_SEQ1.NEXTVAL,?,?,?,?,?)";

	@Override
	public int insert(StudentBO bo) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		//get pooled jdbc connection
		con=getPooledJdbcConnection(DS_JNDI_NAME);
		//create PreparedStatement object having SQL Query
		ps=con.prepareStatement(INSERT_QUERY);
		//set values to query params
		ps.setString(1,bo.getSname());
		ps.setString(2,bo.getSadd());
		ps.setInt(3,bo.getTotal());
		ps.setFloat(4,bo.getAvg());
		ps.setString(5,bo.getResult());
		//execute the SQL query
	    count=ps.executeUpdate();
		return count;
	}
	
	 //helper methods..
	private  Connection  getPooledJdbcConnection(String jndi)throws Exception {
		    InitialContext ic=null;
		    DataSource ds=null;
		    Connection con=null;
		    //create InitialContext object
		    ic=new InitialContext();
		    //get DataSource object from jndi registry
		    ds=(DataSource)ic.lookup(jndi);
		    //get Pooled jdbc connection
		    con=ds.getConnection();
		    return con;
	}

}
