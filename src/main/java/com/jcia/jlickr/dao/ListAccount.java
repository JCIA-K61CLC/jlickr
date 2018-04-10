package com.jcia.jlickr.dao;

import com.jcia.jlickr.database.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ListAccount {
    private static final List<Account> accList = new ArrayList();
    private ListAccount(){}

    static {
        Connection connection = DBUtils.getConnection();
        String sqlCommand = "select * from accounts";
        ResultSet rs = DatabaseImpact.retrieveData(sqlCommand);
        try {
            while (rs.next()){
                Account acc = null;
                acc = new Account(rs.getString("name"),rs.getString("birthdate"), rs.getString("gmail"), rs.getString("password"));
                accList.add(acc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List <Account> getInstance() {
        ListAccount listAccount = new ListAccount();
        return accList;
    }
    public void addAccount(Account a) {
        accList.add(a);
        DatabaseImpact.addAccountToDatabase(a);
    }
    public static void main(String [] argc) {
        ListAccount listAccount = new ListAccount();
        Account a = new Account("hoaithu","01-02-1998", "thu@gmail.com","hoaithu");
        listAccount.addAccount(a);
        for(int i = 0; i< accList.size(); i++) {
            System.out.println(accList.get(i).toString());
        }


    }

}
