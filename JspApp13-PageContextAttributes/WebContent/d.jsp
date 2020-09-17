<b> from d.jsp </b> <br>
     attr1 (page) value :: <%=pageContext.getAttribute("attr1") %> <br>
     attr1 (page) value :: <%=pageContext.findAttribute("attr1") %> <br> <br>
     
     attr2 (req) value :: <%=pageContext.getAttribute("attr2",pageContext.REQUEST_SCOPE) %> <br>
     attr2 (req) value :: <%=pageContext.findAttribute("attr2") %> <br> <br>
     
     attr3 (ses) value :: <%=pageContext.getAttribute("attr3",pageContext.SESSION_SCOPE) %> <br>
     attr3 (ses) value :: <%=pageContext.findAttribute("attr3") %> <br> <br>
     
     attr4 (application) value :: <%=pageContext.getAttribute("attr4",pageContext.APPLICATION_SCOPE) %> <br>
     attr4 (application) value :: <%=pageContext.findAttribute("attr4") %> <br>
     attr4 (application) value :: <%=application.getAttribute("attr4") %> <br><br> 
     
     
    