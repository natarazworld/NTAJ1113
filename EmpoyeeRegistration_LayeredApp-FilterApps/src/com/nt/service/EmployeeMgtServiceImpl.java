package com.nt.service;

import com.nt.bo.EmployeeBO;
import com.nt.dao.EmployeeDAO;
import com.nt.dao.EmployeeDAOImpl;
import com.nt.dto.EmployeeDTO;

public class EmployeeMgtServiceImpl implements EmployeeMgmtService {
          private EmployeeDAO dao;
          
	 public   EmployeeMgtServiceImpl() {
		dao=new EmployeeDAOImpl();
	}
	
	@Override
	public String registerEmployee(EmployeeDTO dto) throws Exception {
		float grossSalary=0.0f;
		float netSalary=0.0f;
		EmployeeBO bo=null;
		int count=0;
		//write  bb.logic
		grossSalary=dto.getBasicSalary()+ dto.getBasicSalary()*0.4f;
		netSalary=grossSalary-(grossSalary*0.2f);
		//create BO class object having persistable data
	     bo=new EmployeeBO();
	     bo.setEname(dto.getEname());
	     bo.setEadd(dto.getEadd());
	     bo.setDoj(dto.getDoj());
	     bo.setBasicSalary(dto.getBasicSalary());
	     bo.setGrossSalary(grossSalary);
	     bo.setNetSalary(netSalary);
	     //use dAO
	     count=dao.insert(bo);
	     //process the result
	     if(count==0)
	    	 return "Registration failed";
	     else
	    	 return "Registration succeded";
	    
		
	}

}
