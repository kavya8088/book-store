<%@page import="com.js.dto.Book"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>ENETR DETAILS OF UPDATE</h1>
<form action="update2">
<% Book b=(Book)request.getAttribute("book"); %>
BOOK ID:<input type="number" name="id" value="<%=b.getBook_id()%>" readonly="readonly"><br>
BOOK NAME:<input type="text" name="bookname" value="<%=b.getBook_name()%>"><br>
BOOK AUTHOR:<input type="text" name="bookauthor"  value="<%=b.getBook_author()%>"><br>
NO OF PAGES:<input type="number" name="nop" value="<%=b.getNo_of_pages()%>"><br>
PRICE:<input type="number" name="price" value="<%=b.getPrice()%>"><br>
SUBMIT:<input type="submit" value="update">
</form>


</body>
</html>