
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login</title>
</head>
<body>
<c:if test="${message ne null}">
    ${message}
</c:if>
<form action="login" method ="post">
    <input type="hidden" name="action" value="login"/>
    User name: <input type="text" value="" name="username"/>
    Password: <input type="password" value="" name="password"/>
    <button type="submit" action = "NextLogin.jsp">Log in</button>
    </br>
    Don't have account? <a href="create.jsp">Create account</a>
</form>
</form>
</form>
</form>
</body>
</html>
