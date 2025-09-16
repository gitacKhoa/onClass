package org.example.gui.admingui;
import javax.swing.*;
import java.awt.*;


import org.example.util.userSession;


public class mainFrame extends JFrame {
    JButton btn1;
    JButton btn2;
    JButton btn3;
    JButton btn4;
    JPanel buttonPanel;
    JLabel label;
    String titleName;
    public mainFrame() {
        setTitle("NetControl");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setPreferredSize(new Dimension(1000, 600));
        pack();
        setLocationRelativeTo(null); // căn giữa màn hình
        setLayout(null);
        setResizable(false);
        //tittle o day

        titleName = "xinchao";//userSession.getSession().getUsername();
        label = new JLabel("Xin chào, " + titleName);
        label.setFont(new Font("Arial", Font.PLAIN, 28));
        label.setBounds(20, 20, 400, 40);
        label.setHorizontalAlignment(SwingConstants.LEFT);
        label.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // padding

        //panel o day
        buttonPanel = new JPanel();
        buttonPanel.setBounds(40, 100, 900, 400); // panel nằm trong frame
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Quản lí quán Net"));
        buttonPanel.setLayout(null);

        add(buttonPanel);

        // 3 hàng, 4 cột, khoảng cách 20px

        // button o day
        btn1 = new JButton("Quản lí tài khoản khách");
        btn1.setFont(new Font("ProductSans", Font.PLAIN, 15));
        btn2 = new JButton("Quản lí dịch vụ quán");
        btn2.setFont(new Font("ProductSans", Font.PLAIN, 15));
        btn3 = new JButton("Chat");
        btn3.setFont(new Font("ProductSans", Font.PLAIN, 15));
        btn4 = new JButton("Quản lí máy");
        btn4.setFont(new Font("ProductSans", Font.PLAIN, 15));
        btn1.setBounds(117, 74, 252, 106);
        btn2.setBounds(531, 74, 252, 106);
        btn3.setBounds(117, 220, 252, 106);
        btn4.setBounds(531, 220, 252, 106);

        buttonPanel.add(btn1);
        buttonPanel.add(btn2);
        buttonPanel.add(btn3);
        buttonPanel.add(btn4);




        btn1.addActionListener(e -> {
            eraseFrame();
            new userAccountManager().init(this);

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
        add(label);

        setVisible(true);
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
