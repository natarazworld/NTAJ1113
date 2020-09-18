package com.nt.service;

import com.nt.dto.EmployeeDTO;

public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {
	
	public EmployeeMgmtServiceImpl() {
		System.out.println("EmployeeMgmtServiceImpl::: 0-param constructor");
	}

	@Override
	public void generateSalaryDetails(EmployeeDTO dto) {
		var grossSalary=0.0f;  //java 10  local variable type inference feature ... (compiler decides the type  based on value we assign)
		var netSalary=0.0f;
	    //calculate gross ,net salary 
		grossSalary=dto.getBasicSalary()+dto.getBasicSalary()*0.3f;
		netSalary=grossSalary-(grossSalary*0.1f);
		//set gross,net salary to DTO class object
		dto.setGrossSalary(grossSalary);
		dto.setNetSalary(netSalary);
	}

}
