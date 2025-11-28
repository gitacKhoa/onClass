package org.example.gui.usergui;

import org.example.gui.usergui.LogItem;
import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author khoa
 */
public class LogList < E extends Object > extends JList <Object> {

    @Override
    public ListCellRenderer getCellRenderer (){
        return new DefaultListCellRenderer () {
            @Override
            public Component getListCellRendererComponent (JList <?> jlist, Object o, int index, boolean selected, boolean focus){
                LogItem item = new LogItem(o);
                
                if (selected) {
                    item.setBackground(new Color(200, 220, 255));
                } else {
                    item.setBackground(Color.WHITE);
                }
                return item; 
            }
        };
    }

}
