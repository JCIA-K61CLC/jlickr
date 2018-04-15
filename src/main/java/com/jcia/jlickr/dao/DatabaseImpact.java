package com.jcia.jlickr.dao;

import com.jcia.jlickr.database.DBUtils;

import java.sql.*;

public class DatabaseImpact {

    public static ResultSet retrieveData(String sqlCommand) {
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

    public static void addAccountToDatabase(Account ac){
        Connection connection = DBUtils.getConnection();
        String sqlCommand = "Insert INTO accounts value(?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sqlCommand);
            ps.setString(1, ac.getUserName());
            ps.setString(2,ac.getBirthdate());
            ps.setString(3,ac.getGmail());
            ps.setString(4, ac.getPassword());
            ps.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }



}
