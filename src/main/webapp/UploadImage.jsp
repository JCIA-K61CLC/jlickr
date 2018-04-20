
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>welcome</title>
    <style>
        h1 {
            text-shadow: 2px 2px 5px red;
            position: center;
        }
    </style>
</head>
<body>
        <form action="uploadImage" method="post" enctype="multipart/form-data">
            <c:if test="${message ne null}">
                <h1>Welcome to website</h1>
            </c:if>
            <input type="hidden" name="action" value="uploadImage"/></br>
            <input type="hidden" name="idUser" value="${idUser}">
            Select file to upload:
            <input type="file" name="file"/>
            </br></br>
            <button type="submit" action="Image.jsp">Upload</button>
            </br>
            <c:if test="${messageServlet ne null}">
                ${messageServlet}
            </c:if>
        </form>
</body>
</html>
