package com.rupizza;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ruPizzaController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

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
    @FXML
    protected void createCustom () {
        System.out.println("Button got clicked");
    }

    @FXML
    protected void viewCurrentOrder () {
        System.out.println("Button got clicked");
    }

    @FXML
    protected void viewOrderHistory () {
        System.out.println("Button got clicked");
    }
}