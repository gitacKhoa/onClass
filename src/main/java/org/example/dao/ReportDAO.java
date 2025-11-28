/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.example.model.Report;
import org.example.util.DatabaseConnection;

/**
 *
 * @author khoa
 */
public class ReportDAO {
    
    // 1. Lưu 1 report vào database
    public boolean insertReport(Report report) {
        String sql = """
            INSERT INTO reports (title, main, user_id)
            VALUES (?, ?, ?)
        """;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, report.getTitle());
            ps.setString(2, report.getMain());
            ps.setInt(3, report.getUser_id());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean deleteReport(int reportId) {
        String sql = "DELETE FROM reports WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, reportId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    // 2. Lấy report theo id
    public Report getReportById(int id) {
        String sql = "SELECT * FROM reports WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Report(
                        rs.getString("title"),
                        rs.getString("main"),
                        rs.getInt("user_id"),
                        rs.getInt("id")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // 3. Lấy tất cả report
    public List<Report> getAllReports() {
        List<Report> list = new ArrayList<>();
        String sql = "SELECT * FROM reports";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Report r = new Report(
                    rs.getString("title"),
                    rs.getString("main"),
                    rs.getInt("user_id"),
                    rs.getInt("id")
                );
                list.add(r);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // 4. Lấy các report theo user_id
    public List<Report> getReportsByUserId(int userId) {
        List<Report> list = new ArrayList<>();
        String sql = "SELECT * FROM reports WHERE user_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, userId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Report r = new Report(
                        rs.getString("title"),
                        rs.getString("main"),
                        rs.getInt("user_id"),
                        rs.getInt("id")
                    );
                    list.add(r);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}

