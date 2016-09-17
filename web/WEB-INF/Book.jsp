<%--
  Created by IntelliJ IDEA.
  User: Konstantin
  Date: 17.09.2016
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta content='text/html; charset=UTF-8' http-equiv='Content-Type'>
<head>
    <title>${book.name}</title>
</head>
<body>
<h2>${book.name}</h2>
    <form action="/update?id=${book.id}" method="POST" accept-charset="UTF-8">
        <br>Book name:
        <br/><input style="width:400px;" name="name" type="text" required value="${book.name}" >
        <br/>Description :
        <br/><textarea style="width:400px; height:150px" name="description" type="textarea" required >${book.description}</textarea>
        <br/> Author :
        <br/><input style="width:400px;"  name="author" type="text" required value="${book.author}">
        <br/> Button :
        <br/><input type="submit" value="Update Book" >
    </form>

</body>
</html>
