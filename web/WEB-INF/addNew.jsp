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
            padding-left: 15px;
        }
        .rightimg {
            float: right;
            margin: 10px 100px 10px 110px;
        }

    </style>
</head>
<body>
<div class="layer">
<table>
    <tr>
        <td style="vertical-align: top">
            <h1><img src="/uploadFiles/somebook.png" width="50" height="50">Add new book</h1>
            <p><a href="/booklist"> <img src="rollback.png" width="30" height="30" alt="Назад" title="Назад" style="vertical-align:middle"></a> </p>

<table border="0" >
    <form action="/add" method="POST" accept-charset="UTF-8">
        <br/>Name :
        <br/><input style="width:750px;" name="name" type="text" required>
        <br/>Author :
        <br/><input style="width:750px;" name="author" type="text" required>
        <br/>Description :
        <br/><textarea style="width:750px; height:100px" name="description" type="text" required></textarea>
        <br/><input type="submit" value="Add Book" >
    </form>
</table>
</td>
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
