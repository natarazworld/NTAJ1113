package com.nt.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.sql.*;  //jdbc api

 @WebServlet("/dburl")
public class EmployeeSearchServlet extends HttpServlet
{   private static final String GET_EMP_DETAILS_BY_NO="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE EMPNO=?";

       public  void  doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		    PrintWriter pw=null;
			int eno=0;
			Connection con=null;
			PreparedStatement ps=null;
			ResultSet rs=null;
			try{
            //get PrintWriter object
			pw=res.getWriter();
			 //set content Type object
			 res.setContentType("text/html");
			 //read form data
			 eno=Integer.parseInt(req.getParameter("eno"));
			 // Load jdbc driver class  to activate jdbc driver s/w
			  Class.forName("oracle.jdbc.driver.OracleDriver");
			  //establish the connection
			  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
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