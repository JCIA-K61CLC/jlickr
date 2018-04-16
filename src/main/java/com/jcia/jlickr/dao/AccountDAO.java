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
        String sqlCommand = "Insert INTO accounts value(?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sqlCommand);
            ps.setString(1, ac.getUserName());
            ps.setString(2,ac.getBirthdate());
            ps.setString(3,ac.getGmail());
            ps.setString(4, ac.getPassword());
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
                acc = new Account(rs.getString("name"),rs.getString("birthdate"), rs.getString("gmail"), rs.getString("password"));
                accList.add(acc);
            }
            return accList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
