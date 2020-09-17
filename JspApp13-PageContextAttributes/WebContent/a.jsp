

<b> from a.jsp</b> <br>

<% //create attributes of different scopes   
          pageContext.setAttribute("attr1","val1");  // page scope
          pageContext.setAttribute("attr2","val2",pageContext.REQUEST_SCOPE);  //request scope
          pageContext.setAttribute("attr3","val3",pageContext.SESSION_SCOPE);  //session scope
          pageContext.setAttribute("attr4","val4",pageContext.APPLICATION_SCOPE);  //application scope
          %>
 <h1 style="color:red;text-align:center"> All 4 scopes of attributes are created ....</h1>
 
 <!-- forward the request -->
 <jsp:forward page="b.jsp"/>          