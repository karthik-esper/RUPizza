package tests;
import com.rupizza.*;

import static com.rupizza.PizzaMaker.createPizza;
import static org.junit.Assert.*;

import org.junit.Test;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Junit test file for BuildYourOwnPizza price() method
 */
public class BuildYourOwnPizzaTest {
    /**
     * Test case #1: Number of toppings set to 2, which is below the minimum number of
     * required toppings
     */
    @org.junit.Test
    public void testTopsLessThan3() {
        Pizza test = createPizza("byop");
        ArrayList<Topping> toppers = new ArrayList<Topping>();
        toppers.add(Topping.PI);
        toppers.add(Topping.SAU);
        test.setToppings(toppers);
        test.setSize(Size.S);
        test.setExtraSauce(false);
        test.setExtraSauce(false); //price should 0 since there are less than 2 toppings
        assertTrue(test.price() == 0);
    }

    /**
     * Test case #2: Number of toppings set to 8, which is above the maximum number of
     * required toppings
     */
    @org.junit.Test
    public void testTopsGreaterThan7() {
        Pizza test = createPizza("byop");
        ArrayList<Topping> toppers = new ArrayList<Topping>();
        test.setToppings(toppers);
        toppers.add(Topping.PI);
        toppers.add(Topping.SAU);
        toppers.add(Topping.PE);
        toppers.add(Topping.SQ);
        toppers.add(Topping.HA);
        toppers.add(Topping.SH);
        toppers.add(Topping.JA);
        toppers.add(Topping.BO);
        test.setSize(Size.M);
        test.setExtraSauce(false);
        test.setExtraSauce(false); //price should 0 since there are greater than 7 toppings
        assertTrue(test.price() == 0);
    }
    /**
     * Test case #3: Number of toppings set to 3, which is the minimum number of
     * required toppings
     */
    @org.junit.Test
    public void testTopsIs3() {
        Pizza test = createPizza("byop");
        ArrayList<Topping> toppers = new ArrayList<Topping>();
        test.setToppings(toppers);
        toppers.add(Topping.SAU);
        toppers.add(Topping.SQ);
        toppers.add(Topping.GP);
        test.setSize(Size.L);
        test.setExtraSauce(false);
        test.setExtraSauce(false); //price should 12.99 since there are 3 toppings and size is large
        assertTrue(test.price() == 12.99);
    }

    /**
     * Test case #4: Number of toppings set to 7, which is the maximum number of
     * required toppings
     */
    @org.junit.Test
    public void testTopsIs7() {
        Pizza test = createPizza("byop");
        ArrayList<Topping> toppers = new ArrayList<Topping>();
        test.setToppings(toppers);
        toppers.add(Topping.HA);
        toppers.add(Topping.BO);
        toppers.add(Topping.PE);
        toppers.add(Topping.CM);
        toppers.add(Topping.MU);
        toppers.add(Topping.BE);
        toppers.add(Topping.ON);
        test.setSize(Size.S);
        test.setExtraSauce(false);
        test.setExtraSauce(false); //price should 14.95 since there are 7 toppings and size is small
        String value = String.format("%.2f", test.price());
        assertTrue(value.equals("14.95"));
    }
    /**
     * Test case #5: Number of toppings set to 5
     *
     */
    @org.junit.Test
    public void testTopIs5() {
        Pizza test = createPizza("byop");
        ArrayList<Topping> toppers = new ArrayList<Topping>();
        test.setToppings(toppers);
        toppers.add(Topping.PI);
        toppers.add(Topping.PE);
        toppers.add(Topping.MU);
        toppers.add(Topping.ON);
        toppers.add(Topping.BE);
        test.setSize(Size.S);
        test.setExtraSauce(false);
        test.setExtraSauce(false); //price should 11.97 since there are 5 toppings and size is small
        String value = String.format("%.2f", test.price());
        assertTrue(value.equals("11.97"));
    }
    /**
     * Test case #6: Number of toppings set to 5 and size is large
     *
     */
    @org.junit.Test
    public void testTopIs5AndLarge() {
        Pizza test = createPizza("byop");
        ArrayList<Topping> toppers = new ArrayList<Topping>();
        test.setToppings(toppers);
        toppers.add(Topping.HA);
        toppers.add(Topping.GP);
        toppers.add(Topping.BO);
        toppers.add(Topping.JA);
        toppers.add(Topping.SQ);
        test.setSize(Size.L);
        test.setExtraSauce(false);
        test.setExtraSauce(false); //price should 15.97 since there are 5 toppings and size is large
        String value = String.format("%.2f", test.price());
        assertTrue(value.equals("15.97"));
    }



}
