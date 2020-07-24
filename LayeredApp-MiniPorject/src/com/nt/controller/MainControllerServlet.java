package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.StudentDTO;
import com.nt.service.StudentMgmtService;
import com.nt.service.StudentMgmtServiceImpl;
import com.nt.vo.StudentVO;

@WebServlet("/controller")
public class MainControllerServlet extends HttpServlet {
	   private StudentMgmtService service;

	public void init() throws ServletException {
		service=new StudentMgmtServiceImpl();
	}

	public void destroy() {
	     service=null;
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		StudentVO vo=null;
		StudentDTO dto=null;
		String result=null;
	   //get PrintWriter
		pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read form data ... and store VO class object
		vo=new StudentVO();
		vo.setSname(req.getParameter("sname"));
		vo.setSadd(req.getParameter("sadd"));
		vo.setM1(req.getParameter("m1"));
		vo.setM2(req.getParameter("m2"));
		vo.setM3(req.getParameter("m3"));
		//convert VO to DTO
		dto=new StudentDTO();
		dto.setSname(vo.getSname());
		dto.setSadd(vo.getSadd());
		dto.setM1(Integer.parseInt(vo.getM1()));
		dto.setM2(Integer.parseInt(vo.getM2()));
		dto.setM3(Integer.parseInt(vo.getM3()));
		//use service
		try {
			result=service.register(dto);
			pw.println("<h1 style='color:green;text-align:center'>"+result+"</h1>");
		}//try
		catch(Exception e) {
			e.printStackTrace();
			pw.println("<h1 style='color:red;text-align:center'>Internal Problem --Try Again </h1>");
		}
		//add hyperlink
		pw.println("<br><br><a href='student_register.html'>home </a>");
		//close stream
		pw.close();
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
