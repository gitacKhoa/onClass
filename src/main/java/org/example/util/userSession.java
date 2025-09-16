package org.example.util;

public class userSession {
    private static userSession session;
    private String username;
    private String role;
    private int userid;

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
}
