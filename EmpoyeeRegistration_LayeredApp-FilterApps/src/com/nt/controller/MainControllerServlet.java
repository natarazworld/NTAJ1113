package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeMgmtService;
import com.nt.service.EmployeeMgtServiceImpl;
import com.nt.vo.EmployeeVO;

@WebServlet("/controller")
public class MainControllerServlet extends HttpServlet {
	private EmployeeMgmtService service;
	@Override
	public void init() throws ServletException {
		System.out.println("MainControllerServlet.init()");
		service=new EmployeeMgtServiceImpl();
	}
    
   
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("MainControllerServlet.doGet()");
		 EmployeeVO vo=null;
		 PrintWriter pw=null;
		 EmployeeDTO dto=null;
		 String result=null;
		 ServletContext sc=null;
		 
		//read form dataa  and store in VO class object
		 vo=new EmployeeVO();
		 vo.setEname(req.getParameter("ename"));
		 vo.setEadd(req.getParameter("eadd"));
		 vo.setDoj(req.getParameter("doj"));
		 System.out.println(req.getParameter("doj"));
		 vo.setBasicSalary(req.getParameter("basicSalary"));
		 //create PrintWriter 
		 pw=res.getWriter();
		 //set response content type
		 res.setContentType("text/html");
		 //convert VO class object DTO class object
		 dto=new EmployeeDTO();
		 dto.setEname(vo.getEname());
		 dto.setEadd(vo.getEadd());
		 dto.setBasicSalary(Float.parseFloat(vo.getBasicSalary()));
		 dto.setDoj(java.sql.Date.valueOf(vo.getDoj()));
		 //use service class
		 try {
			 result=service.registerEmployee(dto);
			 pw.println("<h1 style='color:red;text-align:center'>Result :: "+result+"</h1>");
		 }//try
		 catch(Exception e) {
			 pw.println("<h1>Internal Problem ---- Try Again</h1>");
			 e.printStackTrace();
		 }
		//add hyperlink
		 pw.println("<br><br> <a href='employee_register.jsp'>home</a>");
		 //get Access to SErvletContext object
		 sc=getServletContext();
		 pw.println("<br><br>  req count:::"+sc.getAttribute("reqCount"));
		 //close stream
		 pw.close();
		
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("MainControllerServlet.doPost()");
		doGet(req,res);
	}
	
	
	@Override
	public void destroy() {
		System.out.println("MainControllerServlet.destroy()");
	service=null;
	}

}
