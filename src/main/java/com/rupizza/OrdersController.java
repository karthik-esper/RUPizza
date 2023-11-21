package com.rupizza;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;

public class OrdersController {
    @FXML
    private ListView<String> orderView;
    private ObservableList<String> orderPizzas;
    @FXML
    private TextField subtotalBox;
    @FXML
    private TextField salesTax;
    @FXML
    private TextField orderTotal;
    @FXML
    public void initialize() {
        Order currentOrder = Store.getInstance().getCurrentOrder();
        orderView.setItems(FXCollections.observableArrayList(currentOrder.printList()));
        calculatePrice();
    }

    protected void calculatePrice() {
        Order currentOrder = Store.getInstance().getCurrentOrder();
        double price = 0;
        for (int i = 0; i < currentOrder.orderItems.size(); i++) {
            price += currentOrder.orderItems.get(i).price();
        }
        subtotalBox.setText(String.format("%.2f",price));
        salesTax.setText(String.format("%.2f",price * .0625));
        orderTotal.setText(String.format("%.2f",price * 1.0625));

    }
}
