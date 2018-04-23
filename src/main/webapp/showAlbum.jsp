<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Nguyen Hieu
  Date: 4/22/2018
  Time: 5:28 PM
  To change this template use File | Settings | File Templates.

--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Album</title>
    <style>
        div.gallery {
            margin: 5px;
            border: 1px solid #ccc;
            float: left;
            width: 250px;
        }

        div.gallery:hover {
            border: 1px solid #777;
        }

        div.gallery img {
            width: 250px;
            height: 250px;
        }

        div.desc {
            padding: 15px;
            text-align: center;
        }
    </style>
</head>
<body>
    <c:if test="${message ne null}">
        ${message}
    </c:if>
    <center>
        <c:forEach items="${linkImageList}" var="link">

            <div class="gallery">
                <a target="_blank" href="${link}">
                    <img src="${link}"  width="250px" height="250px">
                </a>
            </div>
        </c:forEach>
    </center>


</body>
</html>
