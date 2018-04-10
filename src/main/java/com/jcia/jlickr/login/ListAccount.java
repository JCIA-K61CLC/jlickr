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
        if(db == null)System.out.println("db null");
        String sqlCommand = "select name, password from accounts";
        ResultSet rs = db.retrieveData(sqlCommand);
        try {
            while (rs.next()){
                Account acc = null;
                acc = new Account(rs.getString(1), rs.getString(4));
                accList.add(acc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public  List <Account> getInstance() {
        return accList;
    }

    public static void main(String[] args){
        ListAccount listAccount = new ListAccount();
        List<Account> list= listAccount.getInstance();
        for (int i = 0; i < list.size(); i ++){
            System.out.println(list.get(i).toString());
        }
    }
}
