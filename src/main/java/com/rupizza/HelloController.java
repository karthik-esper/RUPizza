package com.rupizza;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;


    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void createSpecialty () {
        System.out.println("Button got clicked");
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