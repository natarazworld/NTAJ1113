
<%!  public  String  generateWishMessage(String user){
            //get System date and time
			java.util.Calendar cal=java.util.Calendar.getInstance();
			//get current hour of the day
             int hour=cal.get(java.util.Calendar.HOUR_OF_DAY);
			 //generate wish message
			  if(hour<12)
				    return "Good Morning::"+user;
			  else if(hour<16)
			        return "Good afternoon::"+user;
			  else if(hour<20)
                     return "Good evening::"+user;
			  else
                    return "Good night::"+user;
          }
			%>

			<h1>  welcome to  jsp page </h1>

			<h2> date and time :: <%=new java.util.Date()%> </h2>

			  <% String uname=request.getParameter("uname");  %> <br>
			  <b> wish Message is  :: </b> <%=generateWishMessage(uname) %>

			  <!-- request url ::  http://localhost:3030/JspApp1/second.jsp?uname=raja -->







