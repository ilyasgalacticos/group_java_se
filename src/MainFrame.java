import javax.swing.*;
import java.util.ArrayList;

public class MainFrame extends JFrame {

    private MenuPage menuPage;
    private AddItemPage addItemPage;
    private ListItemsPage listItemsPage;
    private EditItemPage editItemPage;

    private DBConnection dbConnection;

    public MainFrame(){

        dbConnection = new DBConnection();
        dbConnection.connect();

        setSize(700,700);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("ITEMS SHOP CLIENT APPLICATION");

        menuPage = new MenuPage(this);
        menuPage.setVisible(true);
        add(menuPage);

        addItemPage = new AddItemPage(this);
        addItemPage.setVisible(false);
        add(addItemPage);

        listItemsPage = new ListItemsPage(this);
        listItemsPage.setVisible(false);
        add(listItemsPage);

        editItemPage = new EditItemPage(this);
        editItemPage.setVisible(false);
        add(editItemPage);

    }
    public void showMainMenuPage(){
        this.menuPage.setVisible(true);
    }
    public void hideMainMenuPage(){
        this.menuPage.setVisible(false);
    }
    public void showAddItemPage(){
        this.addItemPage.setVisible(true);
    }
    public void hideAddItemPage(){
        this.addItemPage.setVisible(false);
    }
    public void showListItemPage(){
        this.listItemsPage.setVisible(true);
    }
    public void hideListItemPage(){
        this.listItemsPage.setVisible(false);
    }
    public void showEditItemPage(){ this.editItemPage.setVisible(true);}
    public void hideEditItemPage(){ this.editItemPage.setVisible(false);}

    public void fillItemsList(ArrayList<Items> items){
        this.listItemsPage.fillTable(items);
    }
    public void prepareEditItemPage(Items item){this.editItemPage.prepareForm(item);}

    public void addItem(Items item){
        this.dbConnection.addItem(item);
    }
    public ArrayList<Items> listItems(){return this.dbConnection.getAllItems(); }
    public Items getItem(Long id){ return this.dbConnection.getItem(id); }
    public void saveItem(Items item){ this.dbConnection.updateItem(item);}
    public void deleteItem(Long id){this.dbConnection.deleteItem(id);}

    public void refresh(){
        setResizable(true);
        setSize((int)getSize().getWidth()+1, (int)getSize().getHeight());
        setSize((int)getSize().getWidth()-1, (int)getSize().getHeight());
        setResizable(false);
    }
}
