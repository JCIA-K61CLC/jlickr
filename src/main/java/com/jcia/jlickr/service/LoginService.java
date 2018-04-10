package com.jcia.jlickr.service;

import com.jcia.jlickr.dao.Account;
import com.jcia.jlickr.dao.ListAccount;

import java.util.List;

public class LoginService {
    private List<Account> listAccount = ListAccount.getInstance();

    public boolean CheckAcc(Account account){
        for (Account acc : listAccount){
            if (account.getUserName().equalsIgnoreCase(acc.getUserName()) && account.getPassword().equalsIgnoreCase(acc.getPassword()));
                return  true;
        }
        return false;
    }
}
