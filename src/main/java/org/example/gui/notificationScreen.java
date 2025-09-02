package org.example.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class notificationScreen extends JFrame {
    JLabel notification;
    JButton OkButton;

    public notificationScreen(String s) {
        setLocationRelativeTo(null);
        setSize(400, 200); // chỉnh lại size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Label hiển thị thông báo
        notification = new JLabel(s);
        notification.setHorizontalAlignment(SwingConstants.CENTER);  // căn giữa ngang
        notification.setVerticalAlignment(SwingConstants.CENTER);    // căn giữa dọc

        // Nút OK
        OkButton = new JButton("OK");
        OkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        // Panel chứa nút OK để căn giữa
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(OkButton);

        setLayout(new BorderLayout());
        add(notification, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new notificationScreen("Thông báo đã lưu thành công!");
    }
}
