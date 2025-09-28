package org.example.gui.admingui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


import org.example.dao.UserDAO;
import org.example.gui.LoginGUI;
import org.example.util.UserSession;

import static org.example.util.UserSession.getSession;


public class AdminMainGUI extends JFrame {
    JButton btn1;
    JButton btn2;
    JButton btn3;
    JButton btn4;
    JButton signOut;

    JPanel buttonPanel;
    JPanel headerPanel;

    JLabel label;
    JLabel name;

    String titleName;
    public void mainFrameInit(AdminMainGUI mainFrame) {
        mainFrame.setTitle("NetControl");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.getContentPane().setPreferredSize(new Dimension(1000, 600));
        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setLayout(null);
        mainFrame.setResizable(false);


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


        // button o day
        btn1 = new JButton("Quản lí tài khoản khách");
        btn1.setFont(new Font("ProductSans", Font.BOLD, 25));
        btn2 = new JButton("Quản lí dịch vụ quán");
        btn2.setFont(new Font("ProductSans", Font.BOLD, 25));
        btn3 = new JButton("Chat");
        btn3.setFont(new Font("ProductSans", Font.BOLD, 25));
        btn4 = new JButton("Thống kê");
        btn4.setFont(new Font("ProductSans", Font.BOLD, 25));
        signOut = new JButton("Đăng xuất");
        btn1.setBounds(19,50, 443,144);
        btn2.setBounds(482, 50, 443,144);
        btn3.setBounds(19, 214, 443,144);
        btn4.setBounds(482, 214, 443,144);
        signOut.setBounds(810,366,115,32);

        buttonPanel.add(btn1);
        buttonPanel.add(btn2);
        buttonPanel.add(btn3);
        buttonPanel.add(btn4);
        buttonPanel.add(signOut);

        btn1.addActionListener(e -> {
            eraseFrame();
            UserAccountManagerGUI mngframe= new UserAccountManagerGUI();
            mngframe.init(this);
        });
        btn2.addActionListener(e -> {
            eraseFrame();
        });
        btn3.addActionListener(e -> {
            eraseFrame();
        });
        btn4.addActionListener(e -> {
            eraseFrame();
        });

        signOut.addActionListener(e -> {
            UserSession.timerEnd();
            UserSession.getSession().clearSession();
            dispose();
            new LoginGUI().setVisible(true);
        });


        mainFrame.setVisible(true);


        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                UserSession.timerEnd();
                UserSession.sessionTime();
                UserSession.getSession().clearSession();
                UserDAO.useTime(titleName);
            }
        });
    }

        public static void main(String[] args) {
            new AdminMainGUI();
        }
        public void eraseFrame () {
            this.getContentPane().removeAll();
            this.revalidate();
            this.repaint();
        }

}
