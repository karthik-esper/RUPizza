package com.rupizza;
import java.util.ArrayList;

/**
 * Subclass of Pizza that represents the Deluxe pizza option.
 *
 * @author Karthik Gangireddy, Vineal Sunkara
 */
public class Deluxe extends Pizza{
    private static final double BASE_PRICE = 14.99; // Base price of the pizza
    private static final double ADD_MEDIUM = 2.00; // extra charge for medium size
    private static final double ADD_LARGE = 4.00; // extra charge for large size

    public Deluxe () {
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

    private ArrayList<Topping> createToppings() {
        ArrayList<Topping> toppers= new ArrayList<Topping>();
        toppers.add(Topping.SAU);
        toppers.add(Topping.PE);
        toppers.add(Topping.GP);
        toppers.add(Topping.ON);
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
    public void setExtraSauce(boolean extraSauce) {
        this.extraSauce = extraSauce;
    }

    /**
     * Setter method to change whether there is extra sauce or not.
     * @param extraCheese whether there is extra cheese or not.
     */
    public void setExtraCheese(boolean extraCheese) {
        this.extraCheese = extraCheese;
    }
}
