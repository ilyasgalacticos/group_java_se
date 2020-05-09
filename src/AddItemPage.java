import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddItemPage extends Container {

    private MainFrame parent;
    private ApplicatonLabel nameLabel, priceLabel, amountLabel;
    private ApplicationField nameField, priceField, amountField;
    private ApplicationButton addButton, backButton;

    public AddItemPage(MainFrame parent){
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

        addButton = new ApplicationButton("ADD ITEM");
        addButton.setLocation(250, 480);
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

                parent.addItem(new Items(null, name, price, amount));

            }
        });

        backButton = new ApplicationButton("BACK");
        backButton.setLocation(250, 550);
        add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.hideAddItemPage();
                parent.showMainMenuPage();
            }
        });

    }

}
