package com.rupizza;

import javafx.collections.ObservableList;
import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.collections.FXCollections;

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
//        specialtyToppings.setItems(FXCollections.observableArrayList(
//                "")
//        );
    }
}
