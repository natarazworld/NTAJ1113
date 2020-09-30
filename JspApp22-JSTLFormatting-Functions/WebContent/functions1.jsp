<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>

<c:set var="msg"  value="welcome nit"/>
 uppercase ::  ${fn:toUpperCase(msg) } <br>
 lowercase ::  ${fn:toLowerCase(msg) } <br>
 length ::  ${fn:length(msg) } <br>
 substring ::  ${fn:substring(msg,0,5) } <br>
 
 
 
 
 
