import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class ApplicationButtonRenderer implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object o, boolean b, boolean b1, int i, int i1) {
        ApplicationButton button = (ApplicationButton) o;
        return button;
    }
}
