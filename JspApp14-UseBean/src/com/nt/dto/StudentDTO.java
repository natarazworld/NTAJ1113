package com.nt.dto;

import java.io.Serializable;

public class StudentDTO implements Serializable {
	private int sno;
	private String sname;
	private String sadd;
	private  float  avg;
	
	public StudentDTO() {
		System.out.println("StudentDTO:: 0-param constructor");
	}

	public int getSno() {
		System.out.println("StudentDTO.getSno()");
		return sno;
	}

	public void setSno(int sno) {
		System.out.println("StudentDTO.setSno()");
		this.sno = sno;
	}

	public String getSname() {
		System.out.println("StudentDTO.getSname()");
		return sname;
	}

	public void setSname(String sname) {
		System.out.println("StudentDTO.setSname()");
		this.sname = sname;
	}

	public String getSadd() {
		System.out.println("StudentDTO.getSadd()");
		return sadd;
	}

	public void setSadd(String sadd) {
		System.out.println("StudentDTO.setSadd()");
		this.sadd = sadd;
	}

	public float getAvg() {
		System.out.println("StudentDTO.getAvg()");
		return avg;
	}

	public void setAvg(float avg) {
		System.out.println("StudentDTO.setAvg()");
		this.avg = avg;
	}

	@Override
	public String toString() {
		return "StudentDTO [sno=" + sno + ", sname=" + sname + ", sadd=" + sadd + ", avg=" + avg + "]";
	}
	
	

}
