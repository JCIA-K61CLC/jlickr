package com.jcia.jlickr.dao;

import com.jcia.jlickr.database.DBUtils;

import java.sql.*;

public class ImageDAO {
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

    public void addImage(Image image){
        Connection connection = DBUtils.getConnection();
        String sqlCommand = "INSERT INTO DATA VALUES(?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sqlCommand);
            ps.setInt(1, image.getIdUser());
            ps.setString(2, image.getLink());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
