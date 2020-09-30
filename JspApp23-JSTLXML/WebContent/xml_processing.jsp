<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/xml"  prefix="x"%>

<!-- Load xml -->
<c:import url="orders.xml"  var="file"/>

<!-- parse xml file -->
<x:parse  var="doc"  doc="${file}"/>

<!-- Display all orders -->
<x:forEach var="ord" select="$doc/orders/order">
    <x:out select="$ord/name"/>  &nbsp; &nbsp;
    <x:out select="$ord/price"/> <br>
</x:forEach>

<hr>
<!-- Display all orders whose price>3000 -->
<x:forEach var="ord" select="$doc/orders/order">
    <x:if select="$ord/price>=3000">
       <x:out select="$ord/name"/>  &nbsp; &nbsp;
        <x:out select="$ord/price"/> <br>
    </x:if>
</x:forEach>