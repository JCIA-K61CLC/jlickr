package com.jcia.jlickr.servlet;

import com.jcia.jlickr.dao.ImageDAO;
import com.jcia.jlickr.database.DBUtils;

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
        int id = Integer.valueOf(idImage);
        String nameImage = request.getParameter("name");
        System.out.println(idImage + " " + nameImage);
        ImageDAO imageDAO = new ImageDAO();
        Blob image = imageDAO.getImageByName(id, nameImage);
        byte[] imgData = null;
        try {
            imgData = image.getBytes(1, (int) image.length());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.setContentType("image/jpg");
        OutputStream o = response.getOutputStream();
        o.write(imgData);
        o.flush();
        o.close();
    }
}
