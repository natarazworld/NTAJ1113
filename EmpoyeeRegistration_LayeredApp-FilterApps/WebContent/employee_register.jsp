


<h1 style="color:red;text-align:center">Employee Registration Layered Application</h1>

<form action="controller"  method="POST"> 
  <table align="center" border="1" bgcolor="cyan"  rows="5" cols="2">
     <tr>
        <td> Employee Name::  </td>
        <td>  <input type="text"  name="ename"> </td>
     </tr>
     <tr>
        <td> Employee Addrs::  </td>
        <td>  <input type="text"  name="eadd"> </td>
     </tr>
     <tr>
        <td> Employee DOJ::   </td>
        <td>  <input type="date"  name="doj"> </td>
     </tr>
     <tr>
        <td> Employee Basic Salary::   </td>
        <td>  <input type="text"  name="basicSalary"> </td>
     </tr>
     <tr>
        <td> <input type="submit"  value="register">  </td>
        <td>  <input type="reset"  value="cancel"> </td>
     </tr>
      <tr>
         <td colspan="2"><input type="hidden" name="cToken" value="${sToken}"/>
      </tr>
 </table>
</form>
 <br><br>
   request count ::  ${reqCount}