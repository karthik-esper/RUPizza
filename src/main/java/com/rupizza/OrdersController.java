package com.rupizza;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;

import java.util.ArrayList;

/**
 * Controller class for the current Order.
 * Allows you to view all pizzas in the order, delete pizzas, and place the order,
 * @author Karthik Gangireddy, Vineal Sunkara
 */
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

    /**
     * initalizes the list views and combo boxes for the order.
     * Sets the order number based on the available numbers.
     */
    @FXML
    public void initialize() {
        Order currentOrder = Store.getInstance().getCurrentOrder();
        orderView.setItems(FXCollections.observableArrayList(currentOrder.printList()));
        calculatePrice();
        if (Store.getInstance().getOrderHistory().getNextOrder() != 0) {
            orderID.setText(String.valueOf(Store.getInstance().getOrderHistory().getNextOrder()));
        }
        else {orderID.setText("1");}
    }

    /**
     * Calculates the number to put in the price box based on all the pizzas.
     * Applies sales tax to get the total order.
     */
    protected void calculatePrice() {
        Order currentOrder = Store.getInstance().getCurrentOrder();
        double price = currentOrder.orderPrice();
        subtotalBox.setText(String.format("%.2f",price));
        salesTax.setText(String.format("%.2f",price * .0625));
        orderTotal.setText(String.format("%.2f",price * 1.0625));
    }

    /**
     * Deletes a pizza from the order based on the one selected from the listview.
     */
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

    /**
     * Shows an alert based on the error provided,
     * @param type string representation of the error causing the alert.
     */
    protected void showAlert(String type) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        if (type.equalsIgnoreCase("No Selection")){
            alert.setTitle("Warning!");
            alert.setContentText("You have not selected a pizza to remove.");
            alert.showAndWait();
        }
        if (type.equalsIgnoreCase("Empty Order")) {
            alert.setTitle("Warning!");
            alert.setContentText("There are no pizzas in this order. Add something.");
            alert.showAndWait();
        }
        if (type.equalsIgnoreCase("Order Placed")) {
            Alert success = new Alert(Alert.AlertType.CONFIRMATION);
            success.setContentText("Order Placed successfully!");
            success.showAndWait();
        }
    }

    /**
     * Places the order with the given total and pizzas.
     */
    @FXML
    protected void placeOrder () {
        Store store = Store.getInstance();
        StoreOrders currentStore = Store.getInstance().getOrderHistory();
        Order currentOrder = Store.getInstance().getCurrentOrder();
        if (currentOrder.getOrderItems().isEmpty()) {
            showAlert("Empty Order");
            return;
        }
        if (currentStore.getNumOrders() == 0) {
            currentStore.addOrder(currentOrder);
        }
        clearAll();
        Store.getInstance().setNextOrder();
        orderID.setText(String.valueOf(Store.getInstance().getOrderHistory().getNextOrder()));
        showAlert("Order Placed");
    }

    /**
     * Clears the boxes.
     */
    @FXML
    protected void clearAll() {
        orderID.setText("");
        orderView.setItems(FXCollections.observableArrayList());
        subtotalBox.setText("");
        salesTax.setText("");
        orderTotal.setText("");
    }
}
