package com.jcia.jlickr.servlet;

import com.jcia.jlickr.dao.ImageDAO;
import com.jcia.jlickr.dao.Image;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DeleteImageServlet",urlPatterns = "/deleteImage")
public class DeleteImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    ImageDAO imageDAO = new ImageDAO();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        System.out.println(name);
        HttpSession session = req.getSession();
        if (name == null) System.out.println("name is null");
        else System.out.println("name is : " + name);
        int idUser = (int) session.getAttribute("idUser");
        System.out.println("idUser delete "+ idUser);
        List<Image> listImage = imageDAO.deleteImage( name, idUser);
        System.out.println("length : " + listImage.size());
        session.setAttribute("listImage",listImage);
        req.setAttribute("messageDelete", "Delete successfully");
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/showAlbum.jsp");
        dispatcher.forward(req, resp);
    }
}
