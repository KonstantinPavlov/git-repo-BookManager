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
<h1>Book manager Test</h1>
<table border="1">
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
<p> </p>

<table border="3" >
<form action="/add" method="POST" accept-charset="UTF-8">
    You can add Book here:
    <tr  >
        <td colspan="2">Name :
            <input name="name" type="text" required>
        </td>

        <td>Author :
            <input name="author" type="text" required>
        </td>

    </tr>
    <p></p>
        <tr >
            <td colspan="2">Description :
                <textarea style="width:500px; height:100px" name="description" type="text" required> </textarea>
            </td>
    </tr>
    <tr>
        <td>
            <input type="submit" value="Add Book" >
        </td>
    </tr>

</form>
</table>

</body>
</html>
