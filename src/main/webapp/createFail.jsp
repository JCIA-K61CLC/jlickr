<%--
  Created by IntelliJ IDEA.
  User: Hoai Thu
  Date: 15/04/2018
  Time: 11:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Fail</title>
</head>
<body>
    <%= (String) request.getAttribute("message") %>
    </br>
    <a href="create.jsp">Back</a>
</body>
</html>
