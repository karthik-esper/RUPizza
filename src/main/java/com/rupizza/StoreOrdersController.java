package com.rupizza;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;


import static com.rupizza.PizzaMaker.createPizza;

/**
 * Controller class for the Store order history.
 * Allows you to view any selected order as well as delete orders.
 * Allows you to export store orders.
 * @author Karthik Gangireddy, Vineal Sunkara
 */
public class StoreOrdersController {
    @FXML
    private ListView<String> orderList;
    private ObservableList<String> orderPizzas;
    @FXML
    private TextField orderTotal;
    @FXML
    private ComboBox<Integer> ordersAvailable;

    /**
     * initializes the scene with set options for the comboboxes and listviews.
     */
    @FXML
    public void initialize() {
        StoreOrders currentStore = Store.getInstance().getOrderHistory();
        displayOptions();
        orderList.setItems(FXCollections.observableArrayList());
        pickerFunction();
    }

    /**
     * Sets up the combobox with the possible orders to choose from when viewing orders.
     */
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

    /**
     * Initializes the event listener for the select order combo box.
     * Provides the option to browse placed orders and view each order's items.
     */
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

    /**
     * function for the button to delete orders.
     * Checks to make sure the order is selected before deleting.
     */
    @FXML
    protected void deleteOrder () {
        if (ordersAvailable.getSelectionModel().getSelectedItem() != null) {
            if (ordersAvailable.getValue() != -1) {
                StoreOrders currentStore = Store.getInstance().getOrderHistory();
                int index = ordersAvailable.getValue();
                currentStore.getOrder(index - 1).clearOrder();
                orderTotal.setText("");
                orderList.setItems(FXCollections.observableArrayList());
                ordersAvailable.setItems(FXCollections.observableArrayList());
                ordersAvailable.getSelectionModel().clearSelection();
                displayOptions();
            } else {
                showAlert("No Selection");
            }
        }
        else {
            showAlert("No Item");
        }
    }

    /**
     * Shows alerts based on errors.
     * @param type type of the error in String form.
     */
    protected void showAlert(String type) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Warning!");
        if (type.equalsIgnoreCase("No Selection")){
            alert.setContentText("You have not selected an order to remove.");
        }
        if (type.equalsIgnoreCase("No Item")){
            alert.setContentText("You have not selected an order to remove.");
        }

        alert.showAndWait();
    }

    /**
     * Saves the arraylist for the order history as a text file.
     * Uses the store orders export() method.
     */
    @FXML
    protected void saveAsFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select file to save to");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));

        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("All Files", "*.")
        );

        File file = fileChooser.showSaveDialog(null);

        if (file != null) {
            try (FileWriter fileWriter = new FileWriter(file)) {
                Store.getInstance().getOrderHistory().export(fileWriter, file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    }

