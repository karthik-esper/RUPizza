package com.rupizza;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.collections.FXCollections;
import javafx.scene.control.RadioButton;

public class OrdersController {
    @FXML
    private ListView<String> orderView;
    private ObservableList<String> orderPizzas;
    @FXML
    public void initialize() {
        Order currentOrder = Store.getInstance().getCurrentOrder();
        orderView.setItems(FXCollections.observableArrayList(currentOrder.printList()));
    }
}
