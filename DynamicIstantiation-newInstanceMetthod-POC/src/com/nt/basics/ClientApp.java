package com.nt.basics;

import java.util.Date;

public class ClientApp {

	public static void main(String[] args) {
	    Class c=null;
	    Object obj=null;
	    try {
		//Load the class
	    c=Class.forName(args[0]);
	    //go for instantiation
	    obj=c.newInstance();
	    System.out.println(obj.toString());
	    Test t1=(Test)obj;
	    System.out.println(t1.sayHello("Raja"));
	    
	    Date d=new Date();
	    System.out.println("date and time is ::"+d);
	    }//try
	    catch(ClassNotFoundException cnf) {
	    	cnf.printStackTrace();
	    }
	    catch(InstantiationException iae) {
	    	iae.printStackTrace();
	    }
	    catch(Exception e) {
	    	e.printStackTrace();
	    }
		

	}

}
