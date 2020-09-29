<%@ page isELIgnored="false"  import="java.util.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"    prefix="c"%>

 <!-- Tradtional for loop -->
 <table border="1"  align="center"  bgcolor="cyan">
 <c:forEach var="i" begin="1" end="10"  step="1">
     <tr>
       <td>2 *  ${i}= </td>  <td>${2*i} </td>
     </tr>
 </c:forEach>
 </table>
 <br><br>
 <jsp:scriptlet>
      String studNames[]={"raja","rani","suresh","mahesh"};
      request.setAttribute("namesArray",studNames);
 </jsp:scriptlet>
 <!-- Enhaced for loop -->
  <c:forEach  var="name" items="${namesArray}">
         ${name } <br>
  </c:forEach>
  
  <jsp:scriptlet>
   <![CDATA[
      List<Long>  phonesList=List.of(99999999L,8888888L,777777777L);  //java9
      request.setAttribute("phonesInfo",phonesList);
      ]]>
 </jsp:scriptlet>
 
 <!-- Enhaced for loop -->
  <c:forEach  var="ph" items="${phonesInfo}">
         ${ph} <br>
  </c:forEach>
  
  