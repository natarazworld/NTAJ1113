<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql"  prefix="sql"%>

<!-- establish the connection -->
<sql:setDataSource  var="ds" driver="oracle.jdbc.driver.OracleDriver"
                                                            url="jdbc:oracle:thin:@localhost:1521:xe"
                                                            user="system"
                                                            password="manager"/>

<!-- execiute non-select Query -->
<sql:update  dataSource="${ds}"  var="count" sql="UPDATE EMP SET SAL=SAL+? WHERE JOB=?">
    <sql:param>1000</sql:param>
    <sql:param value="CLERK"/>
</sql:update>

no.of records that are effected :: ${count}
                                                            
                                                            