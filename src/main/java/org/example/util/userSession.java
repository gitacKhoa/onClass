package org.example.util;

import java.io.IOException;

public class userSession {
    private static userSession session;
    private String username;
    private String role;
    private int userid;
    private static long sessionTimerStart;
    private static long sessionTimerEnd;
    public userSession (String username, String role, int userid) {
        this.role= role;
        this.userid = userid;
        this.username = username;
    }

    public static void createSession (String username, String role, int userid) {
        session = new userSession(username, role, userid);

    }

    public static userSession getSession () {
        return session;
    }

    public void clearSession () {
        session = null;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }

    public int getUserid() {
        return userid;
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
