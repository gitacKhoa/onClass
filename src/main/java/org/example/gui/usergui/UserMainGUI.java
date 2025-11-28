    
package org.example.gui.usergui;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.DefaultListCellRenderer;
import javax.swing.*;
import javax.swing.JList;
import javax.swing.border.EmptyBorder;
import org.example.dao.OrderDAO;
import org.example.dao.UserDAO;
import org.example.gui.LoginGUI;
import org.example.model.FoodOrder;
import org.example.model.Order;
import org.example.model.Product;
import org.example.model.User;

import org.example.model.UserSession;
import static org.example.model.UserSession.getSession;


public class UserMainGUI extends javax.swing.JFrame {
    String titleName;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(UserMainGUI.class.getName());
    DefaultListModel<Product> model = new DefaultListModel<>();
    DefaultListModel<Object> orderModel = new DefaultListModel<>();
    
    //LƯU DỮ LIỆU LỊCH SỬ ĐĂNG NHẬP (LIST MODEL)
    DefaultListModel<Object> logModel = new DefaultListModel<>();
    
    
    CountThread count;
    /**
     * Creates new form UserMainGUI
     */
    public UserMainGUI() {
        
        initComponents();
        titleName= getSession().getUser().getUsername();
        name.setText(titleName);
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        //
        //
        //TẠO LUỒNG TÍNH THỜI GIAN VÀ TRỪ TIỀN
        //
        //
        count = new CountThread();
        count.start();
        //
        //QUANR LI LIST
        //
        for (Product x : Product.pdArr) {
            model.addElement(x);
        }
        fillOrderList();
        fillLogList();
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                UserSession.timerEnd();
                UserSession session = new UserSession(UserSession.getSession().getUser(),UserSession.getSessionTimerStart(),UserSession.getSessionTimerEnd(),UserSession.sessionTime()); //user,start,end,time
                UserSession.saveSession(session);
                count.interrupt();
                UserSession.getSession().clearSession();
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        headingPanel = new javax.swing.JPanel();
        name = new javax.swing.JLabel();
        greetingLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblMoney = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        servicesTabPane = new javax.swing.JTabbedPane();
        menuPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        customList1 = new org.example.gui.usergui.CustomList<>();
        btnCharge = new javax.swing.JButton();
        btnOrd = new javax.swing.JButton();
        btnSignOut = new javax.swing.JButton();
        btnRank = new javax.swing.JButton();
        orderPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        orderList1 = new org.example.gui.usergui.OrderList<>();
        logPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        logList1 = new org.example.gui.usergui.LogList<>();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        name.setFont(new java.awt.Font("Product Sans Black", 0, 48)); // NOI18N
        name.setText("Xin chào,");

        greetingLabel.setFont(new java.awt.Font("Product Sans Light", 0, 24)); // NOI18N
        greetingLabel.setText("Xin chào,");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Thời gian còn lại");

        lblTime.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTime.setText("# Phút");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Số dư");

        lblMoney.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblMoney.setText("Số dư");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cog.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/message-circle-exclamation.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout headingPanelLayout = new javax.swing.GroupLayout(headingPanel);
        headingPanel.setLayout(headingPanelLayout);
        headingPanelLayout.setHorizontalGroup(
            headingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(headingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(greetingLabel)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(headingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(6, 6, 6)
                .addGroup(headingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(headingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );
        headingPanelLayout.setVerticalGroup(
            headingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(headingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headingPanelLayout.createSequentialGroup()
                        .addGroup(headingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lblTime))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(headingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(lblMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(headingPanelLayout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(headingPanelLayout.createSequentialGroup()
                        .addComponent(greetingLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        servicesTabPane.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        customList1.setModel(model);
        jScrollPane1.setViewportView(customList1);

        btnCharge.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnCharge.setText("Nạp tiền");
        btnCharge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChargeActionPerformed(evt);
            }
        });

        btnOrd.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnOrd.setText("Tạo đơn");
        btnOrd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdActionPerformed(evt);
            }
        });

        btnSignOut.setText("Đăng xuất");
        btnSignOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignOutActionPerformed(evt);
            }
        });

        btnRank.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnRank.setText("Nâng hạng tài khoản");
        btnRank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRankActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnOrd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCharge, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRank, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(btnSignOut, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26))
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addComponent(btnCharge, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOrd, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRank, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(btnSignOut, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 38, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        servicesTabPane.addTab("Menu", menuPanel);

        orderList1.setModel(orderModel);
        jScrollPane2.setViewportView(orderList1);

        javax.swing.GroupLayout orderPanelLayout = new javax.swing.GroupLayout(orderPanel);
        orderPanel.setLayout(orderPanelLayout);
        orderPanelLayout.setHorizontalGroup(
            orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 753, Short.MAX_VALUE)
                .addContainerGap())
        );
        orderPanelLayout.setVerticalGroup(
            orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        servicesTabPane.addTab("Đơn của bạn", orderPanel);

        logList1.setModel(logModel);
        jScrollPane3.setViewportView(logList1);

        javax.swing.GroupLayout logPanelLayout = new javax.swing.GroupLayout(logPanel);
        logPanel.setLayout(logPanelLayout);
        logPanelLayout.setHorizontalGroup(
            logPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 753, Short.MAX_VALUE)
                .addContainerGap())
        );
        logPanelLayout.setVerticalGroup(
            logPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                .addContainerGap())
        );

        servicesTabPane.addTab("Lịch sử đăng nhập", logPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(servicesTabPane)
                    .addComponent(headingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(servicesTabPane, javax.swing.GroupLayout.PREFERRED_SIZE, 385, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnChargeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChargeActionPerformed
        new ChargeGUI();
    }//GEN-LAST:event_btnChargeActionPerformed

    private void btnOrdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdActionPerformed
        if (customList1.getSelectedIndex() != -1) {
            Product o = customList1.getSelectedValue();
            OrderGUI x = new OrderGUI(o,this);
            x.setVisible(true);
            //
            //THIẾT LẬP GIÁ TRỊ BAN ĐẦU CHO GIAO DIỆN
            //
            x.lblPdName.setText(o.getProduct_name());
            long total = Long.parseLong(o.getProduct_cost()) * ((Number) x.spinAmount.getValue()).longValue();
            x.lblTotal.setText(String.valueOf(total));
        }
    }//GEN-LAST:event_btnOrdActionPerformed
    //
    //NÚT ĐĂNG XUẤT
    //
    private void btnSignOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignOutActionPerformed
        UserSession.timerEnd();
        UserSession session = new UserSession(UserSession.getSession().getUser(), UserSession.getSessionTimerStart(), UserSession.getSessionTimerEnd(), UserSession.sessionTime()); //user,start,end,time
        UserSession.saveSession(session);
        count.interrupt();
        UserSession.getSession().clearSession();
        dispose();
        new LoginGUI().setVisible(true);
    }//GEN-LAST:event_btnSignOutActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new SettingFrm();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new ReportGUI();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnRankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRankActionPerformed
        User u = new UserDAO().getUserById1(UserSession.getSession().getUser().getUserId());
        if (u.getRank().equals("Elite")) {
            JOptionPane.showMessageDialog(null, "Bạn đã ở rank cao nhất!!!");
            return;
        }
        new RankGUI().setVisible(true);
    }//GEN-LAST:event_btnRankActionPerformed
    //
    //VẼ LẠI DANH SÁCH ĐƠN
    //
    public void fillOrderList () {
        orderModel.clear();
        for (Object o : OrderDAO.getOrders(UserSession.getSession().getUser())) {
            orderModel.addElement(o);
            System.out.println("hi");
        }
    }
    //
    //
    // TRUYỀN DỮ LIỆU LỊCH SỬ ĐĂNG NHẬP VÀO GIAO DIỆN
  
    public void fillLogList () {
        logModel.clear();
        //DUYỆT DANH SÁCH KẾT QUẢ VÀ TRUYỀN VÀO MODEL
        for (Object o : UserSession.getSessionByUserId(UserSession.getSession().getUser().getUserId())) {
            logModel.addElement(o);
            
            System.out.println("bye");
        }
    }
    //
    // LỚP LUỒNG : 1. CHẠY BỐ ĐẾM TIỀN; 2. HIỂN THỊ THỜI GIAN; 3. ĐĂNG XUẤT KHI HẾT TIỀN;
    //
    class CountThread extends Thread {
        @Override
        public void run() {
            try {
                long timeLeft;
                UserDAO user = new UserDAO();
                while (user.getUserBalance(titleName)>0) {
                    //chạy theo chu kì 1s
                    Thread.sleep(1000);                                                             //DỪNG THREAD 1 GIÂY
                    user.addUseTime(UserSession.getSession().getUser().getUsername());           //THÊM THỜI GIAN SỬ DỤNG CỦA NGƯỜI DÙNG VÀO DB
                    user.adjustBalance(UserSession.getSession().getUser().getUsername(), -10 );  //TRỪ TIỀN TÀI KHOẢN MỖI GIÂY
                    timeLeft = user.getUserBalance(titleName)/600;                               
                    lblTime.setText(String.valueOf(timeLeft)+" Phút");                              //HIỂN THỊ THÔNG SỐ THỜI GIAN VÀ TIỀN
                    lblMoney.setText(String.valueOf(user.getUserBalance(titleName)));            //
                }
                //
                //KẾT THÚC PHIÊN + TRỞ VỀ MÀN HÌNH ĐĂNG NHẬP
                //
                UserSession.timerEnd();
                UserSession.getSession().clearSession();
                dispose();
                new LoginGUI().setVisible(true);
                JOptionPane.showMessageDialog(null, "Tài khoản đã hết thời gian sử dụng, hãy liên hệ với admin để nạp thêm tiền!");
           } catch (InterruptedException e) {
               System.out.println("Thread bị dừng!");
           }
       }
    }
        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCharge;
    private javax.swing.JButton btnOrd;
    private javax.swing.JButton btnRank;
    private javax.swing.JButton btnSignOut;
    private org.example.gui.usergui.CustomList<String> customList1;
    private javax.swing.JLabel greetingLabel;
    private javax.swing.JPanel headingPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblMoney;
    private javax.swing.JLabel lblTime;
    private org.example.gui.usergui.LogList<String> logList1;
    private javax.swing.JPanel logPanel;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JLabel name;
    private org.example.gui.usergui.OrderList<String> orderList1;
    private javax.swing.JPanel orderPanel;
    private javax.swing.JTabbedPane servicesTabPane;
    // End of variables declaration//GEN-END:variables

}

