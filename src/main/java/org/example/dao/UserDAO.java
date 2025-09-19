package org.example.dao;


import org.example.gui.admingui.rechargeMoney;
import org.example.util.DatabaseConnection;
import org.example.util.userSession;

import javax.swing.*;
import java.sql.*;

public class UserDAO {
    //
    //CHECK USERNAME VÀ MẬT KHẨU
    //
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
    //
    //LẤY ID
    //
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
    //
    // LẤY ROLE CỦA USER
    //
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
    //
    //LẤY TẤT CẢ USERNAME
    //
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
    //
    //TẠO ACCOUNT (ADMIN) TẠI MÀN HÌNH ĐĂNG KÍ
    //
    public static boolean createAccount (String username, String password) {
        try (Connection conn = DatabaseConnection.getConnection();){
            //thuc thi ket noi

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
    //
    //TẠO TÀI KHOẢN KHÁCH
    //
    public static boolean createUserAccount (String username, String password) {
        try(Connection conn = DatabaseConnection.getConnection();) {
            //thuc thi ket noi
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
    //
    //XÓA TÀI KHOẢN KHÁCH
    //
    public static void deleteUserAccount (String username) {
        try (Connection conn = DatabaseConnection.getConnection();){

            String sql = "DELETE FROM users\n" +
                         "WHERE username = ?;\n";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    //
    //NẠP TIỀN CHO KHÁCH
    //
    public static void chargeMoney (rechargeMoney rc, int chargeAmount, String username) {
        try (Connection conn = DatabaseConnection.getConnection();){

            String sql = "UPDATE users\n" +
                         "SET balance = balance + ?\n" +
                         "WHERE username = ?;";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, chargeAmount);
            stmt.setString(2, username);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(rc, "Nạp thành công!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(rc, "Nạp thất bại, vui lòng thử lại!");
            throw new RuntimeException(e);

        }
    }
    //
    // TÍNH TỔNG GIỜ SỬ DỤNG TRONG CÁC PHIÊN ĐĂNG NHẬP
    //

    public static void useTime (String username) {
        try (Connection conn = DatabaseConnection.getConnection();){

            String sql = "UPDATE users\n" +
                         "SET usetime = usetime + ?\n" +
                         "WHERE username = ?;";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, userSession.sessionTime());
            stmt.setString(2, username);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //
    // LẤY SỐ DƯ
    //

    public static long getUserBalance (String Username) {
        try ( Connection conn = DatabaseConnection.getConnection()) {
            String sql= "SELECT balance\n" +
                        "FROM users\n" +
                        "WHERE username = ?;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, Username);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getLong("balance");
        }
        catch (Exception e){
            e.printStackTrace();

        }
        return 0;
    }
    //
    // LẤY TỔNG THỜI GIAN SỬ DỤNG
    //

    public static int getUserUseTime (String Username) {
        try ( Connection conn = DatabaseConnection.getConnection()) {
            String sql= "SELECT usetime\n" +
                        "FROM users\n" +
                        "WHERE username = ?;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, Username);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getInt("usetime");
        }
        catch (Exception e){
            e.printStackTrace();

        }
        return 0;
    }

    //
    // LẤY TỔNG ĐƠN
    //

}
