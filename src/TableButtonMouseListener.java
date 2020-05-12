import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TableButtonMouseListener extends MouseAdapter {

    private final JTable table;
    private MainFrame parent;
    private Container container;

    public TableButtonMouseListener(JTable table, MainFrame parent, Container container) {
        this.table = table;
        this.parent = parent;
        this.container = container;
    }

    public void mouseClicked(MouseEvent e){
        int col = table.getColumnModel().getColumnIndexAtX(e.getX());
        int row = e.getY()/table.getRowHeight();
        if(row<table.getRowCount() && row>=0 && col<table.getColumnCount() && col>=0){
            if(container instanceof ListItemsPage){
                Long id = (Long) table.getValueAt(row, 0);
                Items item = parent.getItem(id);
                if(item!=null) {
                    parent.prepareEditItemPage(item);
                    parent.hideListItemPage();
                    parent.showEditItemPage();
                }
            }
        }
    }
}
