<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>

<c:set var="msg"  value="welcome to JSTL"  scope="request"/>

 <c:if test="${!empty param.uname }">
      <c:out value="${msg}"/> Mr/Miss/Mrs. <c:out value="${param.uname}"/> <br>
      ${msg} Mr/Miss/Mrs. ${param.uname } <br>
 </c:if>



