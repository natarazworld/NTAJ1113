package com.nt.basics;
public class Test {
	
	static {
		System.out.println("Test:: static block");
	}
	
	Test(){
		System.out.println("Test:: 0-param constructor");
	}
	
	public  String sayHello(String user) {
		return "hello...."+user;
	}
	
	@Override
	public String toString() {
		   return  "Test ::  ...toString()";
	}

}
