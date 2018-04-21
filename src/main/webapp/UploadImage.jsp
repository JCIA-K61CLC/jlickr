<%--
  Created by IntelliJ IDEA.
  User: Hoai Thu
  Date: 18/04/2018
  Time: 10:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload</title>
</head>
<body>

    <form method="post" action="upload" enctype="multipart/form-data">
        Select file to upload:
        <input type="file" name="uploadFile" />
        <br/><br/>
        <input type="submit" value="Upload" />
    </form>

</body>
