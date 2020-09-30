<%@ page isELIgnored="false"  contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>


<fmt:setLocale value="x-y"/>

<jsp:useBean id="dt"  class="java.util.Date"/>

<fmt:formatDate value="${dt}"  var="fdt"  type="both"  dateStyle="FULL"/>
formatted date :: ${fdt }
<hr>

<fmt:formatNumber  value="1234567890"  var="fno"  type="currency" />
formatted number :: ${fno }
<hr>
<fmt:formatNumber  value="1234567.55"  var="fno1"  type="number" />
formatted number :: ${fno1 }
<hr>
<fmt:formatNumber  value="0.3"  var="fno2"  type="percent" />
formatted number :: ${fno2 }

<hr>
  <fmt:setBundle basename="com/nt/commons/App"/>
  <fmt:message key="wish.welcome" var="fwelcome"/> 
  <fmt:message key="wish.bye" var="fbye"/>
     welcome message :: ${fwelcome } <br>
     bye message ::  ${fbye} 
      
  
  



