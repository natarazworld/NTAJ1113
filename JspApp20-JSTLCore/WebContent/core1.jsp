<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>

<!-- create data having request scope internall uses pageContext.setAttribute(-,-,-) -->
  <c:set  var="msg" value="welcome to jstl" scope="request"/>
  <!-- Display data  internally uses pageContext.findAttribte(-) -->
 value:: <c:out  value="${msg}"  />
  <!-- Remove data from scopes -->
  <c:remove var="msg"/>
  <!-- Display data  internally uses pageContext.findAttribte(-) -->
<br>  value ::<c:out  value="${msg}"  />
  



