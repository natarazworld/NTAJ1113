


<!-- create or locate spring bean calss object -->
  <jsp:useBean id="st"  class="com.nt.dto.StudentDTO"  scope="session"/>
  
  <!-- Read and display bean property values -->
     sno :::: <jsp:getProperty property="sno" name="st"/> <br>
     sname :::: <jsp:getProperty property="sname" name="st"/> <br>
     avg :::: <jsp:getProperty property="avg" name="st"/> <br>
     sadd :::: <jsp:getProperty property="sadd" name="st"/> <br>
     