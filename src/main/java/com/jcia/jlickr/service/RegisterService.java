package com.jcia.jlickr.service;

import com.jcia.jlickr.dao.Account;
import com.jcia.jlickr.dao.AccountDAO;

import java.util.List;

public class RegisterService {
    public static boolean checkUsernameExist(String username ) {
        AccountDAO accountDAO = new AccountDAO();
        List<Account> list = accountDAO.getAllAccounts();
        for (Account temp : list) {
            if (username.equals(temp.getUserName())) {
                return true;
            }
        }
        return false;
    }
    public static boolean checkConfirmPassword(String password1, String password2) {
        if (password2.equals(password1)) return true;
        else return false;
    }
    public static boolean checkPasswordLength (String password) {
        if (password.length() < 6) return false;
        else return true;
    }
}
