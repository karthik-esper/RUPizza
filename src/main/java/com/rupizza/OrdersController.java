package com.rupizza;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;

import java.util.ArrayList;

public class OrdersController {
    @FXML
    private ListView<String> orderView;
    private ObservableList<String> orderPizzas;
    @FXML
    private TextField orderID;
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
        orderID.setText(String.valueOf(currentOrder.getOrderNumber()));
    }

    protected void calculatePrice() {
        Order currentOrder = Store.getInstance().getCurrentOrder();
        double price = 0;
        for (int i = 0; i < currentOrder.getSize(); i++) {
            price += currentOrder.getPrice(i);
        }
        subtotalBox.setText(String.format("%.2f",price));
        salesTax.setText(String.format("%.2f",price * .0625));
        orderTotal.setText(String.format("%.2f",price * 1.0625));
    }
    @FXML
    protected void deletePizza () {
        if (orderView.getSelectionModel().getSelectedIndex() != -1) {
            Order currentOrder = Store.getInstance().getCurrentOrder();
            int index = orderView.getSelectionModel().getSelectedIndex();
            currentOrder.removeItem(index);
            orderView.getItems().remove(index);
        }
        else {
            showAlert("No Selection");
        }
        calculatePrice();
    }

    protected void showAlert(String type) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Warning!");
        if (type.equalsIgnoreCase("No Selection")){
            alert.setContentText("You have not selected a pizza to remove.");
        }

        alert.showAndWait();
    }

    @FXML
    protected void placeOrder () {
        StoreOrders currentStore = Store.getInstance().getOrderHistory();
        Order currentOrder = Store.getInstance().getCurrentOrder();
        currentStore.addOrder(currentOrder);
        clearAll();
        currentOrder.incrementOrder();
        orderID.setText(String.valueOf(currentOrder.getOrderNumber()));

    }

    @FXML
    protected void clearAll() {
        orderID.setText("");
        orderView.setItems(FXCollections.observableArrayList());
        subtotalBox.setText("");
        salesTax.setText("");
        orderTotal.setText("");
    }
}
