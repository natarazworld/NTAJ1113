
<b> before</b>
<%
//read form data
  String ss=request.getParameter("ss");
//pre google url
String url="https://www.google.com/search?q="+ss;
// perform sendRedirection
System.out.println("before");
response.sendRedirect(url);
System.out.println("after");
%>

<b> after</b>