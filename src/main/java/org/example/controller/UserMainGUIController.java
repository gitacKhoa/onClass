package org.example.controller;

import org.example.dao.UserDAO;
import org.example.gui.NetManagerGUI;
import org.example.gui.usergui.UserMainGUI;
import org.example.util.UserSession;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class UserMainGUIController {
    public UserMainGUIController(UserMainGUI frame) {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                UserSession.timerEnd();
                UserSession.sessionTime();
                UserDAO.addUseTime(UserSession.getSession().getUser().getUsername());
                UserSession.getSession().clearSession();

            }
        });
    }
}
