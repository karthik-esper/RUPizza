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

public class BYOController {
    //BYOB vars
    private ArrayList<Topping> toppers = new ArrayList<Topping>();
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
    private ComboBox sizeDropDown = new ComboBox();
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
        if (cbox.isSelected()) {
            if (toppingCounter < MAX_TOPPING_SIZE) {
                toppers.add(top);
                toppingCounter++;
            } else {
                cbox.setSelected(false);
                showAlert("Too many toppings! The maximum number of selectable toppings is 7.");
            }
        } else {
            toppers.remove(top);
            toppingCounter--;
        }
        System.out.println(toppers);
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
    @FXML
    protected void sauceSelect() {
        if (tomato.isSelected() == true) {
            sauce = Sauce.TO;
        }
        if (alfredo.isSelected() == true) {
            sauce = Sauce.AL;
        }

        System.out.println(sauce.toString());
    }

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
        System.out.println(size);
    }

    @FXML
    protected void extraSelect() {
        if (exCheese.isSelected()) {
            extraCheese = true;
        }
        else if (exSauce.isSelected()) {
            extraSauce = true;
        }
        pricePrint();
    }

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

        if (toppers.size() > MIN_TOPPING_SIZE) {
            currentPrice += ADD_TOP_PRICE * (toppers.size() - MIN_TOPPING_SIZE);
        }

        if (exCheese.isSelected()) {
            currentPrice += EXTRAS_PRICE;
        }

        if (exSauce.isSelected()) {
            currentPrice += EXTRAS_PRICE;
        }

        price.setText("Price: " + currentPrice);
    }

    @FXML
    protected void pizzaButton() {
        if ((toppers.size() < 3) || sauce == null) {
            showAlert("Please select at least three toppings and a sauce.");
            return;
        }
        Pizza toMake = createPizza("byop");
        toMake.toppings = toppers;
        toMake.sauce = sauce;
        toMake.size = size;
        if (exCheese.isSelected() == true) {toMake.setExtraCheese(true);}
        if (exSauce.isSelected() == true) {toMake.setExtraSauce(true);}
        System.out.println(toMake.toString());
        Order currentOrder = Store.getInstance().getCurrentOrder();
        currentOrder.addToOrder(toMake);
    }

}