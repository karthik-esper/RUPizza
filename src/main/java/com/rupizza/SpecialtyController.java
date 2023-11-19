package com.rupizza;

import javafx.collections.ObservableList;
import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.collections.FXCollections;

import java.util.ArrayList;

public class SpecialtyController {
    @FXML
    private ListView<Topping> specialtyToppings;
    private ObservableList<Topping> specialtyItems;
    @FXML
    private ComboBox<String> specialtyChoices;

    @FXML
    public void initialize() {
        specialtyChoices.setItems(FXCollections.observableArrayList(
                "Deluxe", "Supreme", "Meatzza", "Pepperoni", "Seafood")
        );
        specialtyToppings.setItems(FXCollections.observableArrayList());
        specialtyChoices.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                ObservableList<Topping> toppingList = FXCollections.observableArrayList();
                if (newValue.equals("Deluxe")) {
                    toppingList = createToppingList("Deluxe");
                }
                else if (newValue.equals("Supreme")) {
                    toppingList = createToppingList("Supreme");
                }
                else if (newValue.equals("Meatzza")) {
                    toppingList = createToppingList("Meatzza");
                }
                else if (newValue.equals("Pepperoni")) {
                    toppingList = createToppingList("Pepperoni");
                }
                else {toppingList = createToppingList("Seafood");}
                specialtyToppings.setItems(toppingList);
            }
        });
    }

    protected ObservableList<Topping> createToppingList(String type) {
        if (type.equals("Supreme")) {
            return FXCollections.observableArrayList(
                  Topping.SAU, Topping.PE, Topping.GP, Topping.ON, Topping.MU);
        }
        if (type.equals("Deluxe")) {
            return FXCollections.observableArrayList(
                    Topping.SAU, Topping.PE, Topping.HA,
                    Topping.GP, Topping.ON, Topping.BO , Topping.MU);
        }
        if (type.equals("Meatzza")) {
            return FXCollections.observableArrayList(
                    Topping.SAU, Topping.PE, Topping.BE, Topping.HA);
        }
        if (type.equals("Pepperoni")) {
            return FXCollections.observableArrayList(Topping.PE);
        }
        else {
            return FXCollections.observableArrayList(
                    Topping.SH, Topping.SQ, Topping.CM);
        }
    }
}
