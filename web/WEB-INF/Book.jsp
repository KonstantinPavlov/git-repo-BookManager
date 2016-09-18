<%@ page import="ru.konstpavlov.model.DAO" %>
<%@ page import="java.io.File" %><%--
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
<table  width="750px" cellpadding="5" cellspacing="0" border="0">

    <tr>
        <td style="vertical-align: top">
<h1><img src="/uploadFiles/somebook.png" width="50" height="50">${book.name}  </h1>

<p><a href="/booklist"> <img src="rollback.png" width="30" height="30" alt="Назад" title="Назад" style="vertical-align:middle"></a> </p>
    <form action="/update?id=${book.id}" method="POST" accept-charset="UTF-8">
        <b><i></i></b><br>Book name:
        <br/><input style="width:750px;" name="name" type="text" required value="${book.name}">
        <br/> Author :
        <br/><input style="width:750px;"  name="author" type="text" required value="${book.author}">
        <br/>Description :
        <br/><textarea style="width:750px; height:150px" name="description" type="textarea" required>${book.description}</textarea>
        <br/> Button :
        <br/><input type="submit" value="Update Book" >
    </form>
        </td>

        <td>

    </td>
       <td class="rightimg">
           <p> Add an image :</p>
           <form action="/addimage?id=${book.id}" enctype="multipart/form-data" method="POST">
               <p><input type="file" accept="image/*" name="image"> <input type="submit" value="Отправить"></p></i></b>
           </form>

           <p></p>
<img src= "<%=("/"+DAO.getSaveDir() +"/").toString()%>${book.imagePath}" width="350" height="500" align="right"></td>

    </tr>
</table>
</div>
</body>
</html>
