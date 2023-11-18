package com.rupizza;
import java.util.ArrayList;

/**
 * Abstract class used as the base class for any pizza type.
 * Shows the characteristics of the pizza using different enum classes.
 * @authors Karthik Gangireddy, Vineal Sunkara
 */
public abstract class Pizza {
    protected ArrayList<Topping> toppings; //Topping is a enum class
    protected Size size; //Size is a enum class
    protected Sauce sauce; //Sauce is a enum class
    protected boolean extraSauce;
    protected boolean extraCheese;

    public abstract double price(); //polymorphism
}
