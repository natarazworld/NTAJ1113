package com.nt.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/testurl")
public class TestServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession ses=null;
        ServletContext sc=null;
        RequestDispatcher rd=null;
		//create diff scope attributes
		//req attribute
        req.setAttribute("attr1","val1");
        //ses attribute
		ses=req.getSession(true);
		ses.setAttribute("attr2", "val2");
		//application attribute
		sc=getServletContext();
		sc.setAttribute("attr3", "val3");
		
		//forward request to jsp page
		rd=req.getRequestDispatcher("/el_test.jsp");
		rd.forward(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
            doGet(req,res);
	}

}
