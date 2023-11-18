package com.rupizza;

import java.util.ArrayList;

public class Pepperoni extends Pizza{
    private static final double BASE_PRICE = 10.99; // Base price of the pizza
    private static final double ADD_MEDIUM = 2.00; // extra charge for medium size
    private static final double ADD_LARGE = 4.00; // extra charge for large size

    private Pepperoni (Size size, boolean extraSauce, boolean extraCheese) {
        this.sauce = Sauce.TO;
        this.size = size;
        this.toppings = createToppings();
        this.extraSauce = extraSauce;
        this.extraCheese = extraCheese;
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
        toppers.add(Topping.PE);
        return toppers;
    }
}
