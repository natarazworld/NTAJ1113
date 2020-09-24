<%@ page  import="com.nt.dto.BookDTO,java.util.*"%>

<jsp:include page="header.jsp"/> <br><br>
<%
   //code for donwloading response of the  resource
     response.setContentType("application/vnd.ms-excel");
	 //set disatcher header vlaues
	 response.setHeader("Content-Disposition","attachment;fileName='Title.xls'");
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
         <br>
         <%@include file="footer.html"%>
         
              