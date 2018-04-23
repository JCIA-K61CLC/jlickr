<%--
  Created by IntelliJ IDEA.
  User: Nguyen Hieu
  Date: 4/22/2018
  Time: 5:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <style>
        * {
            box-sizing: border-box;
        }

        body {
            font-family: Arial;
            margin: 0;
        }

        .header {
            padding: 80px;
            text-align: center;
            background: #1abc9c;
            color: white;
        }
        .navbar {
            overflow: hidden;
            background-color: #333;
        }
        .navbar a {
            float: left;
            display: block;
            color: white;
            text-align: center;
            padding: 14px 20px;
            text-decoration: none;
        }
        .navbar a.right {
            float: right;
        }

        .navbar a:hover {
            background-color: #ddd;
            color: black;
        }
    </style>
</head>
<body>
    <div class="header">
        <c:if test="${message ne null}">
            <h1>${message}</h1>
        </c:if>
    </div>
    <div class="navbar">
        <a href="uploadImage.jsp">Upload</a>
        <a href="AlbumServlet">Album</a>
    </div>
</body>
</html>
