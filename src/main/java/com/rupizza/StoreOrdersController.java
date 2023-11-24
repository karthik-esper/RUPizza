package com.rupizza;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;

import static com.rupizza.PizzaMaker.createPizza;

public class StoreOrdersController {
    @FXML
    private ListView<String> orderList;
    private ObservableList<String> orderPizzas;
    @FXML
    private TextField orderTotal;
    @FXML
    private ComboBox<Integer> ordersAvailable;
    @FXML
    public void initialize() {
        StoreOrders currentStore = Store.getInstance().getOrderHistory();
        displayOptions();
        orderList.setItems(FXCollections.observableArrayList());
        pickerFunction();
    }

    @FXML
    protected void displayOptions () {
        StoreOrders currentStore = Store.getInstance().getOrderHistory();
        ArrayList<Integer> orders = new ArrayList<>();
        for (int i = 0; i < currentStore.getNumOrders(); i++) {
            if (currentStore.getOrder(i).getSize() != 0) {
                orders.add(i + 1);
            }
        }
        ordersAvailable.setItems(FXCollections.observableArrayList(orders));
    }

    @FXML
    protected void pickerFunction () {
        ordersAvailable.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                Order orderToDisplay = Store.getInstance().getOrderHistory().getOrder(newValue-1);
                orderList.setItems(FXCollections.observableArrayList(orderToDisplay.printList()));
                orderTotal.setText(String.format("%.2f",orderToDisplay.orderPrice()));
            }
        });
    }

    @FXML
    protected void deleteOrder () {
        if (ordersAvailable.getValue() != -1) {
            StoreOrders currentStore = Store.getInstance().getOrderHistory();
            int index = ordersAvailable.getValue();
            currentStore.getOrder(index-1).clearOrder();
            orderTotal.setText("");
            orderList.setItems(FXCollections.observableArrayList());
            ordersAvailable.setItems(FXCollections.observableArrayList());
            ordersAvailable.getSelectionModel().clearSelection();
            displayOptions();
        }
        else {
            showAlert("No Selection");
        }
    }

    protected void showAlert(String type) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Warning!");
        if (type.equalsIgnoreCase("No Selection")){
            alert.setContentText("You have not selected an order to remove.");
        }

        alert.showAndWait();
    }
}
