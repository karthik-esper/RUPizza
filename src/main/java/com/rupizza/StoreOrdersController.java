package com.rupizza;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
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
        ArrayList<Integer> orders = new ArrayList<>();
        for (int i = 0; i < currentStore.getNumOrders(); i++) {
            orders.add(i,i+1);
        }
        ordersAvailable.setItems(FXCollections.observableArrayList(orders));
        orderList.setItems(FXCollections.observableArrayList());
        pickerFunction();
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
}
