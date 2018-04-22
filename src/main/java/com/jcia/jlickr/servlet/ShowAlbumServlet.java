package com.jcia.jlickr.servlet;

import com.jcia.jlickr.dao.Image;
import com.jcia.jlickr.dao.ImageDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/AlbumServlet")
public class ShowAlbumServlet extends HttpServlet{
    ImageDAO imageDAO = new ImageDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        System.out.println("get");
        HttpSession session = req.getSession();
        int idUser = (int) session.getAttribute("idUser");
        System.out.println("idUser" + idUser);
        List<String> linkImageList = imageDAO.getImagesById(idUser);
        for (String link : linkImageList){
            System.out.println(link.toString());
        }
        if (linkImageList.size() == 0){
            String message = "Empty!";
            req.setAttribute("message", message);
        }
        else
            req.setAttribute("linkImageList", linkImageList);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("showAlbum.jsp");
        dispatcher.forward(req, resp);
    }
}
