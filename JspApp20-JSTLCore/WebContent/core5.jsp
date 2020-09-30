<%@ page isELIgnored="false"  import="java.util.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"    prefix="c"%>

  <c:set  var="msg"  value="hello , how are u "  scope="request"/>
  
  <c:forTokens  var="tkn" items="${msg}" delims=" ">
       ${tkn} <br>
  </c:forTokens>
 