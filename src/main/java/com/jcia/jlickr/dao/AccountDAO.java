package com.jcia.jlickr.dao;

import com.jcia.jlickr.database.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {
    public AccountDAO() {
    }
    public ResultSet retrieveData(String sqlCommand) {
        Connection connection = DBUtils.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlCommand);
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }

    public void addAccount(Account ac){
        Connection connection = DBUtils.getConnection();
        String sqlCommand = "Insert INTO accounts(username, password, birthday,gmail) value(?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sqlCommand);
            ps.setString(1, ac.getUserName());
            ps.setString(2,ac.getPassword());
            ps.setString(3,ac.getBirthday());
            ps.setString(4, ac.getGmail());
            ps.executeUpdate();
//            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public List<Account> getAllAccounts(){
        List<Account> accList = new ArrayList();
        Connection connection = DBUtils.getConnection();
        String sqlCommand = "select * from accounts";
        ResultSet rs = retrieveData(sqlCommand);
        try {
            while (rs.next()){
                Account acc = null;
                int idUser = rs.getInt("id");
                acc = new Account(rs.getString("username"),rs.getString("password"), rs.getString("birthday"), rs.getString("gmail"));
                acc.setIdUser(idUser);
                accList.add(acc);
            }
            return accList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
