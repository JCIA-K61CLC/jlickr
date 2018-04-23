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
</head>
<body>
    <c:if test="${message ne null}">
        <h1>${message}</h1>
    </c:if>
    <a href="uploadImage.jsp">Upload Image</a>
    </br>
    <%--<form action="AlbumServlet" method="get" >
        <a href="AlbumServlet">Album</a>
    </form>--%>
    <a href="AlbumServlet">Album</a>
</body>
</html>
