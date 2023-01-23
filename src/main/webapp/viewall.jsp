<%@page import="com.js.dto.Book"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Array"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>LIST OF ALL BOOKS</h1>
<table border="2px soli red">
<tr>
<th>Book_id</th>
<th>Book_name</th>
<th>Book_author</th>
<th>No_of_pages</th>
<th>Price</th>
<th>Delete</th>
<th>Edit</th>
</tr>
<%ArrayList<Book> books=(ArrayList)request.getAttribute("data");
for(Book b:books)
{	
%> <tr>

<td><%=b.getBook_id() %></td>
<td><%=b.getBook_name() %></td>
<td><%=b.getBook_author() %></td>
<td><%=b.getNo_of_pages() %></td>
<td><%=b.getPrice()%></td>



<td><a href="delete?id=<%= b.getBook_id() %>">delete</a></td>
<td><a href="update1?id=<%=b.getBook_id() %>">Edit</a></td>
</tr>

<%} %>

</table>
<a href="welcome.html"> HOME</a>
</body>
</html>