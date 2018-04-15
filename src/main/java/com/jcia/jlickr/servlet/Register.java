package com.jcia.jlickr.servlet;

import com.jcia.jlickr.dao.Account;
import com.jcia.jlickr.dao.DatabaseImpact;
import com.jcia.jlickr.dao.ListAccount;
import com.jcia.jlickr.database.DBUtils;
import com.jcia.jlickr.service.RegisterService;

import javax.imageio.spi.RegisterableService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/register")
public class Register extends HttpServlet {
    List<Account> list = ListAccount.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Post");
        String username = request.getParameter("username");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        String birthdate = request.getParameter("birthdate");
        String gmail = request.getParameter("gmail");
        System.out.println(username);
        System.out.println(password1);
        System.out.println(password2);
        System.out.println(birthdate);
        System.out.println(gmail);
        String message = "";
        if (RegisterService.checkUsernameExist(username) == true ) {
            message = "This username had been used";
            request.setAttribute("message",message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/createFail.jsp");
            dispatcher.forward(request, response);
        } else {
            if (RegisterService.checkConfirmPassword(password1,password2)==false) {
                message = "Password didn't match";
                request.setAttribute("message",message);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/createFail.jsp");
                dispatcher.forward(request, response);
            }
            else {
                if (RegisterService.checkPasswordLength(password1) == false) {
                    message = "Password must have at least 6 characters";
                    request.setAttribute("message" , message);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/createFail.jsp");
                    dispatcher.forward(request, response);
                }
                else {
                    message = "Your account has been successfully created!";
                    request.setAttribute("message",message);
                    Account a = new Account(username,birthdate,gmail,password1);
                    ListAccount.addAccount(a);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/createSuccess.jsp");
                    dispatcher.forward(request, response);
                }
            }
        }




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
