package org.example.dao;

import org.example.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Get {
    public static boolean haveOne(String table, String row, String key) {

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql ="SELECT 1 \n" +
                        "FROM " + table +"\n" +
                        "WHERE " + row + " = ? \n" +
                        "LIMIT 1;";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString( 1, key);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {

                return true;

            }
        }
        catch (Exception e) {
            //in ra loi
        }

        return false;
    }
}
