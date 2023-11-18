package com.rupizza;

import javafx.collections.ObservableList;
import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class SpecialtyController {
    @FXML
    private ListView<Topping> specialtyToppings;
    private ObservableList<Topping> specialtyItems;
}
