<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
    <h1 style="Color:red;text-align:Center">Mini Project on MVC2</h1>
    
    <form action="controller" method="POST">
      <table boder="5" bgcolor="cyan"   align="center">
         <tr>
           <td> Select Book category  </td>
           <td>  <select name="category" >
                      <option value="">--->SELECT a VALUE----> </option>
                     <option value="java">Java </option>
                     <option value=".net">.net </option>
                     <option value="spring">spring </option>
                      <option value="php">PHP</option>
           </select>  
            </td>
         </tr>
         <tr>
            <td><input type="button" value="excel output"> </td>
            <td><input type="button" value="html output"> </td>
         </tr>
      </table>
         <input type="hidden"  name="source" value=""/>       
    </form>
    