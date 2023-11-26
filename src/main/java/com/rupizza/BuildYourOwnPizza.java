package com.rupizza;

import java.util.ArrayList;

/**
 * Subclass of Pizza that represents the BuildYourOwnPizza option
 * @author Karthik Gangireddy, Vineal Sunkara
 */
public class BuildYourOwnPizza extends Pizza {
    private static final double BASE_PRICE = 14.99; // Base price of the pizza
    private static final double ADD_MEDIUM = 2.00; // extra charge for medium size
    private static final double ADD_LARGE = 4.00; // extra charge for large size
    private static final double ADD_MORE_TOPPINGS = 1.49; //extra charge for additional toppings past 3
    private static final int TOPPING_START = 4; //starting place in the toppings ArrayList since the first 3 are included in price

    /**
     * Default Constructor for building your own pizza
     */
    public BuildYourOwnPizza() {
    }

    /**
     * Calculates the price for a specialty pizza based on the size and number of toppings.
     * @return double containing price.
     */
    public double price() {
        double price = BASE_PRICE;
        if (this.size.getPizzaSize().equals("Medium")) {
            price += ADD_MEDIUM;
        } else if (this.size.getPizzaSize().equals("Large")) {
            price += ADD_LARGE;
        }
        for (int i = TOPPING_START; i < toppings.size(); i++) {
            price += ADD_MORE_TOPPINGS;
        }
        return price;
    }

    /**
     * Setter method to change toppings
     */
    public void setToppings(ArrayList<Topping> toppings) {this.toppings = toppings;}

    /**
     * Setter method to change pizza sauce
     */
    public void setSauce(Sauce sauce) {this.sauce = sauce;}

    /**
     * Setter method to change pizza size.
     *
     * @param size size of the pizza.
     */
    @Override
    public void setSize(Size size) {
        this.size = size;
    }

    /**
     * Setter method to change whether there is extra sauce or not.
     *
     * @param extraSauce whether there is extra sauce or not.
     */
    @Override
    public void setExtraSauce(boolean extraSauce) {
        this.extraSauce = extraSauce;
    }

    /**
     * Setter method to change whether there is extra sauce or not.
     *
     * @param extraCheese whether there is extra cheese or not.
     */
    @Override
    public void setExtraCheese(boolean extraCheese) {
        this.extraCheese = extraCheese;
    }

    /**
     * Returns a string representation of the pizza and it's toppings.
     * @return string containing pizza, toppings, size, etc.
     */
    @Override
    public String toString() {
        String pizza = "[Deluxe]";
        for (int i = 0; i < this.toppings.size(); i++) {
            pizza += " " + toppings.get(i).toString();
        }
        pizza += " " + this.sauce.getFlavor();
        pizza += " " + this.size.getPizzaSize() + " ";
        if (this.extraCheese) {
            pizza += "extraCheese ";
        }
        if (this.extraSauce) {
            pizza += "extraSauce ";
        }
        pizza += String.format("%.2f", this.price());
        return pizza;
    }
}
