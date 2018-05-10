package com.jcia.jlickr.servlet;

import com.jcia.jlickr.dao.Account;
import com.jcia.jlickr.dao.AccountDAO;
import com.jcia.jlickr.service.EncryptionService;
import com.jcia.jlickr.service.RegisterService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    AccountDAO accountDAO = new AccountDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        String birthday = request.getParameter("birthday");
        String gmail = request.getParameter("gmail");
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
                    String encodePass = EncryptionService.convertToMD5(password1);
                    message = "Your account has been successfully created!";
                    request.setAttribute("message",message);
                    Account a = new Account(username,encodePass,birthday,gmail);
                    accountDAO.addAccount(a);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/createSuccess.jsp");
                    dispatcher.forward(request, response);
                }
            }
        }




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
