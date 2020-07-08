package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
//jdbc api
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*@WebServlet(value="/dburl",loadOnStartup = 1,initParams = {@WebInitParam(name = "driver",value="oracle.jdbc.driver.OracleDriver"),
	                                                                                                                      @WebInitParam(name = "url",value="jdbc:oracle:thin:@localhost:1521:xe"),
	                                                                                                                    @WebInitParam(name = "dbuser",value="system"),
	                                                                                                                   @WebInitParam(name = "dbpwd",value="manager")
	 
                                                                                                                          })*/


public class EmployeeSearchServlet extends HttpServlet
{   private static final String GET_EMP_DETAILS_BY_NO="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE EMPNO=?";

       public  void  doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		    PrintWriter pw=null;
			int eno=0;
			Connection con=null;
			PreparedStatement ps=null;
			ResultSet rs=null;
			ServletContext sc=null;
			String driver=null,url=null,dbuser=null,dbpwd=null;
			Enumeration e1=null;
			ServletConfig cg=null;
			try{
            //get PrintWriter object
			pw=res.getWriter();
			 //set content Type object
			 res.setContentType("text/html");
			 //read form data
			 eno=Integer.parseInt(req.getParameter("eno"));
			 //get Access to ServletContext object
			 sc=getServletContext();
			 //read init pararam values from web.xml using servletConfig obj
			 driver=sc.getInitParameter("driver");
			 url=sc.getInitParameter("url");
			 dbuser=sc.getInitParameter("dbuser");
			 dbpwd=sc.getInitParameter("dbpwd");
			 // Load jdbc driver class  to activate jdbc driver s/w
			  Class.forName(driver);
			  //establish the connection
			  con=DriverManager.getConnection(url,dbuser,dbpwd);
              //create PreparedStatemenet  object
			  ps=con.prepareStatement(GET_EMP_DETAILS_BY_NO);
			  //set query parameter vlaues
			  ps.setInt(1,eno);
			  //execute the SQL  Query
                  rs=ps.executeQuery();
				  //process the ResultSet object
				  if(rs.next()){
                      pw.println("<table border='1'  align='center' bgcolor='pink'>");
					  pw.println("<tr bgcolor='red'><th>EmpNo</th><th>EmpName</th><th>EmpDesg</th><th>Emp Salary</th><th>EmpDeptno</th></tr>");
					  pw.println("<tr bgcolor='yellow'><td>"+rs.getInt(1)+"</td> <td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getFloat(4)+"</td><td>"+rs.getInt(5)+"</td></tr>");
                      pw.println("</table>");
                      
				/*     pw.println("<br> To get  servlet logical  name::"+cg.getServletName());
				     pw.println("<br> Servlet Config object classname::"+cg.getClass());
				     
				     pw.println("<br> all init param names and values </br>");
				     e1=cg.getInitParameterNames();
				     while(e1.hasMoreElements()) {
				   	  //get key 
				   	  String name=(String)e1.nextElement();
				   	  //gey values
				   	  String val=cg.getInitParameter(name);
				   	  pw.println("<br>"+name+"......."+val);
				     }*/
                      //get Access to Servletconfig object
                      cg=getServletConfig();
                      pw.println("<br> p1 init param vlaue ::"+cg.getInitParameter("p1"));
                      
          		  }
				  else{
                      pw.println("<h1 style='color:red;text-align:center'> No Employee Found </h1>");
				  }
				  //add hyerlink
				  pw.println("<br> <a href='search.html'><h1 style='color:red;text-align:center'> home </h1> </a>");
			}//try
			catch(Exception e){
                  e.printStackTrace();
				    pw.println("<h1 style='color:red;text-align:center'> Internal Problem Try-Again</h1>");
					pw.println("<br> <a href='search.html'><h1 style='color:red;text-align:center'> home </h1> </a>");
			}
			finally{
				//close jdbc objs
				try{
					 if(rs!=null)
						 rs.close();
				}
				catch(SQLException se){
					se.printStackTrace();
				}

				try{
					 if(ps!=null)
						 ps.close();
				}
				catch(SQLException se){
					se.printStackTrace();
				}

				try{
					 if(con!=null)
						 con.close();
				}
				catch(SQLException se){
					se.printStackTrace();
				}

				try{
					 if(pw!=null)
						 pw.close();
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}//finally
	   }//doGet(-,-)

	    public  void  doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
              doGet(req,res);
		}//doPost(-,-)

}//class