package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MarriageServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("MarriageServlet:: doPost(-,-) method");
		PrintWriter pw = null;
		String name = null, gender = null, tage = null;
		int age = 0;
		List<String> errsList = null;
		String vstatus = null;
		// get PrintWriter
		pw = res.getWriter();
		/// set response content type
		res.setContentType("text/html");
		// read form data... (req param values)
		name = req.getParameter("pname");
		tage = req.getParameter("page");
		gender = req.getParameter("gender");

		// read vflag req param value to know wheather client side form validations are
		// done or not done
		vstatus = req.getParameter("vflag");

		// enable server side form validations only when client side form validations
		// are not done
		if (vstatus.equalsIgnoreCase("no")) {

			// write form validation logic server side
			System.out.println("MarriageServlet:: server side form valiation logic");
			errsList = new ArrayList();

			if (name == null || name.length() == 0 || name.equals("")) { // required rule
				errsList.add(" Person name is required");

			} else if (name.length() < 5 || name.length() > 15) { // min,max length rule
				errsList.add(" Person name must have min 0f 5 chars and max of 15 chars");

			}

			if (tage == null || tage.equals("") || tage.length() == 0) {
				errsList.add(" Person age is required");

			} else {
				try {
					age = Integer.parseInt(tage);
					if (age < 1 || age > 125) {
						errsList.add("Person age must  be 1 throguh 125 required");
					}
				} catch (NumberFormatException nfe) {
					errsList.add("Person age must be numeric value");
				}
			}
			// display form validation error messages
			if (errsList.size() != 0) {
				pw.println("<ul>");
				for (String msg : errsList) {
					pw.println("<li style='color:red'>" + msg + "</li>");
				}

				pw.print("</ul>");
				return;
			}
		} // if
		else {
			age=Integer.parseInt(tage);
		}

		// write b.logic or request processing logic
		System.out.println("b.logic execution.....");
		if (gender.equalsIgnoreCase("M")) {
			if (age >= 21) {
				pw.println("<h1 style='color:green;text-align:center'> Mr." + name
						+ " your are elgible for Marriage </h1>");
			} // if
			else {
				pw.println("<h1 style='color:red;text-align:center'> Mr." + name
						+ " your are not elgible for Marriage </h1>");
			} // else
		} // if
		else if (gender.equalsIgnoreCase("F")) {
			if (age >= 18) {
				pw.println("<h1 style='color:green;text-align:center'> Miss." + name
						+ " your are  elgible for Marriage </h1>");
			} // if
			else {
				pw.println("<h1 style='color:red;text-align:center'> Miss." + name
						+ " your  are not elgible for Marriage </h1>");
			} // else
		} // else if
		else {
			pw.println("<h1 style='color:red;text-align:center'> Unknown Gender </h1>");
		}

		pw.println("<br> <b>date and  time" + new Date() + "</b> <br>");
		/// add graphical hyperlink
		pw.println("<br> <a href='input.html'><img src='images/home.jpg' width='50' height='50'/> </a>");

		// close stream
		pw.close();

	}// method

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("MarriageServlet.doGet(-,-)");
		PrintWriter pw = null;
		// get PrintWriter
		pw = res.getWriter();
		res.setContentType("text/html");
		// write b.logic
		pw.println("<h1 style='color:red;text-align:center'>Date and time :::" + new Date() + "</h1>");

		/// add graphical hyperlink
		pw.println("<br> <a href='input.html'><img src='images/home.jpg' width='50' height='50'/> </a>");
		// close stream
		pw.close();

	}

}// class
