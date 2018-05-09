package com.jcia.jlickr.servlet;

import com.jcia.jlickr.dao.Image;
import com.jcia.jlickr.dao.ImageDAO;
import com.jcia.jlickr.dao.ListImages;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/AlbumServlet")
public class ShowAlbumServlet extends HttpServlet{
    ImageDAO imageDAO = new ImageDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        HttpSession session = req.getSession();
        int idUser = (int) session.getAttribute("idUser");
        /*List<String> linkImageList = imageDAO.getImagesById(idUser);
        List<ListImages> listImages = new ArrayList();*/


        List <Image> listImage = imageDAO.getImagesById(idUser);
        for (int i = 0; i < listImage.size(); i++) {
            System.out.println(listImage.get(i).getIdUser()+ " " + listImage.get(i).getLink());
        }
        System.out.println(listImage.size());
        if (listImage == null) {
            String message = "Empty!";
            req.setAttribute("message", message);
            System.out.println(message);
        }
        else {
            String message = "Not empty";
            req.setAttribute("message",message);
            req.setAttribute("listImage", listImage);
            System.out.println(message);
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/showAlbum.jsp");
        dispatcher.forward(req, resp);

        /*int count = 1;
        for(String linkImage : linkImageList){
            ListImages listImages1 = new ListImages(count, linkImage);
            listImages.add(listImages1);
            count++;
        }
        if (linkImageList.isEmpty()){
            String message = "Empty!";
            req.setAttribute("message", message);
        }
        else
            req.setAttribute("linkImageList", listImages);*/
        /*RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/showAlbum.jsp");
        dispatcher.forward(req, resp);*/
    }
}
