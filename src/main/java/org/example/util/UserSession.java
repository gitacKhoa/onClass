package org.example.util;

import org.example.model.User;

public class UserSession {
    private static UserSession session;
    private User user;
    private static long sessionTimerStart;
    private static long sessionTimerEnd;
    public UserSession(User user) {
        this.user = user;
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

    public static long getSessionTimerStart() {
        return sessionTimerStart;
    }

    public static long getSessionTimerEnd() {
        return sessionTimerEnd;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static void setSessionTimerStart(long sessionTimerStart) {
        UserSession.sessionTimerStart = sessionTimerStart;
    }

    public static void setSessionTimerEnd(long sessionTimerEnd) {
        UserSession.sessionTimerEnd = sessionTimerEnd;
    }

    //
    // QUẢN LÍ THỜI GIAN NGƯỜI DÙNG ĐĂNG NHẬP
    //
    public static void timerStart (){
        sessionTimerStart = System.currentTimeMillis();
    }
    public static void timerEnd() {
        sessionTimerEnd = System.currentTimeMillis();
    }

    public static long sessionTime () {
        long minutes = (sessionTimerEnd - sessionTimerStart)/(1000 * 60);
        return minutes;
    }
}
