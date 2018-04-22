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
            width: 180px;
        }

        div.gallery:hover {
            border: 1px solid #777;
        }

        div.gallery img {
            width: 100%;
            height: auto;
        }

        div.desc {
            padding: 15px;
            text-align: center;
        }
    </style>
</head>
<body>
        <%--<c:forEach items="${linkImageList}" var="link">
            <c:if test="${message} ne null">
                ${message}
            </c:if>

            <div class="gallery">
                &lt;%&ndash;<a target="_blank" href="link">
                    <img src="link" alt="Forest" width="600" height="400">
                </a>&ndash;%&gt;
                    <img src="${link}" width="250px" height="200px">
            </div>
        </c:forEach>--%>

</body>
</html>
