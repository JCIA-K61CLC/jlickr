
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>welcome</title>
    <style>
        h1 {
            text-shadow: 2px 2px 5px red;
            position: center;
        }
    </style>
</head>
<body>
<%--<input type="hidden" name="idUser" value="${idUser}">--%>
        <form action="uploadImage" method="post" enctype="multipart/form-data">

            </br>
            <%--<%
                String idUser= (String) request.getAttribute("idUser");
                session.setAttribute("idUser",idUser);
            %>--%>
            Select file to upload:
            <input type="file" name="file"/>
            </br></br>
            <button type="submit">Upload</button>
            </br>
            <c:if test="${messageServlet ne null}">
                ${messageServlet}
            </c:if>
        </form>

</body>
</html>
