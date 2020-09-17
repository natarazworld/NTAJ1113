
<!-- create or Locate Java bean class object -->
 <jsp:useBean id="st"  class="com.nt.dto.StudentDTO"  scope="session"/>  
 
 <!--  To set request param values(form data) to bean properites by matching req param names with bean  property names -->
    <jsp:setProperty name="st" property="*"/>
     
      <!-- To set request param values(form data) to bean properites -->
      
   <%--   <jsp:setProperty property="sno" name="st"  param="stno"/>
     <jsp:setProperty property="sname" name="st"  param="stname"/>
     <jsp:setProperty property="sadd" name="st"  param="stadd"/>
     <jsp:setProperty property="avg" name="st"  param="stavg"/>
      --%>
      
      <!--  set values to bean properties -->
    <%--    <jsp:setProperty property="sno" name="st"  value="1001"/>
     <jsp:setProperty property="sname" name="st"  value="rakesh"/>
     <jsp:setProperty property="sadd" name="st"  value="hyd"/>
     <jsp:setProperty property="avg" name="st"  value="55.55f"/> --%>
     
     <br> <b> values are set to bean properties  </b> 
     