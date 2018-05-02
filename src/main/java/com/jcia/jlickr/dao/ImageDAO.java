package com.jcia.jlickr.dao;

import com.jcia.jlickr.database.DBUtils;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
//    public static void loadImage(String filePath){
//        Connection connection = DBUtils.getConnection();
//        int BUFFER_SIZE = 2048;
//        String mysql = "select * from images";
//        PreparedStatement statement = connection.prepareStatement()
//    }
    public void addImage(Image image ){
        Connection connection = DBUtils.getConnection();

        String sqlCommand = "INSERT INTO images(id, link) VALUES(?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sqlCommand);
            ps.setInt(1, image.getIdUser());
            ps.setString(2, image.getLink());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> getImagesById(int idUser){
        List<String> ImageList = new ArrayList();
        Connection connection = DBUtils.getConnection();
        String sqlCommand = "select * from images where id = "+ idUser;
        ResultSet rs = retrieveData(sqlCommand);
        try {
            while (rs.next()){
                ImageList.add(rs.getString("link"));
            }
            return ImageList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
