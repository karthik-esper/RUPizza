package com.rupizza;

public enum Size {
    S("Small"),
    M("Medium"),
    L("Large");

    private final String pizzaSize;

    private Size (String pizzaSize) {
        this.pizzaSize = pizzaSize;
    }

    private String getPizzaSize () {
        return this.pizzaSize;
    }
}
