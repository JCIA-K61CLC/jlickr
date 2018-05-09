package com.jcia.jlickr.database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBUtils {
    private static String url;
    private static String user;
    private static String password;
    private static Connection connection;
    private static Statement statement;

    private static DBUtils dbUtils = new DBUtils();

    private  DBUtils(){}

    static {
        Properties p = new Properties();
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream input = classLoader.getResourceAsStream("app.properties");
            p.load(input);
            Class.forName("com.mysql.jdbc.Driver");
            url = p.getProperty("db.url");
            user = p.getProperty("db.user");
            password = p.getProperty("db.password");
            connection = (Connection) DriverManager.getConnection(url, user, password);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if(connection == null) {
            throw new NullPointerException("Connection is null");
        }
    }

    public static DBUtils getInstance(){
        return dbUtils;
    }



    public static Connection getConnection() {
        return connection;
    }

}
