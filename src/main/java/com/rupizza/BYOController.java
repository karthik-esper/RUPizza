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
    private ArrayList<Topping> toppers = new ArrayList<Topping>();
    private int toppingCounter;
    //FXML elements
    @FXML
    private CheckBox sausage = new CheckBox();
    @FXML
    private CheckBox pepperoni = new CheckBox();
    @FXML
    private CheckBox beef = new CheckBox();
    @FXML
    private CheckBox ham = new CheckBox();
    @FXML
    private CheckBox shrimp = new CheckBox();
    @FXML
    private CheckBox squid = new CheckBox();
    @FXML
    private CheckBox crab_meat = new CheckBox();
    @FXML
    private CheckBox green_pepper = new CheckBox();
    @FXML
    private CheckBox onion = new CheckBox();
    @FXML
    private CheckBox mushroom = new CheckBox();
    @FXML
    private CheckBox black_olive = new CheckBox();
    @FXML
    private CheckBox pineapple = new CheckBox();
    @FXML
    private CheckBox jalapeno = new CheckBox();
    @FXML
    private Button toppingSelect;

    @FXML
    protected void createBuildYourOwnPizza() {
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
        sausage.setOnMouseClicked(e -> toppingSelect(Topping.SAU, sausage));
        pepperoni.setOnMouseClicked(e -> toppingSelect(Topping.PE, pepperoni));
        beef.setOnMouseClicked(e -> toppingSelect(Topping.BE, beef));
        ham.setOnMouseClicked(e -> toppingSelect(Topping.HA, ham));
        shrimp.setOnMouseClicked(e -> toppingSelect(Topping.SH, shrimp));
        squid.setOnMouseClicked(e -> toppingSelect(Topping.SQ, squid));
        crab_meat.setOnMouseClicked(e -> toppingSelect(Topping.CM, crab_meat));
        green_pepper.setOnMouseClicked(e -> toppingSelect(Topping.GP, green_pepper));
        onion.setOnMouseClicked(e -> toppingSelect(Topping.ON, onion));
        mushroom.setOnMouseClicked(e -> toppingSelect(Topping.MU, mushroom));
        black_olive.setOnMouseClicked(e -> toppingSelect(Topping.BO, black_olive));
        pineapple.setOnMouseClicked(e -> toppingSelect(Topping.PI, pineapple));
        jalapeno.setOnMouseClicked(e -> toppingSelect(Topping.JA, jalapeno));
    }

    protected void toppingSelect(Topping top, CheckBox cbox) {
        final int MAX_TOPPING_SIZE = 7;
        final int MIN_TOPPING_SIZE = 3;
        if (cbox.isSelected()) {
            if (toppingCounter < MAX_TOPPING_SIZE) {
                toppers.add(top);
                toppingCounter++;
            } else {
                cbox.setSelected(false);
                System.out.println("Too many toppings! A maximum of 7 toppings is allowed.");
            }
        } else {
            toppers.remove(top);
            toppingCounter--;
        }
        System.out.println(toppers);
    }
}