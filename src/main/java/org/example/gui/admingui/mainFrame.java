package org.example.gui.admingui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


import org.example.dao.UserDAO;
import org.example.util.userSession;

import static org.example.util.userSession.getSession;


public class mainFrame extends JFrame {
    JButton btn1;
    JButton btn2;
    JButton btn3;
    JButton btn4;

    JPanel buttonPanel;
    JPanel headerPanel;

    JLabel label;
    JLabel name;

    String titleName;
    public void mainFrameInit(mainFrame mainFrame) {
        mainFrame.setTitle("NetControl");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.getContentPane().setPreferredSize(new Dimension(1000, 600));
        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setLayout(null);
        mainFrame.setResizable(false);


        titleName= getSession().getUsername();
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
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Quản lí quán Net"));
        buttonPanel.setLayout(null);

        mainFrame.add(buttonPanel);


        // button o day
        btn1 = new JButton("Quản lí tài khoản khách");
        btn1.setFont(new Font("ProductSans", Font.BOLD, 25));
        btn2 = new JButton("Quản lí dịch vụ quán");
        btn2.setFont(new Font("ProductSans", Font.BOLD, 25));
        btn3 = new JButton("Chat");
        btn3.setFont(new Font("ProductSans", Font.BOLD, 25));
        btn4 = new JButton("Quản lí máy");
        btn4.setFont(new Font("ProductSans", Font.BOLD, 25));
        btn1.setBounds(19,50, 443,144);
        btn2.setBounds(482, 50, 443,144);
        btn3.setBounds(19, 214, 443,144);
        btn4.setBounds(482, 214, 443,144);

        buttonPanel.add(btn1);
        buttonPanel.add(btn2);
        buttonPanel.add(btn3);
        buttonPanel.add(btn4);

        btn1.addActionListener(e -> {
            eraseFrame();
            userAccountManager mngframe= new userAccountManager();
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

        // can chinh bo cuc
        mainFrame.setVisible(true);
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                userSession.timerEnd();
                System.out.println("chuong trinh ket thuc");
                userSession.sessionTime();
                UserDAO.useTime(titleName);
            }
        });
    }

        public static void main(String[] args) {
            new mainFrame();
        }
        public void eraseFrame () {
            this.getContentPane().removeAll();
            this.revalidate();
            this.repaint();
        }

}
