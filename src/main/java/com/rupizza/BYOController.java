package com.rupizza;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;
import javafx.scene.control.*;

import java.util.ArrayList;

import static com.rupizza.PizzaMaker.createPizza;

/**
 * Controller class for Build Your Own Pizza
 * @author Karthik Gangireddy, Vineal Sunkara
 */
public class BYOController {
    //BYOB vars
    private int toppingCounter;
    private Sauce sauce;
    private Size size = Size.S;
    private boolean extraCheese;
    private boolean extraSauce;
    private final int MAX_TOPPING_SIZE = 7;
    private final int MIN_TOPPING_SIZE = 3;
    private final double SMALL_PRICE = 8.99;
    private final double MED_PRICE = 10.99;
    private final double LG_PRICE = 12.99;
    private final double ADD_TOP_PRICE = 1.49;
    private final double EXTRAS_PRICE = 1.00;
    private double currentPrice = SMALL_PRICE;
    //FXML elements\
    @FXML
    private ListView<Topping> toppingsListView;
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
    private RadioButton tomato;
    @FXML
    private RadioButton alfredo;
    @FXML
    private RadioButton small;
    @FXML
    private RadioButton medium;
    @FXML
    private RadioButton large;
    @FXML
    private RadioButton exSauce;
    @FXML
    private RadioButton exCheese;
    @FXML
    private Label price;
    @FXML
    private Button add;
    @FXML
    private Button remove;
    @FXML
    private ListView<Topping> selectedToppings;

    /**
     * Initializes the controller with ListViews.
     */
    @FXML
    public void initialize() {
        toppingsListView.setItems(FXCollections.observableArrayList(
                Topping.SAU, Topping.PE, Topping.BE, Topping.HA, Topping.SH, Topping.SQ, Topping.CM,
                Topping.GP, Topping.ON, Topping.MU, Topping.BO, Topping.PI, Topping.JA
        ));
    }

    /**
     * Adds toppings to the pizza based on whatever toppings are selected.
     */
    @FXML
    protected void toppingAdd() {
        Topping selected = toppingsListView.getSelectionModel().getSelectedItem();
        if (toppingCounter < MAX_TOPPING_SIZE) {
            if(selected != null) {
                toppingsListView.getItems().remove(selected);
                selectedToppings.getItems().add(selected);
                toppingCounter++;
            }
            else {
                showAlert("Please select a topping to add/remove.");
            }
        } else {
            showAlert("Too many toppings! The maximum number of selectable toppings is 7.");
        }
        pricePrint();
    }

    /**
     * Removes toppings from the pizza based on the selected toppings from ListView.
     */
    @FXML
    protected void toppingRemove() {
        Topping selected = selectedToppings.getSelectionModel().getSelectedItem();
        if(selected != null) {
            selectedToppings.getItems().remove(selected);
            toppingsListView.getItems().add(selected);
            toppingCounter--;
        }
        else {
            showAlert("Please select a topping to add/remove.");
        }
        pricePrint();
    }

    /**
     * Shows alerts based on errors.
     * @param type type of the error in String form.
     */
    protected void showAlert(String type) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Warning!");
        alert.setContentText(type);
        alert.showAndWait();
    }

    /**
     * Updates the pizza based on the sauce selected.
     */
    @FXML
    protected void sauceSelect() {
        if (tomato.isSelected() == true) {
            sauce = Sauce.TO;
        }
        if (alfredo.isSelected() == true) {
            sauce = Sauce.AL;
        }
    }

    /**
     * Updates pizza based on the size selected.
     */
    @FXML
    protected void sizeSelect() {
        if (small.isSelected() == true) {
            size = Size.S;
        }
        if (medium.isSelected() == true) {
            size = Size.M;
        }
        if (large.isSelected() == true) {
            size = Size.L;
        }
        pricePrint();
    }

    /**
     * Print the price of the pizza factoring in the amount of toppings and other factors.
     * Allows the price to update as items are selected.
     */
    protected void pricePrint() {
        switch (size) {
            case S:
                currentPrice = SMALL_PRICE;
                break;
            case M:
                currentPrice = MED_PRICE;
                break;
            case L:
                currentPrice = LG_PRICE;
                break;
        }

        if (selectedToppings.getItems().size() > MIN_TOPPING_SIZE) {
            currentPrice += ADD_TOP_PRICE * (selectedToppings.getItems().size() - MIN_TOPPING_SIZE);
        }

        if (exCheese.isSelected()) {
            currentPrice += EXTRAS_PRICE;
        }

        if (exSauce.isSelected()) {
            currentPrice += EXTRAS_PRICE;
        }

        price.setText("" + currentPrice);
    }

    /**
     * Creates the actual pizza based on the selected parameters.
     * Checks to make sure there are no problems with number of toppings or size/sauce.
     */
    @FXML
    protected void pizzaButton() {
        if ((selectedToppings.getItems().size() < 3) || sauce == null) {
            showAlert("Please select at least three toppings and a sauce.");
            return;
        }
        Pizza toMake = createPizza("byop");
        toMake.toppings = new ArrayList<Topping>(selectedToppings.getItems());
        toMake.sauce = sauce;
        toMake.size = size;
        if (exCheese.isSelected() == true) {toMake.setExtraCheese(true);}
        if (exSauce.isSelected() == true) {toMake.setExtraSauce(true);}
        Alert success = new Alert(Alert.AlertType.CONFIRMATION);
        success.setTitle("Pizza creation complete. It's Pizza Time!");
        success.setContentText(toMake.toString());
        Order currentOrder = Store.getInstance().getCurrentOrder();
        currentOrder.addToOrder(toMake);
        success.showAndWait();
    }
}