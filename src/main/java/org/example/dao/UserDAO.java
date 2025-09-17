package org.example.dao;


import org.example.util.DatabaseConnection;

import javax.swing.*;
import java.sql.*;

public class UserDAO {
    public static String checkUsername (String Username) {
        try ( Connection conn = DatabaseConnection.getConnection()) {
            String sql= "SELECT password_hash\n" +
                    "FROM users\n" +
                    "WHERE username = ?;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, Username);
            ResultSet rs = stmt.executeQuery();
            if ( rs.next()) {
                String returnPassword = rs.getString("password_hash");
                return returnPassword;
            }
            else {
                return "";
            }
        }
        catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }
    public static int getUserID (String Username) {
        try ( Connection conn = DatabaseConnection.getConnection()) {
            String sql= "SELECT user_id\n" +
                        "FROM users\n" +
                        "WHERE username = ?;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, Username);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getInt("user_id");
        }
        catch (Exception e){
            e.printStackTrace();

        }
        return 0;
    }

    public static String getUserRole (String Username) {
        try ( Connection conn = DatabaseConnection.getConnection()) {
            String sql= "SELECT user_role\n" +
                    "FROM users\n" +
                    "WHERE username = ?;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, Username);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getString("user_role");
        }
        catch (Exception e){
            e.printStackTrace();

        }
        return null;
    }

    public static void getAllUsername (DefaultListModel <String> model){
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT username\n" +
                         "FROM users\n";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model.addElement(rs.getString("username"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static boolean createAccount (String username, String password) {
        try {
            //thuc thi ket noi
            Connection conn = DatabaseConnection.getConnection();
            String sql = "INSERT INTO users (username, password_hash, user_role) VALUES (?, ?, 'admin');";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1,username);
            stm.setString(2, password);
            //kiem tra xem da co tai khoan chua
            if (!Get.haveOne("users", "username", username)) {
                stm.executeUpdate();

                return true;
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public static boolean createUserAccount (String username, String password) {
        try {
            //thuc thi ket noi
            Connection conn = DatabaseConnection.getConnection();
            String sql = "INSERT INTO users (username, password_hash) VALUES (?, ?);";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1,username);
            stm.setString(2, password);
            //kiem tra xem da co tai khoan chua
            if (!Get.haveOne("users", "username", username)) {
                stm.executeUpdate();

                return true;
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
    public static void deleteUserAccount (String username) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "DELETE FROM users\n" +
                         "WHERE username = ?;\n";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
