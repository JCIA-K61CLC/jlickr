package com.jcia.jlickr.servlet;

import com.jcia.jlickr.dao.Account;
import com.jcia.jlickr.service.LoginService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class AuthenticationServlet extends HttpServlet {
    public AuthenticationServlet(){
        super();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("PostLogin");
        String action = req.getParameter("action");
        if(action.equals("login")){
            getAccount(req, resp);
        } else{
            forwardAccount(req, resp);
        }
    }

    private void getAccount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        HttpSession session = req.getSession();
        String accountName = req.getParameter("username");
        String accountPassword = req.getParameter("password");
        if(accountName != null && accountPassword != null) {
            Account check = LoginService.CheckAcc(accountName, accountPassword);
            PrintWriter writer = resp.getWriter();
            String nextJsp = "/home.jsp";
            if (check == null) {
                nextJsp ="/login.jsp";
                req.setAttribute("message", "Login failed!");
            } else {
                session.setAttribute("message", "Welcome, " + accountName + "!");
                int idUser = LoginService.getIdUser(accountName);
                session.setAttribute("idUser",idUser);
            }

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJsp);
            dispatcher.forward(req, resp);
        }
    }

    private void forwardAccount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String nextJSP = "/login.jsp";
//        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
//        dispatcher.forward(req, resp);

    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

}
