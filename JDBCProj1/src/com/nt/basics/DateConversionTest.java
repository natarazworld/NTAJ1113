package com.nt.basics;

import java.text.SimpleDateFormat;

public class DateConversionTest {

	public static void main(String[] args)throws Exception {
		String d1="37-17-2040"; //dd-MM-yyyy
		//converting String date value to java.util.Date class object
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date ud1=sdf.parse(d1);
		System.out.println("util date::"+ud1);
		//converting java.util.Date class obj to java.sql.Date class object
		long ms=ud1.getTime();
		System.out.println(ms);
		java.sql.Date sd1=new java.sql.Date(ms);
		System.out.println("sql date::"+sd1);
		
		//Converting  String date value directly to
		 //java.sql.Date class obj with out converting it to
		//java.util.Date class object but String date vlaue
		//must be there in yyyy-MM-dd pattern.
		  String d2="2010-12-23"; //yyyy-MM-dd
		  java.sql.Date sd2=java.sql.Date.valueOf(d2);
		  System.out.println(sd2);
		 
		  java.util.Date sysDate=new java.util.Date();
		  java.sql.Date sqSysDate=new java.sql.Date(sysDate.getTime());
		  System.out.println(sysDate+"  "+sqSysDate);
		  
		  //converting java.sql.Date class obj to java.util.Date class obj
		  java.util.Date ud2=sd2;
		  System.out.println("util date::"+ud2);
		  //converting java.util.Date class obj to String date value
		  SimpleDateFormat sdf2=new SimpleDateFormat("MMM-yyyy-dd");
		  String d3=sdf2.format(ud2);
		  System.out.println("string date::"+d3);
		  
		  

	}//main
}//class
