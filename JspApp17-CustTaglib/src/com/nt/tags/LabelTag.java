package com.nt.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class LabelTag extends  TagSupport{
	private String msg="welcome to NIT";

	public void setMsg(String msg) {   // variable name or xxx word of setXxx(-) must match with  attribute name (msg)
		this.msg = msg;
	}

	@Override
	public int doStartTag() throws JspException {
		System.out.println("LabelTag.doStartTag()");
		JspWriter out=null;
		//get Out object
		out=pageContext.getOut();
		//write message browser
		try {
		out.print("<h1 style='color:red'>"+msg+"</h1>");
		}
		catch(IOException ioe) {
			ioe.printStackTrace();
		}
	   return SKIP_BODY;
	}
	
	@Override
	public int doEndTag() throws JspException {
	     System.out.println("LabelTag.doEndTag()");
	     return EVAL_PAGE;
	}
	

}
