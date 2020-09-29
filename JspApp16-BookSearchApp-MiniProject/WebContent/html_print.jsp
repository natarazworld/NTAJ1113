<%@page  isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c" %>
<jsp:include page="header.jsp"/>
   <br><br> 
<c:choose>
   <c:when test="${booksInfo ne null  && !empty booksInfo}">
     <center> <b> Books belonging to  :::: ${param.category}  </b> </center><br>
      <table border="1"  align="center" bgcolor="cyan">
        <tr>
          <th>SerialNo </th> <th>BookId </th> <th>BookName </th><th>Author </th><th>Publisher </th><th>Price </th> <th>status </th> <th>category </th> 
        </tr>
        <c:forEach var="dto"  items="${booksInfo}">
            <tr>
            	     <td>${dto.serialNo}</td>
            	     <td>${dto.bookId} </td>
            	     <td>${dto.bookName}</td>
            	     <td>${dto.author} </td>
            	     <td>${dto.publisher}</td>
            	     <td>${dto.price}</td>
            	     <td>${dto.status}</td>
            	     <td>${dto.category} </td>
            	  </tr>
        </c:forEach>
        </table>
   </c:when>
    <c:otherwise>
             <h1 style="color:red;text-align:center">No Books found to display </h1>
    </c:otherwise>
</c:choose>
          <script language="JavaScript" src="js/search.js"/>
           <a href="JavaScript:doPrint()">print</a>
           <br>
           <br>
           <%@include file="footer.html" %> 

<%-- <%@ page  import="com.nt.dto.BookDTO,java.util.*"%>
 <jsp:include page="header.jsp"/>
   <br><br> 
<%
  //read request attrobute vlaue
    List<BookDTO> listDTO=(List<BookDTO>)request.getAttribute("booksInfo");
  //read request parameter value
   String category=request.getParameter("category");
  
  
   //display listDTO content  as html db table content
   if(listDTO!=null && listDTO.size()>0){  %>
   
   <center> <b> Books belonging to  :::: <%=category%></b> <br> </center>
     <table border="1"  align="center" bgcolor="cyan">
        <tr>
          <th>SerialNo </th> <th>BookId </th> <th>BookName </th><th>Author </th><th>Publisher </th><th>Price </th> <th>status </th> <th>category </th> 
        </tr>
         <%
              for(BookDTO dto:listDTO){  %>
            	  <tr>
            	     <td><%=dto.getSerialNo() %> </td>
            	     <td><%=dto.getBookId() %> </td>
            	     <td><%=dto.getBookName() %> </td>
            	     <td><%=dto.getAuthor() %> </td>
            	     <td><%=dto.getPublisher() %> </td>
            	     <td><%=dto.getPrice() %> </td>
            	     <td><%=dto.getStatus() %> </td>
            	     <td><%=dto.getCategory() %> </td>
            	  </tr>
            	  <%
            	  }//for %
            	  %>
            	  </table>
           <%    }//if
              else{  %>
            	  <h1 style="color:red;text-align:center">No Books found to display </h1>
        <%      }//else
         %> 
              <script language="JavaScript" src="js/search.js">
              </script>
           <a href="JavaScript:doPrint()">print</a>
           <br>
           <%@include file="footer.html" %> 
      
 --%>        
        
	   
