package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String PASSWORD = "tiMi1501";
    private static final String URL = "jdbc:mysql://localhost:3306/quanliquannet";
    private static final String USER = "root";

    public static Connection getConnection () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}