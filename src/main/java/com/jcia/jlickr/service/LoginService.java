package com.jcia.jlickr.service;

import com.jcia.jlickr.dao.Account;
import com.jcia.jlickr.dao.ListAccount;
import com.jcia.jlickr.servlet.CheckAccount;

import java.util.List;

public class LoginService {
    private static List<Account> listAccount = ListAccount.getInstance();

    public List<Account> getAllAccount() {
        return listAccount;
    }

    public static Boolean CheckAcc(String username, String password){
        for (Account acc : listAccount){
            if (acc.getUserName().equals(username) && acc.getPassword().equals(password))
                return  true;
        }
        return false;
    }
    public static void main(String[] argc){
        System.out.println(CheckAcc("hoaithu", "quangtuan"));
        System.out.println(CheckAcc("abc", "toan"));

    }
}
