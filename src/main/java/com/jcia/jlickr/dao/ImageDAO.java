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

        String sqlCommand = "INSERT INTO images(id, name,photo) VALUES(?, ?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sqlCommand);
            ps.setInt(1, image.getIdUser());
            ps.setString(2, image.getName());
            ps.setBlob(3, image.getPhoto());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Image> deleteImage(String name, int idUser){
        Connection connection = DBUtils.getConnection();
        String sqlCommand ="DELETE FROM images WHERE name like ? AND id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sqlCommand);
            System.out.println("dao " + name);
            ps.setString(1, name);
            ps.setInt(2, idUser);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return getImagesById(idUser);
    }

    public List<Image> getImagesById(int idUser){
        List<Image> ImageList = new ArrayList();
        Connection connection = DBUtils.getConnection();
        String sqlCommand = "select * from images where id = "+ idUser;
        ResultSet rs = retrieveData(sqlCommand);
        try {
            int count = 1;
            while (rs.next()){
                Image image = new Image(rs.getInt("id"),rs.getString("name"),rs.getBinaryStream("photo"));
                image.setNumberOrder(count);
                count++;
                System.out.println(rs.getInt("id"));
                System.out.println(rs.getString("name"));
                //ImageList.add(rs.getString("link"));
                /*Blob blob = rs.getBlob("photo");
                InputStream inputStream = blob.getBinaryStream();*/
                ImageList.add(image);
            }
            return ImageList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
