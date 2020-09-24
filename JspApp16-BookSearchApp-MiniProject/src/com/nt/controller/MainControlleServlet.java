package com.nt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.BookDTO;
import com.nt.service.BookMgmtServiceImpl;
import com.nt.service.IBookMgmtService;

@WebServlet(value="/controller",loadOnStartup = 1)
public class MainControlleServlet extends HttpServlet {
 private IBookMgmtService service;
 
	public void init() throws ServletException {
		service=new BookMgmtServiceImpl();
	}

	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   String category=null;
	   String source=null;
	   List<BookDTO> listDTO=null;
	   RequestDispatcher rd=null;
		//read form data
	   category=req.getParameter("category").trim();
	   source=req.getParameter("source").trim();
	   try {
	   //use service
	   listDTO=service.searchBooksByCategory(category);
	   //keep listDTO in request scope
	   req.setAttribute("booksInfo",listDTO);  // attr name(String), value(any object)
	   //forwrad to result page
	   if(source.equalsIgnoreCase("html")) {
	       rd=req.getRequestDispatcher("/html_print.jsp");
	       rd.forward(req,res);
	   }
	   else {
		   rd=req.getRequestDispatcher("/excel_download.jsp");
	       rd.forward(req,res);
	   }
	   
	   }//try
	   catch(Exception e) {
		   rd=req.getRequestDispatcher("/error.jsp");
		   rd.forward(req,res);
	   }
		
	
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}
	
	public void destroy() {
		service=null;
	}


}
