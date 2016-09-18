<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Konstantin
  Date: 17.09.2016
  Time: 8:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta content='text/html; charset=UTF-8' http-equiv='Content-Type'>
<head>
    <title>Book Manager</title>
</head>
<body>
<h1>Book manager </h1>

<a href="/addNew"> <img src="add.png" width="50" height="50">  Add new Book</a>
<p> </p>
<form action="/booklist" method="GET" accept-charset="UTF-8">
    <p>Search by:</p>

    <c:choose>
    <c:when test="${whatSearch=='author'}">
        <input type="radio" name="search" value="name"> Name<Br>
        <input type="radio" name="search" value="author" checked> Author<Br>
    </c:when>
    <c:otherwise>
        <input type="radio" name="search" value="name" checked> Name<Br>
        <input type="radio" name="search" value="author"> Author<Br>
    </c:otherwise>
    </c:choose>

    <p><input name="searchValue" type="text"  value="${searchValue}">
    <input type="submit" value="Search Book" > <a href="/booklist">Очистить поиск</a> </p>
</form>

<table border="1">
    <tr>
        <td>Name</td>
        <td>Description</td>
        <td>Author</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
<c:forEach items="${books}" var="book">
<tr>
    <td width="200"><c:out  value ="${book.name}"/>  </td>
    <td width="250"><c:out value ="${book.description}"/></td>
    <td width="100"><c:out value ="${book.author}"/></td>
    <td>
        <a href="book?id=${book.id}">
            <img src="edit.png" width="40" height="40">
        </a>
    </td>
    <td>
        <a href="delete?id=${book.id}">
            <img src="delete.png" width="40" height="40">
        </a>
    </td>
</tr>
</c:forEach>
</table>
</form>
</body>
</html>
