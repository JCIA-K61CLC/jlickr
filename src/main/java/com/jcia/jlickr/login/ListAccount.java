package com.jcia.jlickr.login;

import com.jcia.jlickr.database.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListAccount {
    private static final List<Account> accList = new ArrayList();
    private ListAccount(){}

    static {
        DBUtils db = DBUtils.getInstance();
        String sqlCommand = "select name, password from accounts";
        ResultSet rs = db.retrieveData(sqlCommand);
        try {
            while (rs.next()){
                Account acc = null;
                acc = new Account(rs.getString("name"), rs.getString("password"));
                accList.add(acc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public  List <Account> getInstance() {
        ListAccount listAccount = new ListAccount();
        return accList;
    }

    public static void main(String [] argc) {
        ListAccount listAccount = new ListAccount();
        for(int i = 0; i< accList.size(); i++) {
            System.out.println(accList.get(i).toString());
        }
    }
}
