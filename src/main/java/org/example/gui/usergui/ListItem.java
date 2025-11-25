
package org.example.gui.usergui;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import org.example.model.Product;


public class ListItem extends javax.swing.JPanel {


    public ListItem() {
        initComponents();
    }
    
    public void setItem(Object obj) {
        if (obj instanceof Product) {
            Product product = (Product) obj;
            ImageIcon icon = new ImageIcon(getClass().getResource(product.getProduct_image()));
            Image image = icon.getImage(); //ĐỔI IMGICON - > IMG

            Image scaled = image.getScaledInstance(182, 144, Image.SCALE_SMOOTH);
            productImg.setIcon(new ImageIcon(scaled));
            name.setText(product.getProduct_name() +": " + product.getProduct_cost());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        name = new javax.swing.JLabel();
        productImg = new javax.swing.JLabel();

        name.setFont(new java.awt.Font("Product Sans Medium", 0, 18)); // NOI18N
        name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name.setText("Product");
        name.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                    .addComponent(productImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(productImg, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel name;
    private javax.swing.JLabel productImg;
    // End of variables declaration//GEN-END:variables
}
