package com.jcia.jlickr.service;

import com.jcia.jlickr.dao.Account;
import com.jcia.jlickr.dao.AccountDAO;

import java.util.List;

public class LoginService {
    public static Account CheckAcc(String username, String password){
        AccountDAO accountDAO = new AccountDAO();
        List<Account> listAccount = accountDAO.getAllAccounts();
        for (Account acc : listAccount){
            if (acc.getUserName().equals(username) && acc.getPassword().equals(password))
                return  acc;
        }
        return null;
    }
}
