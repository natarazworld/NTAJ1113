

<%!  public void jspInit(){
         /*     System.out.println("dbuser init param value::"+config.getInitParameter("dbuser"));  //error
              System.out.println("dbuser context param value::"+application.getInitParameter("dbuser")); */ //eroror
            //create our own reference variables pointing to  ServletConfig ,Servletcontxt objs
            ServletConfig cg=getServletConfig();
            ServletContext sc=getServletContext();
            System.out.println("dbuser init param value::"+cg.getInitParameter("dbuser"));  
            System.out.println("dbuser context param value::"+sc.getInitParameter("dbuser"));
  }  %>
  
  <b> welcome to jsp page</b>