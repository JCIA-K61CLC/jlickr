package com.jcia.jlickr.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "DisplayPhotoServlet",urlPatterns = "/display")
public class DisplayPhotoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idImage = request.getParameter("id");
        int id= Integer.valueOf(idImage);
        String nameImage = request.getParameter("name");
        System.out.println(idImage + " " + nameImage);
        Blob image = null;
        Connection con = null;
        byte[ ] imgData = null ;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/data","nhthieu","nguyenhieu");
            stmt = con.createStatement();
            String sqlCommand = "select photo from images where id = ? and name = ?";
            PreparedStatement ps = con.prepareStatement(sqlCommand);
            ps.setInt(1,id);
            ps.setString(2,nameImage);
            rs = ps.executeQuery();
            //rs = stmt.executeQuery("select photo from images where id = " + idImage + " and link = " + nameImage);

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
    }
}
