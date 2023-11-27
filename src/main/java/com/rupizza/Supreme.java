package com.rupizza;

import java.util.ArrayList;

/**
 * Subclass of Pizza that represents the Supreme pizza option.
 * @author Karthik Gangireddy, Vineal Sunkara
 */
public class Supreme extends Pizza{
    private static final double BASE_PRICE = 15.99; // Base price of the pizza
    private static final double ADD_MEDIUM = 2.00; // extra charge for medium size
    private static final double ADD_LARGE = 4.00; // extra charge for large size
    private static final double EXTRA_CHARGE = 1.00; //charge for selecting extra sauce or cheese
    /**
     * Default constructor for a Supreme pizza.
     */
    public Supreme () {
        this.sauce = Sauce.TO;
        this.size = Size.S;
        this.toppings = createToppings();
    }

    /**
     * Calculates the price for a specialty pizza based on the size.
     * @return double containing price.
     */
    @Override
    public double price() {
        double price = BASE_PRICE;
        if (this.size.getPizzaSize().equals("Medium")){
            price += ADD_MEDIUM;
        }
        else if (this.size.getPizzaSize().equals("Large")){
            price += ADD_LARGE;
        }
        if (getExtraCheese()) {
            price += EXTRA_CHARGE;
        }
        if (getExtraSauce()) {
            price += EXTRA_CHARGE;
        }
        return price;
    }

    /**
     * Creates the toppings list for the specified pizza.
     * @return topping list for a Supreme pizza.
     */
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

    /**
     * Setter method to change pizza size.
     * @param size size of the pizza.
     */
    @Override
    public void setSize(Size size) {
        this.size = size;
    }

    /**
     * Setter method to change whether there is extra sauce or not.
     * @param extraSauce whether there is extra sauce or not.
     */
    @Override
    public void setExtraSauce(boolean extraSauce) {
        this.extraSauce = extraSauce;
    }

    /**
     * Setter method to change whether there is extra sauce or not.
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
        String pizza = "[Supreme]";
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
