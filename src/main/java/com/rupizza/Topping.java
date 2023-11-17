package com.rupizza;

public enum Topping {
    SAU("Sausage"),
    PE("Pepperoni"),
    BE("Beef"),
    HA("Ham"),
    SH("Shrimp"),
    SQ("Squid"),
    CM("Crab Meat"),
    GP("Green Pepper"),
    ON("Onion"),
    MU("Mushroom"),
    BO("Black Olive"),
    PI("Pineapple"),
    JA("Jalapeno");

    private final String toppingName;

    private Topping (String toppingName) {
        this.toppingName = toppingName;
    }
    public String getToppingName () {
        return this.toppingName;
    }
}
