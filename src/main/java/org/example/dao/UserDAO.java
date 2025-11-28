/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static java.sql.Types.VARCHAR;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import org.example.gui.admingui.RechargeMoneyGUI;
import org.example.model.User;
import org.example.util.DatabaseConnection;

/**
 *
 * @author khoa
 */
public class UserDAO {

    //
    //CHECK USERNAME VÀ MẬT KHẨU
    //
    public String checkUsername(String Username) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT password_hash\n" + "FROM users\n" + "WHERE username = ?;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, Username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String returnPassword = rs.getString("password_hash");
                return returnPassword;
            } else {
                return "";
            }
        } catch (Exception e) {
            throw new SQLException(e);
        }
    }

    //
    //TẠO ACCOUNT (ADMIN) TẠI MÀN HÌNH ĐĂNG KÍ
    //
    public int createAccount(String username, String password, String adminKey) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            //thuc thi ket noi
            if (adminKey.equals("")) {
                String sql = "INSERT INTO users (username, password_hash, user_role) VALUES (?, ?, 'user');";
                PreparedStatement stm = conn.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                //kiem tra xem da co tai khoan chua
                System.out.println("hello");
                if (!haveOne("users", "username", username)) {
                    stm.executeUpdate();
                    return 1;
                }
            } else if (adminKey.equals("THISISADMIN123")) {
                String sql = "INSERT INTO users (username, password_hash, user_role) VALUES (?, ?, 'admin');";
                PreparedStatement stm = conn.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                if (!haveOne("users", "username", username)) {
                    stm.executeUpdate();
                    return 1;
                }
            } else {
                return 2;
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        return 0;
    }

    //
    //TẠO TÀI KHOẢN KHÁCH
    //
    public boolean createUserAccount(User user) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO users (username, password_hash) VALUES (?, ?);";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, user.getUsername());
            stm.setString(2, user.getPassword());
            if (!haveOne("users", "username", user.getUsername())) {
                stm.executeUpdate();
                return true;
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        return false;
    }

    //
    //NẠP TIỀN CHO KHÁCH
    //
    public void chargeMoney( int chargeAmount, String username) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "UPDATE users\n" + "SET balance = balance + ?\n" + "WHERE username = ?;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, chargeAmount);
            stmt.setString(2, username);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Nạp thành công!");
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }
    //
    // TÍNH TỔNG GIỜ SỬ DỤNG TRONG CÁC PHIÊN ĐĂNG NHẬP
    //

    //
    //LẤY TẤT CẢ USERNAME
    //
    public void getAllUsername(DefaultListModel<String> model) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT username\n" + "FROM users\n";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model.addElement(rs.getString("username"));
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public User getUserByUsername(String username) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT user_id, username, password_hash, user_role, balance, usetime " + "FROM users WHERE username = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("user_id");
                String username1 = rs.getString("username");
                String password = rs.getString("password_hash");
                String role = rs.getString("user_role");
                long balance = rs.getLong("balance");
                long useTime = rs.getLong("usetime");
                return new User(id, username1, password, role, balance, useTime);
            } else {
                return null; // không tìm thấy user
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getUserUseTime(String Username) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT usetime\n" + "FROM users\n" + "WHERE username = ?;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, Username);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getInt("usetime");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    //
    //XÓA TÀI KHOẢN KHÁCH
    //
    public void deleteUserAccount(String username) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "DELETE FROM users\n" + "WHERE username = ?;\n";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    //
    // LẤY SỐ DƯ
    //
    public long getUserBalance(String Username) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT balance\n" + "FROM users\n" + "WHERE username = ?;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, Username);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getLong("balance");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    //
    // LẤY TỔNG THỜI GIAN SỬ DỤNG
    //

    //
    //LẤY ID
    //
    public int getUserID(String Username) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT user_id\n" + "FROM users\n" + "WHERE username = ?;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, Username);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getInt("user_id");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    //
    // LẤY ROLE CỦA USER
    //
    public String getUserRole(String Username) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT user_role\n" + "FROM users\n" + "WHERE username = ?;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, Username);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getString("user_role");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean haveOne(String table, String row, String key) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT 1 \n" + "FROM ?  \n" + "WHERE ? = ? \n" + "LIMIT 1;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, table);
            stmt.setString(2, row);
            stmt.setString(3, key);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
        }
        System.out.println("sai");
        return false;
    }

    public User getUserById(int userId) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT user_id, username, password_hash, user_role, balance, usetime " + "FROM users WHERE user_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("user_id");
                String username = rs.getString("username");
                String password = rs.getString("password_hash");
                String role = rs.getString("user_role");
                long balance = rs.getLong("balance");
                long useTime = rs.getLong("usetime");
                return new User(id, username, password, role, balance, useTime);
            } else {
                return null; // không tìm thấy user
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void adjustBalance(String username, long a) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "UPDATE users\n" + "SET balance = balance + ?\n" + "WHERE username = ?;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, a);
            stmt.setString(2, username);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addUseTime(String username) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "UPDATE users\n" + "SET usetime = usetime + ?\n" + "WHERE username = ?;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, 1);
            stmt.setString(2, username);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getUsername(int userId) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT username\n" + "FROM users\n" + "WHERE user_id = ?;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getString("username");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "#";
    }

    //
    //Gán tất cả thông tin cho user
    //
    public void setUser(String username, User user) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT *\n" + "FROM users\n" + "WHERE BINARY username = ?;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            user.setUserId(rs.getInt("user_id"));
            user.setUsername(rs.getString("username"));
            user.setUserRole(rs.getString("user_role"));
            user.setBalance(rs.getLong("balance"));
            user.setUseTime(rs.getLong("usetime"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean updateUser(int userId, User user) {
        String sql = """
        UPDATE users
        SET  email = ?, phone_number = ?
        WHERE user_id = ?
        """;

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            // KIỂM TRA NGƯỜI DÙNG CO
            if (user.getEmail() == null) { //NẾU EMAIL
                ps.setNull(1, VARCHAR);
            } else {
                ps.setString(1, user.getEmail());
            }

            // phone_number
            if (user.getPhone() == null) {
                ps.setNull(2, VARCHAR);
            } else {
                ps.setString(2, user.getPhone());
            }

            ps.setInt(3, userId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    // THỰC THI ĐỔI MẬT KHẨU BẰNG CÁCH KẾT NỐI VỚI MYSQL
    // TRẢ VỀ ĐÚNG/SAI (THÀNH CÔNG/THẤT BẠI)
    public boolean updatePassword(int userId, String password) {
        String sql = """
        UPDATE users
        SET password_hash = ?
        WHERE user_id = ?
        """;

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            //TRUYỀN DỮ LIỆU VÀO CÂU LỆNH - KHỚP LỆNH
            ps.setString(1, password);
            ps.setInt(2, userId);
            
            //THỰC THI CÂU LỆNH TRONG MYSQL
            return (ps.executeUpdate() > 0);  //ps.executeUpdate() SẼ  TRẢ VỀ 1 DỮ LIỆU ĐÚNG/SAI (THÀNH CÔNG/THAATSBAIJ)
                    
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public User getUserById1(int userId) {
        String sql = "SELECT * FROM users WHERE user_id = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, userId);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    User user = new User();

                    user.setUserId(rs.getInt("user_id"));
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password_hash"));
                    user.setBalance(rs.getLong("balance"));
                    user.setUseTime(rs.getLong("usetime"));
                    user.setUserRole(rs.getString("user_role"));
                    user.setRank(rs.getString("user_rank"));
                    user.setEmail(rs.getString("email"));
                    user.setPhone(rs.getString("phone_number"));

                    return user;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // không có user
    }
    //
    // NÂNG HẠNG TÀI KHOẢN
    //
    public boolean rankUp(String username, String newRank) {
        // Câu SQL cập nhật rank mới
        String sql = "UPDATE users SET user_rank = ? WHERE username = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            // Truyền giá trị hạng mới
            ps.setString(1, newRank);

            // Truyền username cần nâng hạng
            ps.setString(2, username);

            // Thực thi update
            int rowsAffected = ps.executeUpdate();

            // Nếu có ít nhất 1 dòng bị ảnh hưởng thì update thành công
            return rowsAffected > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
