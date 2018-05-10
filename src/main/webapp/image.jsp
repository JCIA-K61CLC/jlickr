<%--
  Created by IntelliJ IDEA.
  User: Nguyen Hieu
  Date: 4/19/2018
  Time: 8:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<html>
<head>
    <title>Image</title>
</head>
<body>
        <%--<h2>URL image: ${message}</h2>
        ${linkImage}
        <img src="${linkImage}" width="250px" height="250px"/>--%>
        <%
            Blob image = null;
            Connection con = null;
            byte[ ] imgData = null ;
            Statement stmt = null;
            ResultSet rs = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/data1","hoaithu","quangtuan");
                stmt = con.createStatement();
                rs = stmt.executeQuery("select photo from images where id = '1'");
                int count = 0;
                if (rs.next()) {
                    count++;
                    image = rs.getBlob(1);
                    imgData = image.getBytes(1,(int)image.length());
                }
                else {
                    PrintWriter p = response.getWriter();
                    p.println("Display Blob Example");
                    p.println("image not found for given id>");
                    return;
                }
// display the image
                response.setContentType("image/jpg");
                OutputStream o = response.getOutputStream();
                o.write(imgData);
                o.flush();
                o.close();
            } catch (Exception e) {
                PrintWriter p = response.getWriter();
                p.println("Unable To Display image");
                p.println("Image Display Error=" + e.getMessage());
                return;
            } finally {
                try {
                    rs.close();
                    stmt.close();
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        %>
</body>
</html>
