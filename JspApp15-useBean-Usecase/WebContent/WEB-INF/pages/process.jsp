<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
     <!--  create or Locate DTO class object to/form request scope -->
     <jsp:useBean id="dto"  class="com.nt.dto.EmployeeDTO"  scope="request"/>
     
     <!-- write form data to DTO class object -->
     <jsp:setProperty name="dto"  property="*"/>
     
     <!-- create/locate Service class object -->
     <jsp:useBean id="empService"  
                                class="com.nt.service.EmployeeMgmtServiceImpl"
                                 type="com.nt.service.EmployeeMgmtService"
                                 scope="application"/>
    <%
        empService.generateSalaryDetails(dto);
    %>                                 
     <b><i>  Employee details are ::</i></b>
          employee id::  <jsp:getProperty property="eid" name="dto"/>      <br>
          employee name::  <jsp:getProperty property="ename" name="dto"/>      <br>
          employee basicSalary::  <jsp:getProperty property="basicSalary" name="dto"/>      <br>
          employee grossSalary::  <jsp:getProperty property="grossSalary" name="dto"/>      <br>
          employee netSalary::  <jsp:getProperty property="netSalary" name="dto"/>      <br>
          <br><br>
          <a href="form.html">home</a>
          
          
          
                                     
     
     
     
     
