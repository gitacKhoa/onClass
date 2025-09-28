package org.example.gui.usergui;

import org.example.controller.UserMainGUIController;
import org.example.gui.NetManagerGUI;

import javax.swing.*;
import java.awt.*;

import static org.example.util.UserSession.getSession;

public class UserMainGUI extends NetManagerGUI {

    JPanel buttonPanel;
    JPanel headerPanel;

    JLabel label;
    JLabel name;

    String titleName;
    public UserMainGUI(String title, int width, int height) {
        super(title, width, height);
    }
    public void mainFrameInit(UserMainGUI mainFrame) {
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        titleName= getSession().getUser().getUsername();
        headerPanel = new JPanel();
        headerPanel.setVisible(true);
        headerPanel.setLayout(null);
        headerPanel.setBounds(29,31,944,113);
        mainFrame.add(headerPanel);


        label = new JLabel("Xin chào,");
        headerPanel.add(label);
        label.setBounds(0, 13, 400, 29);
        label.setFont(new Font("Arial", Font.PLAIN, 24));

        name = new JLabel(titleName);
        headerPanel.add(name);
        name.setBounds(0, 36,321,77);
        name.setFont(new Font("Arial", Font.BOLD, 64));

        //panel o day
        buttonPanel = new JPanel();
        buttonPanel.setBounds(29,164, 944, 407); // panel nằm trong frame
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Dịch vụ quán net"));
        buttonPanel.setLayout(null);

        mainFrame.add(buttonPanel);

        UserMainGUIController controller = new UserMainGUIController(this);

    }

    public static void main(String[] args) {
    }
}
