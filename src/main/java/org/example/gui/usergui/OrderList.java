package org.example.gui.usergui;

import java.awt.Color;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import org.example.model.Order;
import org.example.model.Product;

/**
 *
 * @author khoa
 */

public class OrderList<E extends Object> extends JList<Object> {

    @Override
    public ListCellRenderer getCellRenderer (){
        return new DefaultListCellRenderer () {
            @Override
            public Component getListCellRendererComponent (JList <?> jlist, Object o, int index, boolean selected, boolean focus){
                OrderItem item = new OrderItem(o);

                if (selected) {
                    item.setBackground(new Color(200, 220, 255));
                } else {
                    item.setBackground(Color.WHITE);

                }
//                System.out.println("goi");
                return item; 
            }
        };
    }

        

}
