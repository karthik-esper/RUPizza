package com.rupizza;

import javafx.collections.ObservableList;
import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.ArrayList;

import static com.rupizza.PizzaMaker.createPizza;

/**
 * Controller class adding specialty pizzas and seeing their price.
 * Allows you to choose pizza size, type, and extras,
 * @author Karthik Gangireddy, Vineal Sunkara
 */
public class SpecialtyController {
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

    /**
     * initializes the scene with set options for the comboboxes and listviews.
     */
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

    /**
     * Initializes the event listener for the select pizza type combo box.
     * Adjusts the listview of toppings based on selected pizza type.
     */
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
                sauceSetter.setSelected(false);
                cheeseSetter.setSelected(false);
                priceBox.setText("Price: " + String.valueOf(temp.price()));
            }
        });
    }

    /**
     * Initializes the event listener for the select pizza size button.
     * Adjusts the price based on selected size.
     */
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

    /**
     * Updates price of main pizza based on selected items.
     * @param pizza pizza to update sauce or cheese for.
     * @return pizza with updated properties.
     */
    @FXML
    protected Pizza updatePrice(Pizza pizza){
        Pizza temp = createPizza(specialtyChoices.getValue());
        if (temp != null && specialtyChoices.getValue() != null) {
            temp.setSize(Size.valueOf(sizeChoices.getValue().substring(0,1).toUpperCase()));
            {
                if (sauceSetter.isSelected()) {
                    temp.setExtraSauce(true);
                    Double price = temp.price();
                    priceBox.setText("Price: " + String.format("%.2f", price));
                }
                if (!sauceSetter.isSelected()) {
                    temp.setExtraSauce(false);
                    Double price = temp.price();
                    priceBox.setText("Price: " + String.format("%.2f", price));
                }
                if (cheeseSetter.isSelected()) {
                    temp.setExtraCheese(true);
                    Double price = temp.price();
                    priceBox.setText("Price: " + String.format("%.2f", price));
                } else {
                temp.setExtraCheese(false);
                Double price = temp.price();
                priceBox.setText("Price: " + String.format("%.2f", price));
            }
                return temp;
            }
        }
        else {showAlert("Insufficient");
            sauceSetter.setSelected(false);
            cheeseSetter.setSelected(false);
        return null;}
    }

    /**
     * Updates price based on selected radioButtons for sauce and cheese.
     */
    @FXML
    protected void updatePrice() {
        if (sizeChoices.getValue() != null && specialtyChoices.getValue() != null) {
            Pizza temp = createPizza(specialtyChoices.getValue());
            temp.setSize(Size.valueOf(sizeChoices.getValue().substring(0,1).toUpperCase()));
            {
                if (sauceSetter.isSelected()) {
                    temp.setExtraSauce(true);
                    Double price = temp.price();
                    priceBox.setText("Price: " + String.format("%.2f", price));
                }
                if (!sauceSetter.isSelected()) {
                    temp.setExtraSauce(false);
                    Double price = temp.price();
                    priceBox.setText("Price: " + String.format("%.2f", price));
                }
                if (cheeseSetter.isSelected()) {
                    temp.setExtraCheese(true);
                    Double price = temp.price();
                    priceBox.setText("Price: " + String.format("%.2f", price));
                } else {
                    temp.setExtraCheese(false);
                    Double price = temp.price();
                    priceBox.setText("Price: " + String.format("%.2f", price));
                }
            }
        }
        else {showAlert("Insufficient");
            sauceSetter.setSelected(false);
            cheeseSetter.setSelected(false);
        }
    }

    /**
     * Creates the pizza after checking multiple parameters.
     * Makes sure necessary fields are entered.
     */
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
                Order currentOrder = Store.getInstance().getCurrentOrder();
                toMake = updatePrice(toMake);
                currentOrder.addToOrder(toMake);
                clearAll();
            }
            else {
                showAlert("No Size");
            }
        }
        else {showAlert("No Type");}
    }

    /**
     * Shows alerts based on errors.
     * @param type type of the error in String form.
     */
    protected void showAlert(String type) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Warning!");
        if (type.equalsIgnoreCase("No Size")){
            alert.setContentText("You have not selected a pizza size!");
        }
        if (type.equalsIgnoreCase("Insufficient")) {
            alert.setContentText("Size/Type is null");
        }
        else {
            alert.setContentText("You have not selected a pizza type!");
        }
        alert.showAndWait();
    }

    /**
     * Clears the boxes.
     */
    @FXML
    protected void clearAll () {
        specialtyToppings.setItems(FXCollections.observableArrayList());
        specialtyChoices.getSelectionModel().clearSelection();
        sizeChoices.getSelectionModel().clearSelection();
        cheeseSetter.setSelected(false);
        sauceSetter.setSelected(false);
        priceBox.setText("Price:");
    }

    /**
     * Creates a topping list based on the pizza type given.
     * @param type pizza type in string form.
     * @return toppings list.
     */
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

    /**
     * Changes picture based on the selected pizza type.
     * @param type pizza type.
     */
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
