package com.rupizza;

import javafx.collections.ObservableList;
import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.collections.FXCollections;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.ArrayList;

import static com.rupizza.PizzaMaker.createPizza;

public class SpecialtyController {
    protected StoreOrders storeOrder = new StoreOrders();
    @FXML
    private ListView<Topping> specialtyToppings;
    private ObservableList<Topping> specialtyItems;
    @FXML
    private ComboBox<String> specialtyChoices;
    @FXML
    private ComboBox<String> sizeChoices;
    @FXML
    private Label priceBox;
    @FXML
    private Label errorMessage;
    @FXML
    private Label buttonError;
    @FXML
    private RadioButton sauceSetter;
    @FXML
    private RadioButton cheeseSetter;
    @FXML
    private ImageView pizzaPic;


    @FXML
    public void initialize() {
        specialtyChoices.setItems(FXCollections.observableArrayList(
                "Deluxe", "Supreme", "Meatzza", "Pepperoni", "Seafood"
        ));
        sizeChoices.setItems(FXCollections.observableArrayList(
                "Small", "Medium", "Large"
        ));
        specialtyToppings.setItems(FXCollections.observableArrayList());
        pickerFunction();
        sizeFunction();

    }
    @FXML
    protected void pickerFunction () {
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
                changeImage(newValue);
                specialtyToppings.setItems(toppingList);
                Pizza temp = createPizza(newValue);
                sizeChoices.getSelectionModel().clearSelection();
                priceBox.setText("Price: " + String.valueOf(temp.price()));

            }
        });
    }
    @FXML
    protected void sizeFunction () {
        sizeChoices.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                String pizzaType = specialtyChoices.getSelectionModel().getSelectedItem();
                if (pizzaType != null) {
                    Pizza temp = createPizza(pizzaType);
                    temp.setSize(Size.valueOf(newValue.substring(0,1).toUpperCase()));
                    Double price = temp.price();
                    priceBox.setText("Price: " + String.format("%.2f",price));
                }
                else {errorMessage.setText("Select type first.");}
            }
        });
    }
    @FXML
    protected void pizzaButton() {
        if (specialtyChoices.getSelectionModel().getSelectedItem() != null) {
            Pizza toMake = createPizza(specialtyChoices.getSelectionModel().getSelectedItem());
            if (sizeChoices.getSelectionModel().getSelectedItem() != null) {
                String size = sizeChoices.getSelectionModel().getSelectedItem();
                toMake.setSize(Size.valueOf(size.substring(0,1).toUpperCase()));
                if (sauceSetter.isSelected()) {toMake.setExtraSauce(true);}
                if (cheeseSetter.isSelected()) {toMake.setExtraCheese(true);}
                buttonError.setText("Pizza was created!");
                System.out.println(toMake.toString());
                clearAll();
                Order currentOrder = Store.getInstance().getCurrentOrder();
                currentOrder.addToOrder(toMake);
            }
            else {
                buttonError.setText("Size not selected!");
            }
        }
        else {buttonError.setText("Please select a pizza type!");}
    }

    @FXML
    protected void clearAll () {
        specialtyToppings.setItems(FXCollections.observableArrayList());
        specialtyChoices.getSelectionModel().clearSelection();
        sizeChoices.getSelectionModel().clearSelection();
        cheeseSetter.setSelected(false);
        sauceSetter.setSelected(false);
        priceBox.setText("Price:");
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

    @FXML
    protected void changeImage(String type) {
        String url = "";
        if (type.equals("Deluxe")) {
            url = "/com/image/DeluxePizza.jpg";
        }
        else if (type.equals("Supreme")) {
            url = "/com/image/SupremePizza.jpg";
        }
        else if (type.equals("Meatzza")) {
            url = "/com/image/MeatzzaPizza.jpg";
        }
        else if (type.equals("Pepperoni")) {
            url = "/com/image/RoniPizza.jpg";
        }
        else {url = "/com/image/OceanZza.jpg";}
        Image newPic = new Image(url);
        pizzaPic.setImage(newPic);
    }
}
