package com.nt.dto;

import java.io.Serializable;

public class EmployeeDTO implements Serializable {
	private int eid;
	private String ename;
	private float basicSalary;
	private  float grossSalary;
	private  float netSalary;
	
	public EmployeeDTO() {
		System.out.println("EmployeeDTO:: 0-param constructor");
	}
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public float getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(float basicSalary) {
		this.basicSalary = basicSalary;
	}
	public float getGrossSalary() {
		return grossSalary;
	}
	public void setGrossSalary(float grossSalary) {
		this.grossSalary = grossSalary;
	}
	public float getNetSalary() {
		return netSalary;
	}
	public void setNetSalary(float netSalary) {
		this.netSalary = netSalary;
	}
	
	@Override
	public String toString() {
		return "EmployeeDTO [eid=" + eid + ", ename=" + ename + ", basicSalary=" + basicSalary + ", grossSalary="
				+ grossSalary + ", netSalary=" + netSalary + "]";
	}
	
}//class
