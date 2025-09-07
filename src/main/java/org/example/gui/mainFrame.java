package org.example.gui;
import javax.swing.*;
import java.awt.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.example.dao.Get;


public class mainFrame extends JFrame {
//    private JPanel functionPanel;
//    private JButton addGuest;
//    private JButton OrderManager;
//    private JButton computerManager;
//    private JButton guestManager;
//
//    public mainFrame(String title, int w, int h) {
//        super(title, w, h);
//        functionPanel = new JPanel();
//
//    }
    public mainFrame() {
        setTitle("Demo Layout");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600); // to ra cho giống app desktop
        setLocationRelativeTo(null); // căn giữa màn hình

        //tittle o day
        JLabel label = new JLabel("Xin chào, " + "Khoa");
        label.setFont(new Font("Arial", Font.PLAIN, 28));
        label.setHorizontalAlignment(SwingConstants.LEFT);
        label.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // padding

        //panel o day
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createTitledBorder("JPanel"));
        buttonPanel.setLayout(new GridLayout(3, 4, 20, 20));
        // 3 hàng, 4 cột, khoảng cách 20px

        // button o day
        JButton btn1 = new JButton("JButton 1");
        JButton btn2 = new JButton("JButton 2");
        JButton btn3 = new JButton("JButton 3");
        JButton btn4 = new JButton("JButton 4");
        JButton btn5 = new JButton("JButton 5");
        JButton btn6 = new JButton("JButton 6");

        buttonPanel.add(btn1);
        buttonPanel.add(btn2);
        buttonPanel.add(btn3);
        buttonPanel.add(btn4);
        buttonPanel.add(btn5);
        buttonPanel.add(btn6);


        // can chinh bo cuc
        setLayout(new BorderLayout(20, 20));
        add(label, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);
    }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(mainFrame::new);
        }
}
