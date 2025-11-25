
package org.example.gui.usergui;

import java.awt.Color;
import java.awt.Component;
import javax.swing.*;
import org.example.model.Product;

/**
 *
 * @author khoa
 */
public class CustomList<E extends Object> extends JList<Product> {
    private DefaultListModel<Product> model;
    public CustomList () {
        model = new DefaultListModel();
        setLayoutOrientation(JList.HORIZONTAL_WRAP);
        setVisibleRowCount(-1);
    }
    
    @Override
    public ListCellRenderer getCellRenderer (){
        return new DefaultListCellRenderer () {
            @Override
            public Component getListCellRendererComponent (JList <?> jlist, Object o, int index, boolean selected, boolean focus){
                ListItem item = new ListItem();
                item.setItem(o);
                if (selected) {
                    item.setBackground(new Color(200, 220, 255));
                    item.setBorder(BorderFactory.createLineBorder(new Color(30, 136, 229), 2));
                } else {
                    item.setBackground(Color.WHITE);
                    item.setBorder(null);
                }
//                System.out.println("goi");
                return item; 
            }
        };
    }

}
