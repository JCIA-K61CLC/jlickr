package com.jcia.jlickr.servlet;

import com.jcia.jlickr.dao.Image;
import com.jcia.jlickr.dao.ImageDAO;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.RequestContext;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/uploadImage")
public class UploadImageServlet extends HttpServlet{
    public UploadImageServlet(){super();}

    ImageDAO imageDAO = new ImageDAO();
    private static final String UPLOAD_DIRECTORY = "upload";
    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("PostUpload");
        String action = req.getParameter("action");
        System.out.println(action);
        if(action.equals("uploadImage")){
            System.out.println("upload1");
            UploadImage(req, resp);
        } else{
            forwardImage(req, resp);
            System.out.println("upload2");
        }

    }
    private void UploadImage(HttpServletRequest req, HttpServletResponse resp)throws IOException, ServletException{
        int idUser = req.getIntHeader("idUser");
        System.out.println(idUser);
        String nextJSP = "/Image.jsp";
        //kiểm tra tải lên có chứa tệp không
        if (!ServletFileUpload.isMultipartContent(req)){
            req.setAttribute("messageServlet", "Form must has enctype=multipart/form-data.");
            nextJSP ="/UploadImage.jsp";
        }
        else {
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
            diskFileItemFactory.setSizeThreshold(MEMORY_THRESHOLD);
            diskFileItemFactory.setRepository(new File(System.getProperty("java.io.tmpdir")));
            ServletFileUpload upload = new ServletFileUpload(diskFileItemFactory);
            upload.setFileSizeMax(MAX_FILE_SIZE);
            upload.setSizeMax(MAX_REQUEST_SIZE);
            String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
            File filedir = new File(uploadPath);
            if (!filedir.exists()){
                filedir.mkdirs();
            }
            try {
//                @SuppressWarnings("unchecked")
                List<FileItem> fileItemList = upload.parseRequest((RequestContext) req);
                if (fileItemList != null && fileItemList.size() > 0){
                    for (FileItem fileItem :fileItemList){
                        if (fileItem.isFormField()){
                            String fileName = new File(fileItem.getName()).getName();
                            String filePath = uploadPath + File.separator + fileName;
                            System.out.println(fileName + " " + filePath);
                            File storeFile = new File(filePath);
                            Image image = new Image(idUser, filePath);
                            imageDAO.addImage(image);
                            fileItem.write(storeFile);
                            req.setAttribute("message", "Upload has been done successfully >>" + UPLOAD_DIRECTORY + "/" + fileName);
                            req.setAttribute("images", filePath);
                        }
                    }
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher(nextJSP);
        dispatcher.forward(req, resp);

    }
    private void forwardImage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nextJSP = "/UploadImage.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(req, resp);
    }

}

