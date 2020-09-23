package com.nt.utility;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBConnectionUtil {
	
	public  static   Connection  getPooledConnection()throws Exception {
		InitialContext ic=null;
		DataSource ds=null;
		Connection con=null;
		// create InitialContext object
		ic=new InitialContext();
		//get DataSource object ref from underlying server jndi registry
		ds=(DataSource)ic.lookup("java:/comp/env/DsJndi");
		//get jdbc pooled connection
		con=ds.getConnection();
		return con;
	}

}
