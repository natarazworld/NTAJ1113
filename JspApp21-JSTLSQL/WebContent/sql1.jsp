<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql"  prefix="sql"%>

<!-- establish the connection -->
<sql:setDataSource  var="ds" driver="oracle.jdbc.driver.OracleDriver"
                                                            url="jdbc:oracle:thin:@localhost:1521:xe"
                                                            user="system"
                                                            password="manager"/>
<!-- Execute the SQL query and create RS -->
<sql:query var="rs"  sql="SELECT EMPNO,ENAME,JOB,SAL FROM EMP" dataSource="${ds}"/>

<b>All records</b> <br>
<c:forEach  var="row"  items="${rs.rows}">
    ${row.EMPNO } , ${row.ENAME }  , ${row.JOB } , ${row.SAL } <br>
</c:forEach>

                                                            
                                                            