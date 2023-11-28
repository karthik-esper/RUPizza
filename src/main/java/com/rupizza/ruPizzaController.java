package com.rupizza;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller class for the main menu.
 * Contains buttons that open scenes run by the other controllers.
 * @author Karthik Gangireddy, Vineal Sunkara
 */
public class ruPizzaController {
    private Store ruPizza = Store.getInstance(); //instance of store

    /**
     * Initializes instances for the singleton.
     */
    public void initialize () {
        Order currentOrder = ruPizza.getCurrentOrder();
        StoreOrders storeOrders = ruPizza.getOrderHistory();
    }

    /**
     * Creates the scene for the controller that creates specialty pizzas.
     */
    @FXML
    protected void createSpecialty () {
        try {
            // Load the FXML file
            FXMLLoader fxmlLoader = new FXMLLoader(ruPizzaMain.class.getResource("Specialty.fxml"));
            Scene specialtyScene = new Scene(fxmlLoader.load(), 400, 400);

            // Create a new stage (window)
            Stage stage = new Stage();
            stage.setTitle("Select Specialty!");
            stage.setScene(specialtyScene);

            // Show the new stage
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates the scene for the controller that creates customizable pizzas.
     */
    @FXML
    protected void createBuildYourOwn() {
        try {
            // Load the FXML file
            FXMLLoader fxmlLoader = new FXMLLoader(ruPizzaMain.class.getResource("BuildYourOwn.fxml"));
            Scene specialtyScene = new Scene(fxmlLoader.load(), 700, 700);

            // Create a new stage (window)
            Stage stage = new Stage();
            stage.setTitle("Build your own PIZZA!");
            stage.setScene(specialtyScene);

            // Show the new stage
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates the scene for the controller that can view and delete items from orders.
     */
    @FXML
    protected void viewCurrentOrder () {
        try {
            // Load the FXML file
            FXMLLoader fxmlLoader = new FXMLLoader(ruPizzaMain.class.getResource("Orders.fxml"));
            Scene orderScene = new Scene(fxmlLoader.load(), 600, 420);

            // Create a new stage (window)
            Stage stage = new Stage();
            stage.setTitle("Current Order");
            stage.setScene(orderScene);

            // Show the new stage
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates the scene for the controller that can view order history and delete orders.
     */
    @FXML
    protected void viewOrderHistory () {
        try {
            // Load the FXML file
            FXMLLoader fxmlLoader = new FXMLLoader(ruPizzaMain.class.getResource("StoreOrders.fxml"));
            Scene orderScene = new Scene(fxmlLoader.load(), 600, 400);

            // Create a new stage (window)
            Stage stage = new Stage();
            stage.setTitle("Store Order History");
            stage.setScene(orderScene);

            // Show the new stage
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}