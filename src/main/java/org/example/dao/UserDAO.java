package org.example.dao;


import org.example.util.DatabaseConnection;

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
}
