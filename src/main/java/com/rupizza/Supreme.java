package com.rupizza;

import java.util.ArrayList;

public class Supreme extends Pizza{
    private static final double BASE_PRICE = 15.99; // Base price of the pizza
    private static final double ADD_MEDIUM = 2.00; // extra charge for medium size
    private static final double ADD_LARGE = 4.00; // extra charge for large size

    public Supreme () {
        this.sauce = Sauce.TO;
        this.size = Size.S;
        this.toppings = createToppings();
    }

    @Override
    public double price() {
        double price = BASE_PRICE;
        if (this.size.getPizzaSize().equals("Medium")){
            price += ADD_MEDIUM;
        }
        else if (this.size.getPizzaSize().equals("Large")){
            price += ADD_LARGE;
        }
        return price;
    }

    public ArrayList<Topping> createToppings() {
        ArrayList<Topping> toppers= new ArrayList<Topping>();
        toppers.add(Topping.SAU);
        toppers.add(Topping.PE);
        toppers.add(Topping.HA);
        toppers.add(Topping.GP);
        toppers.add(Topping.ON);
        toppers.add(Topping.BO);
        toppers.add(Topping.MU);
        return toppers;
    }
}
