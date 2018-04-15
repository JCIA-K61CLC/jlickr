package com.jcia.jlickr.service;

import com.jcia.jlickr.dao.Account;
import com.jcia.jlickr.dao.ListAccount;

import java.util.List;

public class RegisterService {
    private static List<Account> list = ListAccount.getInstance();
    public static boolean checkUsernameExist(String username ) {
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
    public static List<Account> getInstance() {
        return list;
    }
    public static void main(String[] args) {
        List<Account> list = RegisterService.getInstance();
        System.out.println(RegisterService.checkUsernameExist("hoaithu"));
    }
}
