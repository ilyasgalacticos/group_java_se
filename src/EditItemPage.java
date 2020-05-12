import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditItemPage extends Container {

    private MainFrame parent;
    private ApplicatonLabel nameLabel, priceLabel, amountLabel;
    private ApplicationField nameField, priceField, amountField;
    private ApplicationButton addButton, backButton, deleteButton;
    private Long currentItemId;

    public EditItemPage(MainFrame parent){

        this.parent = parent;
        setSize(700,700);
        setLocation(0,0);
        setLayout(null);

        nameLabel = new ApplicatonLabel("ITEM NAME :");
        nameLabel.setLocation(150, 50);
        add(nameLabel);

        nameField = new ApplicationField();
        nameField.setLocation(350,50);
        add(nameField);

        priceLabel = new ApplicatonLabel("ITEM PRICE (KZT) :");
        priceLabel.setLocation(150, 150);
        add(priceLabel);

        priceField = new ApplicationField();
        priceField.setText("0");
        priceField.setLocation(350,150);
        add(priceField);

        amountLabel = new ApplicatonLabel("ITEM AMOUNT :");
        amountLabel.setLocation(150, 250);
        add(amountLabel);

        amountField = new ApplicationField();
        amountField.setLocation(350,250);
        amountField.setText("0");
        add(amountField);

        addButton = new ApplicationButton("SAVE ITEM");
        addButton.setLocation(130, 480);
        add(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String name = nameField.getText();
                String priceText = priceField.getText();
                String amountText = amountField.getText();
                double price = 0;
                try{
                    price = Double.parseDouble(priceText);
                }catch (Exception e){
                }
                int amount = 0;
                try{
                    amount = Integer.parseInt(amountText);
                }catch (Exception e){
                }
                nameField.setText("");
                amountField.setText("0");
                priceField.setText("0");

                parent.saveItem(new Items(currentItemId, name, price, amount));
                parent.fillItemsList(parent.listItems());
                parent.hideEditItemPage();
                parent.showListItemPage();

            }
        });

        deleteButton = new ApplicationButton("DELETE ITEM");
        deleteButton.setLocation(350, 480);
        add(deleteButton);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.deleteItem(currentItemId);
                parent.fillItemsList(parent.listItems());
                parent.hideEditItemPage();
                parent.showListItemPage();
            }
        });

        backButton = new ApplicationButton("BACK");
        backButton.setLocation(250, 550);
        add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.hideEditItemPage();
                parent.showListItemPage();
            }
        });

    }

    public void prepareForm(Items item){

        this.currentItemId = item.getId();
        nameField.setText(item.getName());
        priceField.setText(item.getPrice()+"");
        amountField.setText(item.getAmount()+"");

    }

}
