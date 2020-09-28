package com.nt.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class DisplayTag extends TagSupport {
	private String font;
	private int size=20;
	public void setFont(String font) {
		this.font = font;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	@Override
	public int doStartTag() throws JspException {
		JspWriter out=null;
		//get out object
		try {
		out=pageContext.getOut();
		out.println("<span style='font-family:"+font+";font-size:"+size+"px' >");
		}
		catch(IOException ioe) {
			ioe.printStackTrace();
		}
		return EVAL_BODY_INCLUDE;
	}
	
	@Override
	public int doEndTag() throws JspException {
		System.out.println("DisplayTag.doEndTag()");
		JspWriter out=null;
		//get out object
		try {
		out=pageContext.getOut();
		out.print("</span>");
		}//try
		catch(IOException ioe) {
			ioe.printStackTrace();
		}
		return EVAL_PAGE;
	}//doEndTag()
}//class
