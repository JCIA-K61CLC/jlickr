package com.jcia.jlickr.servlet;

import com.jcia.jlickr.dao.Image;
import com.jcia.jlickr.dao.ImageDAO;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Properties;

@WebServlet(urlPatterns = "/uploadImage")
public class UploadImageServlet extends HttpServlet{
    public UploadImageServlet(){super();}

    ImageDAO imageDAO = new ImageDAO();
    private static final String UPLOAD_DIRECTORY = "images";
    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
//            String idUserStr = (String) .getAttribute("idUser");
//        System.out.println(idUserStr);
//        String name = req.getParameter("username");
//        System.out.println(name);
//            int idUser = Integer.parseInt(idUserStr);
        if (!ServletFileUpload.isMultipartContent(req)) {
            req.setAttribute("messageServlet", "Error: Form must has enctype=multipart/form-data.");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/uploadImage.jsp");
            dispatcher.forward(req, resp);
        }
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setFileSizeMax(MAX_FILE_SIZE);
        upload.setSizeMax(MAX_REQUEST_SIZE);
//            Properties p = new Properties();
//        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//        InputStream input = classLoader.getResourceAsStream("app.properties");
//        p.load(input);
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        String imageSource = p.getProperty("db.imageSource");
//        String uploadPath = "C:\\Users\\Nguyen Hieu\\Downloads" + File.separator +UPLOAD_DIRECTORY;

        Properties p = new Properties();
        String webappURL = null;
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream input = classLoader.getResourceAsStream("app.properties");
            p.load(input);
            Class.forName("com.mysql.jdbc.Driver");
            webappURL = p.getProperty("webappURL");
            System.out.println(webappURL);
            //String uploadPath = "C:\\Users\\Admin\\IdeaProjects\\jlickr\\src\\main\\webapp" + File.separator +UPLOAD_DIRECTORY;
            String uploadPath = webappURL + File.separator +UPLOAD_DIRECTORY;


            System.out.println("Present Project Directory : "+ System.getProperty("user.dir"));
            File uploadDir = new File(uploadPath);
            System.out.println(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            try {
                @SuppressWarnings("unchecked")
                List<FileItem> formItems = upload.parseRequest(req);

                if (formItems != null && formItems.size() > 0) {
                    for (FileItem item : formItems) {
                        if (!item.isFormField()) {
                            String fileName = new File(item.getName()).getName();
                            String filePath = uploadPath + File.separator + fileName;
                            File storeFile = new File(filePath);
                            item.write(storeFile);

//                            Image image = new Image(idUser, filePath);
                            System.out.println("upload1");
//                        System.out.println(idUserStr);
                            System.out.println("upload2");
                            System.out.println(filePath);
//                            imageDAO.addImage(image);
                            req.setAttribute("message", "Upload has been done successfully at : "+uploadPath  + File.separator + fileName);

                            String link = "/" +UPLOAD_DIRECTORY+ "/" + fileName;
                            System.out.println(link);

                            if (req.getAttribute("idUser") != null){
                                System.out.println(req.getAttribute("idUser"));
                            }
                            else {
                                System.out.println("idUser request is null");
                            }
                            HttpSession session = req.getSession();

                            if (session.getAttribute("idUser") != null){
                                System.out.println( "idUser session: " + session.getAttribute("idUser"));
                            }
                            else {
                                System.out.println("idUser session is null");
                            }
                            req.setAttribute("linkImage", link);
                            int idUser = (int) session.getAttribute("idUser");
                            Image image = new Image(idUser,link);
//                        ImageDAO imageDAO = new ImageDAO();
                            imageDAO.addImage(image);
                        }
                    }
                }
            } catch (Exception ex) {
                req.setAttribute("message", "There was an error: " + ex.getMessage());
            }
            getServletContext().getRequestDispatcher("/image.jsp").forward(req, resp);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        /*String uploadPath = "C:\\Users\\Admin\\IdeaProjects\\jlickr\\src\\main\\webapp" + File.separator +UPLOAD_DIRECTORY;

        System.out.println("Present Project Directory : "+ System.getProperty("user.dir"));
        File uploadDir = new File(uploadPath);
        System.out.println(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        try {
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(req);

            if (formItems != null && formItems.size() > 0) {
                for (FileItem item : formItems) {
                    if (!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();
                        String filePath = uploadPath + File.separator + fileName;
                        File storeFile = new File(filePath);
                        item.write(storeFile);

//                            Image image = new Image(idUser, filePath);
                        System.out.println("upload1");
//                        System.out.println(idUserStr);
                        System.out.println("upload2");
                        System.out.println(filePath);
//                            imageDAO.addImage(image);
                        req.setAttribute("message", "Upload has been done successfully at : "+uploadPath  + File.separator + fileName);

                        String link = "/" +UPLOAD_DIRECTORY+ "/" + fileName;
                        System.out.println(link);

                        if (req.getAttribute("idUser") != null){
                            System.out.println(req.getAttribute("idUser"));
                        }
                        else {
                            System.out.println("idUser request is null");
                        }
                        HttpSession session = req.getSession();

                        if (session.getAttribute("idUser") != null){
                            System.out.println( "idUser session: " + session.getAttribute("idUser"));
                        }
                        else {
                            System.out.println("idUser session is null");
                        }
                        req.setAttribute("linkImage", link);
                        int idUser = (int) session.getAttribute("idUser");
                        Image image = new Image(idUser,link);
//                        ImageDAO imageDAO = new ImageDAO();
                        imageDAO.addImage(image);
                    }
                }
            }
        } catch (Exception ex) {
            req.setAttribute("message", "There was an error: " + ex.getMessage());
        }
        getServletContext().getRequestDispatcher("/image.jsp").forward(req, resp);*/
    }

}

