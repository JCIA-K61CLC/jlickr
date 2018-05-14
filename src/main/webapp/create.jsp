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
    <style>
        form {
            box-sizing: border-box;
            width: 300px;
            margin: 100px auto 0;
            box-shadow: 2px 2px 5px 1px rgba(0, 0, 0, 0.2);
            padding-bottom: 40px;
            border-radius: 3px;
        }
        form h1 {
            box-sizing: border-box;
            padding: 20px;
        }
        input[type=text], input[type=password] {
            margin: 10px 25px;
            width: 200px;
            display: block;
            border: none;
            padding: 10px 0;
            border-bottom: solid 1px #1abc9c;
            transition: all 0.3s cubic-bezier(0.64, 0.09, 0.08, 1);
            background: linear-gradient(to bottom, rgba(255, 255, 255, 0) 96%, #1abc9c 4%);
            background-position: -250px 0;
            background-size: 250px 100%;
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

<form action="register" method="post" class="form h1">
    <h2 class="container">Create your account</h2>
    <h3 id="message"></h3>
    <h3 id="error"></h3>
    <h3 id="confirm"></h3>
    <p class="container">Username:</p></br> <input placeholder="Username" type="text" id="username" value="" name="username" oninput="checkAccount()">
    </br>
    <p class="container">Password:</p></br> <input placeholder="Password" type="password" id="password" value="" name="password1" oninput="checkPassword()">
    </br>
    <p class="container">Comfirm password:</p></br> <input placeholder="Re-password" type="password" id="confirmPassword" value="" name="password2" oninput="checkConfirmPassword()">
    </br>
    <p class="container">Birthday:</p></br> <input placeholder="dd/mm/yyyy" type="text" id="birthday" value="" name="birthday">
    </br>
    <p class="container">Gmail:</p></br> <input placeholder="abc@gmail.com" type="text" id="gmail" name ="gmail" value="">
    </br>
    <button type="submit" class="button">Create</button>
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
