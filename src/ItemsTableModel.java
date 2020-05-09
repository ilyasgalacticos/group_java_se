import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ItemsTableModel extends AbstractTableModel {

    private ArrayList<Items> items;

    public ItemsTableModel(ArrayList<Items> items){
        super();
        this.items = items;
    }

    @Override
    public int getRowCount() {
        return items.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int row, int col) {
        switch (col){
            case 0 :
                return items.get(row).getId();
            case 1:
                return items.get(row).getName();
            case 2:
                return items.get(row).getPrice();
            case 3:
                return items.get(row).getAmount();
            default: return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        String result = "";
        switch (column) {
            case 0:
                result = "ID";
                break;
            case 1:
                result = "NAME";
                break;
            case 2:
                result = "PRICE";
                break;
            case 3:
                result = "AMOUNT";
                break;
        }
        return result;
    }
}
