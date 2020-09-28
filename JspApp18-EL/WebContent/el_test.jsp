<%@page isELIgnored="false"%>

request scope attribute value :: ${requestScope.attr1} <br>
session scope attribute value :: ${sessionScope.attr2} <br>
application scope attribute value :: ${applicationScope.attr3} <br>
<br><br>
request scope attribute value :: ${attr1} <br>
session scope attribute value :: ${attr2} <br>
application scope attribute value :: ${attr3} <br>
<br>
<hr>
uname req param value :: ${param.uname } <br>
addrs req param multipe values :: ${paramValues.addrs[0]},  ${paramValues.addrs[1]}  

<br>
<hr>
user-agent req header value ::  ${header['user-agent']} <br>
accept req header values ::  ${headerValues.accept[0]}, ${headerValues.accept[1]} <br>
<br>
<hr>
 cookie name ::  ${cookie.JSESSIONID.name } <br>
 cookie value ::  ${cookie.JSESSIONID.value } <br>
<br>
<hr>
 dbuser init param value :: ${initParam.dbuser } <br>
 dbpwd init param value :: ${initParam.dbpwd } <br>
  


    
    
