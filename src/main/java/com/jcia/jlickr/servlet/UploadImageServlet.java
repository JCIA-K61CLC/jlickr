package com.jcia.jlickr.servlet;

import com.jcia.jlickr.dao.Image;
import com.jcia.jlickr.dao.ImageDAO;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Properties;

@WebServlet(urlPatterns = "/uploadImage")
public class UploadImageServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Hello");
        InputStream inputStream = null;
        Part filePart = request.getPart("file");
        if (filePart != null) {
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
            System.out.println(filePart.getSubmittedFileName());
            String nameImage = filePart.getSubmittedFileName();
            System.out.println(nameImage);

            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
            HttpSession session = request.getSession();
            if (session.getAttribute("idUser") != null){
                System.out.println( "idUser session: " + session.getAttribute("idUser"));
            }
            else {
                System.out.println("idUser session is null");
            }
            int idUser = (int) session.getAttribute("idUser");
            Image image = new Image(idUser, nameImage, inputStream);
            ImageDAO imageDAO = new ImageDAO();
            imageDAO.addImage(image);
            //UploadImagesToFile.readBlob();
            System.out.println("Image had been added to database");
            getServletContext().getRequestDispatcher("/image.jsp").forward(request, response);
        }
        else {
            System.out.println("File part is NULL");
        }

        //Connection connection = DBUtils.getConnection();





    }
}

