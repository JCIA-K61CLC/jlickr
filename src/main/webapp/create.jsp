<%--
  Created by IntelliJ IDEA.
  User: Hoai Thu
  Date: 15/04/2018
  Time: 9:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Create your account</title>
</head>
<body>
<h2>Create your account</h2>
<h3 id="message"></h3>
<h3 id="error"></h3>
<h3 id="confirm"></h3>
<form action="register" method="post">
    Username: <input type="text" id="username" value="" name="username" oninput="checkAccount()">
    </br>
    Password: <input type="password" id="password" value="" name="password1" oninput="checkPassword()">
    </br>
    Comfirm password: <input type="password" id="confirmPassword" value="" name="password2" oninput="checkConfirmPassword()">
    </br>
    Birthday: <input type="text" id="birthdate" value="" name="birthdate">
    </br>
    Gmail: <input type="text" id="gmail" name ="gmail" value="">
    </br>
    <input type="submit" value="Create">
</form>
</body>

<%--doan nay chua can thiet lam--%>
<script type="text/javascript">
    function checkAccount() {
        var http = new XMLHttpRequest();
        var url = "/java.demo/AuthenticateAPI";
        var username = document.getElementById("username").value;
        var message = document.getElementById("message");
        var params = "username=" + username;
        http.open("POST", url, true);

        //Send the proper header information along with the request
        http.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

        http.onreadystatechange = function() {//Call a function when the state changes.
            if(http.readyState == 4 && http.status == 200) {
                if (http.responseText == "true") {
                    message.innerHTML = "This username has been taken!";
                    message.style.color = "red";
                } else {
                    message.innerHTML = "You can use this username";
                    message.style.color = "blue";

                }
            }
        }
        http.send(params);
    }
    function checkPassword() {
        var message = document.getElementById("error");
        var password = document.getElementById("password").value;
        if (password.length <6) {
            message.innerHTML = "Password needs being at least 6 characters!";
            message.style.color = "red";
        }
        else {
            message.innerHTML = "";
        }

    }

    function checkConfirmPassword() {
        var message = document.getElementById("confirm");
        var password = document.getElementById("password").value;
        var password2 = document.getElementById("confirmPassword").value;
        if (password===password2) {
            message.innerHTML = "Password matched!";
            message.style.color = "blue";
        }
        else {
            message.innerHTML = "Password didn't match!";
            message.style.color = "blue";
        }
    }

</script>

</html>
