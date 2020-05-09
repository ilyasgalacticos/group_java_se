import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPage extends Container {

    private MainFrame parent;
    private ApplicationButton addItemButton, listItemsButton;

    public MenuPage(MainFrame parent){

        this.parent = parent;
        setSize(700,700);
        setLocation(0,0);
        setLayout(null);

        addItemButton = new ApplicationButton("ADD ITEM");
        addItemButton.setLocation(250, 50);
        add(addItemButton);
        addItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.hideMainMenuPage();
                parent.showAddItemPage();
            }
        });

        listItemsButton = new ApplicationButton("LIST ITEMS");
        listItemsButton.setLocation(250, 150);
        add(listItemsButton);
        listItemsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.fillTable(parent.listItems());
                parent.hideMainMenuPage();
                parent.showListItemPage();
            }
        });

    }

}
