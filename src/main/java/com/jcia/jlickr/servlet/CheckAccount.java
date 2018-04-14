package com.jcia.jlickr.servlet;

import com.jcia.jlickr.service.LoginService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CheckAccount extends HttpServlet {
    LoginService loginService = new LoginService();

    public CheckAccount(){
        super();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action =="login"){
            getAccount(req, resp);
        } else{
            forwardAccount(req, resp);
        }
    }

    private void getAccount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String accountName = req.getParameter("username");
        String accountPassword = req.getParameter("password");
        if(accountName != null && accountPassword != null) {
            Boolean check = loginService.CheckAcc(accountName, accountPassword);
            PrintWriter writer = resp.getWriter();
            String nextJsp = "/NextLogin.jsp";
            if (check == false) {
                nextJsp ="/Login.jsp";
                req.setAttribute("message", "Login failed!");
            } else {
                req.setAttribute("message", "Welcome, " + accountName + "!");
            }
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJsp);
            dispatcher.forward(req, resp);
        }
    }

    private void forwardAccount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String nextJSP = "/Login.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(req, resp);
    }
}
