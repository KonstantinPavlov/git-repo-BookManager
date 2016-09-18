<%--
  Created by IntelliJ IDEA.
  User: Konstantin
  Date: 17.09.2016
  Time: 23:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new book</title>
</head>
<body>
<p><a href="/booklist">Back to the list</a> </p>

<table border="3" >
    <form action="/add" method="POST" accept-charset="UTF-8">
        You can add Book here:
        <tr>
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
                <textarea style="width:500px; height:100px" name="description" type="text" required></textarea>
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
