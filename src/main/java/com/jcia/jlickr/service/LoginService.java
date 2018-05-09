package com.jcia.jlickr.service;

import com.jcia.jlickr.dao.Account;
import com.jcia.jlickr.dao.AccountDAO;

import java.util.List;

public class LoginService {

    public static Account CheckAcc(String username, String password){
        AccountDAO accountDAO = new AccountDAO();
        List<Account> listAccount = accountDAO.getAllAccounts();
        for (Account acc : listAccount){
            if (acc.getUserName().equals(username)) {
                String encodePass = EncryptionService.convertToMD5(password);
                if (acc.getPassword().equals(encodePass))
                return  acc;
            }
        }
        return null;
    }
    public static int getIdUser(String username) {
        AccountDAO accountDAO = new AccountDAO();
        List<Account> listAccount = accountDAO.getAllAccounts();
        for (Account acc : listAccount){
            if (acc.getUserName().equals(username))
                return  acc.getIdUser();
        }
        return 0;
    }
}
