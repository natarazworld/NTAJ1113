<%@page import="java.sql.*"%>

<%!private Connection con;
	private PreparedStatement ps1 = null, ps2 = null;
	private ResultSet rs=null;

	public void jspInit() {
		ServletConfig cg = null;
		String driver = null, url = null, dbuser = null, dbpwd = null;

		try {
			//get access ServletConfig object
			cg = getServletConfig();
			//read init param values from web.xml file
			driver = cg.getInitParameter("driver");
			url = cg.getInitParameter("url");
			dbuser = cg.getInitParameter("dbuser");
			dbpwd = cg.getInitParameter("dbpwd");
			//load  jdbc driver class
			Class.forName(driver);
			//establish the connection
			con = DriverManager.getConnection(url, dbuser, dbpwd);
			//create PreparedStatement objs
			ps1 = con.prepareStatement("INSERT INTO JSP_BANK_ACCOUNT VALUES(JSP_ACNO_SEQ.NEXTVAL,?,?,?)");
			ps2 = con.prepareStatement("SELECT ACNO,HOLDERNAME,ADDRESS,BALANCE FROM JSP_BANK_ACCOUNT");
		} //try
		catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}//jspInit()%>


 <%

     //read special request param(type) value
     String type=request.getParameter("type");
     if(type.equalsIgnoreCase("Submit")){
    	 //read form data
    	 String name=request.getParameter("holder");
    	 String addrs=request.getParameter("addrs");
    	 float balance=Float.parseFloat(request.getParameter("initialBalance"));
    	 //set values to query params
    	  ps1.setString(1,name);
    	 ps1.setString(2,addrs);
    	 ps1.setFloat(3,balance);
    	 //execute the SQL query
    	  int count=ps1.executeUpdate();
    	 //process the results
    	 if(count==1){  %>
    	        <h1 style="color:green;text-align:center">Account opended successfully</h1>
    	 <% }//if
    	 else{  %>
    		 <h1 style="color:red;text-align:center">Account not opened</h1>
    	<% }//else
     }//if
     else{    //for hyperlink
    	 //execute query
    	 rs=ps2.executeQuery();  %>
    	   <table border="1"  align="center" bgcolor="cyan">
    	      <tr><th>acno </th> <th> holder name</th><th>Address</th> <th>Balance </th> </tr>
    	   <%
    		//process the ResultSet
    		while(rs.next()){   %>
    			  <tr><td><%=rs.getInt(1) %> </td> <td><%=rs.getString(2) %> </td> <td><%=rs.getString(3) %> </td><td><%=rs.getFloat(4) %> </td> </tr>
  <%	}//whle
    	 %>
    	 </table>
     <%} //else
 %>

<br>
<a style="text-align: center" href="form.html">home</a>


<%!public void jspDestroy() {
		//close jdbc objs
		try {
			if (rs!= null)
				rs.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
		
		try {
			if (ps1 != null)
				ps1.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
		try {
			if (ps2 != null)
				ps2.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
		
		try {
			if (con != null)
				con.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}

	}//jspDestory()%>
