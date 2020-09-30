<%@ page isELIgnored="false"  import="java.util.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"    prefix="c"%>

  <c:url var="googleUrl"   value="https://google.com/search"  scope="request" />
  
  <c:redirect  url="${googleUrl }"/> 