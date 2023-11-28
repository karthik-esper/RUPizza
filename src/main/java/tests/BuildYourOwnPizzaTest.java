package tests;
import com.rupizza.*;

import static com.rupizza.PizzaMaker.createPizza;
import static org.junit.Assert.*;

import org.junit.Test;

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
        test.setToppings(toppers);
        test.setSize(Size.S);
        test.setExtraSauce(false);
        test.setExtraSauce(false); //price should 0 since there are less than 2 toppings
        assertTrue(test.price() == 0); //price should 0 since there are less than 2 toppings
    }

}
