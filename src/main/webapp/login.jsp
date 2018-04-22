
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login</title>
    <style>
        form {
            box-sizing: border-box;
            width: 260px;
            margin: 100px auto 0;
            box-shadow: 2px 2px 5px 1px rgba(0, 0, 0, 0.2);
            padding-bottom: 40px;
            border-radius: 3px;
        }
        form h1{
            box-sizing: border-box;
            padding: 20px;
        }
        input {
            margin: 10px 25px;
            width: 200px;
            display: block;
            border: none;
            padding: 10px 0;
            border-bottom: solid 1px #1abc9c;
            transition: all 0.3s cubic-bezier(0.64, 0.09, 0.08, 1);
            background: linear-gradient(to bottom, rgba(255, 255, 255, 0) 96%, #1abc9c 4%);
            background-position: -200px 0;
            background-size: 200px 100%;
            background-repeat: no-repeat;
            color: #0e6252;
        }

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

        .container{
            padding-left: 25px;
        }

    </style>
</head>
<body>

<form action="login" method ="post" class="form h1">
    <c:if test="${message ne null}" style = "color:red">
        ${message}
    </c:if>
    <input type="hidden" name="action" value="login"/>
    <input placeholder="Username" type="text" value="" name="username"/>
    <input placeholder="Password" type="password" value="" name="password"/>
    <button type="submit" action = "uploadImage.jsp" class="button">Log in</button>
    </br></br>
    <p class="container">Don't have account?</br><a href="create.jsp" >Create account</a> </p>
</form>
</body>
</html>
