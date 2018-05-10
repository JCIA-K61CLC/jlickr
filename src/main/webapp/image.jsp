<%--
  Created by IntelliJ IDEA.
  User: Nguyen Hieu
  Date: 4/19/2018
  Time: 8:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Image</title>
    <style>
        button {
            border: none;
            background: #1abc9c;
            cursor: pointer;
            border-radius: 3px;
            padding: 6px;
            width: 200px;
            color: white;
            margin-left: 25px;
            box-shadow: 0 3px 6px 0 rgba(0, 0, 0, 0.2);
        }
    </style>


</head>
<body>
    <form action="uploadImage" method="post">
        <h2>URL image: ${message}</h2>
        <img src="display?id=${image.getIdUser()}&name=${image.getName()}" width=auto height="250px"/>
        </br>
       <%-- <button type="submit" action="uploadImage.jsp">Upload new image</button>
        <button type="submit" action="AlbumServlet">Show your album</button>--%>
        <a href="uploadImage.jsp">Upload new image</a>
        <a href="AlbumServlet">Show your album</a>

    </form>

</body>
</html>
