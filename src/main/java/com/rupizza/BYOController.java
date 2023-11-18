package com.rupizza;

import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.util.ArrayList;

public class BYOController {
    private Label welcomeText;
    //BYOB vars
    private Topping top1;
    private Topping top2;
    private Topping top3;
    private Topping top4;
    private Topping top5;
    private Topping top6;
    private Topping top7;
    private int toppingCounter;
    //FXML elements
    private CheckBox sausage;
    private CheckBox pepperoni;
    private CheckBox beef;
    private CheckBox ham;
    private CheckBox shrimp;
    private CheckBox squid;
    private CheckBox crab_meat;
    private CheckBox green_pepper;
    private CheckBox onion;
    private CheckBox mushroom;
    private CheckBox black_olive;
    private CheckBox pineapple;
    private CheckBox jalapeno;
    private Button toppingSelect;

    @FXML
    protected void createSpecialty() {
        try {
            // Load the FXML file
            FXMLLoader fxmlLoader = new FXMLLoader(ruPizzaMain.class.getResource("BuildYourOwn.fxml"));
            Scene specialtyScene = new Scene(fxmlLoader.load(), 400, 400);

            // Create a new stage (window)
            Stage stage = new Stage();
            stage.setTitle("Build your own Pizza!");
            stage.setScene(specialtyScene);

            // Show the new stage
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void topAssign() {
        ArrayList<Topping> toppers= new ArrayList<Topping>();
        if (toppingCounter <= 7) {
            if (sausage.isSelected()) {
                toppers.add(Topping.SAU);
                toppingCounter++;
            }
            if (pepperoni.isSelected()) {
                toppers.add(Topping.PE);
                toppingCounter++;
            }
            if (beef.isSelected()) {
                toppers.add(Topping.BE);
                toppingCounter++;
            }
            if (ham.isSelected()) {
                toppers.add(Topping.BE);
                toppingCounter++;
            }
            if (shrimp.isSelected()) {
                toppers.add(Topping.HA);
                toppingCounter++;
            }
            if (squid.isSelected()) {
                toppers.add(Topping.SQ);
                toppingCounter++;
            }
            if (crab_meat.isSelected()) {
                toppers.add(Topping.CM);
                toppingCounter++;
            }
            if (green_pepper.isSelected()) {
                toppers.add(Topping.GP);
                toppingCounter++;
            }
            if (onion.isSelected()) {
                toppers.add(Topping.ON);
                toppingCounter++;
            }
            if (mushroom.isSelected()) {
                toppers.add(Topping.MU);
                toppingCounter++;
            }
            if (black_olive.isSelected()) {
                toppers.add(Topping.BO);
                toppingCounter++;
            }
            if (pineapple.isSelected()) {
                toppers.add(Topping.PI);
                toppingCounter++;
            }
            if (jalapeno.isSelected()) {
                toppers.add(Topping.JA);
                toppingCounter++;
            }
        }
        System.out.println(toppers.toString());
    }
}
