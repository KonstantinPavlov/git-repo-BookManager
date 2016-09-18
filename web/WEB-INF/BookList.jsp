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
    <style>
        h1 {
            font-size: 50px;
            font-family: Verdana, Arial, Helvetica, sans-serif;

        }
        body {
            background: url(Background-2.jpg) repeat-y,
            #fcfff6 url(Background-2.jpg) repeat-y 100% 0;
            background-size: cover;
        }
        .layer {
            margin: 5%;
            padding-left: 5%;
        }
    </style>
</head>
<body>
<div class="layer">
<table  width="750" cellpadding="5" cellspacing="0" border="0">
    <tr>
        <td>
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
                <button>
            <img src="find.png" width="30" height="30" alt="Найти книгу" title="Найти книгу" style="vertical-align:middle">        </button>
           <a href="/booklist">

       <img src="rollback.png" width="30" height="30" alt="Очистить поиск" title="Очистить поиск" style="vertical-align:middle"></a>
</form>

<table width="600" border="1">
    <tr>
        <th>Name</th>
        <th>Author</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
<c:forEach items="${books}" var="book">
<tr>
    <td width="160"><c:out  value ="${book.name}"/>  </td>
    <td width="200"><c:out value ="${book.author}"/></td>
    <td width="50" align="center">
        <a href="book?id=${book.id}">
            <img src="edit.png" width="40" height="40">
        </a>
    </td>
    <td width="50" align="center">
        <a href="delete?id=${book.id}">
            <img src="delete.png" width="40" height="40">
        </a>
    </td>
</tr>
</c:forEach>
</table>
</form>
    </td>
        <td width="30">

        </td>

        <td width="360" align="center">

        </td>
    </tr>
</table>
</div>
</body>
</html>
