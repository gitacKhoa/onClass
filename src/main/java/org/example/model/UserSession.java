package org.example.model;

import com.mysql.cj.Session;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import org.example.dao.UserDAO;

import org.example.model.User;
import org.example.util.DatabaseConnection;

public class UserSession {
    private int sessionId;
    private User user;
    private LocalDateTime sessionStart;
    private LocalDateTime sessionEnd;
    private long sessionTime;
    
    private static UserSession session;
    private static LocalDateTime sessionTimerStart;
    private static LocalDateTime sessionTimerEnd;
    
    public UserSession(User user) {
        this.user = user;
    }
    
    public UserSession(int sessionId, User user, LocalDateTime sessionStart, LocalDateTime sessionEnd, long sessionTime) {
        this.user = user;
        this.sessionId = sessionId;
        this.sessionEnd=sessionEnd;
        this.sessionStart=sessionStart;
        this.sessionTime=sessionTime;
    }

    public UserSession(User user, LocalDateTime sessionStart, LocalDateTime sessionEnd, long sessionTime) {
        this.user = user;
        this.sessionStart = sessionStart;
        this.sessionEnd = sessionEnd;
        this.sessionTime = sessionTime;
    }
    

    public static void createSession (User user) {
        session = new UserSession(user);
    }

    public static UserSession getSession () {
        return session;
    }

    public void clearSession () {
        session = null;
    }

    public User getUser() {
        return user;
    }

    public static LocalDateTime getSessionTimerStart() {
        return sessionTimerStart;
    }

    public static LocalDateTime getSessionTimerEnd() {
        return sessionTimerEnd;
    }

    public void setUser(User user) {
        this.user = user;
    }

    
        public int getSessionId() {
        return sessionId;
    }

    public LocalDateTime getSessionStart() {
        return sessionStart;
    }

    public LocalDateTime getSessionEnd() {
        return sessionEnd;
    }

    public long getSessionTime() {
        return sessionTime;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public void setSessionStart(LocalDateTime sessionStart) {
        this.sessionStart = sessionStart;
    }

    public void setSessionEnd(LocalDateTime sessionEnd) {
        this.sessionEnd = sessionEnd;
    }

    public void setSessionTime(long sessionTime) {
        this.sessionTime = sessionTime;
    }

    public static void setSession(UserSession session) {
        UserSession.session = session;
    }
    
    
    public static void setSessionTimerStart(LocalDateTime sessionTimerStart) {
        UserSession.sessionTimerStart = sessionTimerStart;
    }

    public static void setSessionTimerEnd(LocalDateTime sessionTimerEnd) {
        UserSession.sessionTimerEnd = sessionTimerEnd;
    }

    //
    // QUẢN LÍ THỜI GIAN NGƯỜI DÙNG ĐĂNG NHẬP
    //
    public static void timerStart (){
        sessionTimerStart = LocalDateTime.now();
    }
    public static void timerEnd() {
        sessionTimerEnd = LocalDateTime.now();
    }

    public static long sessionTime () {
        long seconds = Duration.between(sessionTimerStart, sessionTimerEnd).toSeconds();;
        return seconds;
    }
    
    public static boolean saveSession(UserSession session) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO session (user_id, session_start, session_end, session_time) "
                    + "VALUES (?, ?, ?, ?)";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, session.getUser().getUserId());
            stmt.setTimestamp(2, Timestamp.valueOf(session.getSessionStart()));
            stmt.setTimestamp(3, Timestamp.valueOf(session.getSessionEnd()));
            stmt.setLong(4, session.getSessionTime());

            int rows = stmt.executeUpdate();
            return rows > 0;  // true = lưu thành công, false = thất bại
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public static ArrayList <UserSession> getSessionByUserId(int userId) {
        ArrayList<UserSession> list = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT session_id, user_id, session_start, session_end, session_time "
                    + "FROM session WHERE user_id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, userId);

            ResultSet rs = stmt.executeQuery(); //stmt.executeQuery() --> trả về danh sách kết quả mà SQL tìm thấy
            

            //TRUYỀN DỮ LIỆU TỪ RESULT SET (MYSQL) VÀO LIST (JAVA)
            while (rs.next()) {
                int sessionId = rs.getInt("session_id");
                LocalDateTime start = rs.getTimestamp("session_start").toLocalDateTime();
                LocalDateTime end = rs.getTimestamp("session_end").toLocalDateTime();
                long time = rs.getLong("session_time");

                UserSession s = new UserSession(sessionId, new UserDAO().getUserById(userId), start, end, time);
                list.add(s);
            }

            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return list; // trả về list rỗng nếu lỗi
        }
    }

}
