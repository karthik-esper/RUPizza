package com.rupizza;

public class PizzaMaker {
    public static Pizza createPizza(String pizzaType) {
        switch (pizzaType.toLowerCase()) {
            case "deluxe":
                return new Deluxe();
            case "supreme":
                return new Supreme();
            case "meatzza":
                return new Meatzza();
            case "seafood":
                return new Seafood();
            case "pepperoni":
                return new Pepperoni();
            case "byop":
                return new BuildYourOwnPizza();
            default:
                return null;
        }
    }
}
